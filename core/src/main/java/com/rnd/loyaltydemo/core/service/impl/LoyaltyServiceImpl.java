package com.rnd.loyaltydemo.core.service.impl;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.rnd.loyaltydemo.core.bo.AccessTokenResponse;
import com.rnd.loyaltydemo.core.bo.ActivityByIdResponse;
import com.rnd.loyaltydemo.core.bo.LoyaltyProfile;
import com.rnd.loyaltydemo.core.bo.PointBalanceResponse;
import com.rnd.loyaltydemo.core.bo.PointsActivtyDetails;
import com.rnd.loyaltydemo.core.bo.PointsSummaryResponse;
import com.rnd.loyaltydemo.core.bo.ReferralCode;
import com.rnd.loyaltydemo.core.bo.RestServiceResponse;
import com.rnd.loyaltydemo.core.config.ContextAwareConfig;
import com.rnd.loyaltydemo.core.constants.LoyaltyDemoConstants;
import com.rnd.loyaltydemo.core.service.LoyaltyService;
import com.rnd.loyaltydemo.core.service.RESTServiceFramework;

/**
 * Loyalty Service Implementation
 * 
 */
@Component(service = LoyaltyService.class, name = "Loyalty Demo Service", immediate = true)
public class LoyaltyServiceImpl implements LoyaltyService {

	private static final String LOYALTY_PROFILE_ID = "{profileId}";

	private static final String LOYALTY_TRANSACTION_ID = "{transactionId}";

	private static final String ORDER_ID = "{orderId}";

	private static final String O_AUTH = "OAuth";

	private static final String BASIC = "Basic";

	private static final String CONTENT_TYPE = "Content-Type";

	private static final String ACCEPT_LANGUAGE = "Accept-Language";

	private static final String PROGRAM_CODE = "Program-Code";

	private static final String AUTHORIZATION = "Authorization";

	private static final String GRANT_TYPE = "grant_type";

	private static final Logger log = LoggerFactory.getLogger(LoyaltyServiceImpl.class);

	@Reference
	RESTServiceFramework restService;

	@Reference
	private ResourceResolverFactory resolverFactory;

	/**
	 * Login method
	 * 
	 * @param username
	 * @param password
	 * @param config
	 * @return AccessTokenResponse
	 */
	@Override
	public AccessTokenResponse login(final String username, final String password, final ContextAwareConfig config) {
		log.debug("Start of Login API call method");
		final Map<String, String> headers = getBasicRequestHeaders(config);
		headers.put(GRANT_TYPE, LoyaltyDemoConstants.LOGIN_GRANT_TYPE);

		final StringBuilder requestBodyString = new StringBuilder();
		requestBodyString.append(GRANT_TYPE).append(LoyaltyDemoConstants.EQUAL)
				.append(LoyaltyDemoConstants.LOGIN_GRANT_TYPE);
		requestBodyString.append(LoyaltyDemoConstants.USERNAME).append(LoyaltyDemoConstants.EQUAL).append(username);
		requestBodyString.append(LoyaltyDemoConstants.PASSWORD).append(LoyaltyDemoConstants.EQUAL).append(password);
		requestBodyString.append(LoyaltyDemoConstants.RESPONSE_TYPE).append(LoyaltyDemoConstants.EQUAL)
				.append(LoyaltyDemoConstants.TOKEN);

		final RestServiceResponse loginResponse = restService.makePostWSCall(
				config.loyaltyDomain() + config.loyaltyTokenEndPointURL(), requestBodyString.toString(),
				headers);

		if (loginResponse != null && StringUtils.isNotBlank(loginResponse.getResponse())) {
			final Gson gson = new Gson();
			AccessTokenResponse accessTokenResponse = gson.fromJson(loginResponse.getResponse(),
					AccessTokenResponse.class);
			accessTokenResponse.setStatusCode(loginResponse.getStatusCode());
			return accessTokenResponse;
		}

		return null;
	}

	/**
	 * Basic authorization request headers
	 * 
	 * @param config
	 * @return Map<String,String>
	 */
	private Map<String, String> getBasicRequestHeaders(final ContextAwareConfig config) {
		final String credetialsString = config.loyaltyProgramUserName() + ":" + config.loyaltyProgramPassword();
		final byte[] authBytes = credetialsString.getBytes(StandardCharsets.UTF_8);
		final String encodedCredentials = Base64.getEncoder().encodeToString(authBytes);
		final Map<String, String> headers = new HashMap<>();
		headers.put(AUTHORIZATION, BASIC + StringUtils.SPACE + encodedCredentials);
		headers.put(PROGRAM_CODE, config.loyaltyProgramCode());
		headers.put(ACCEPT_LANGUAGE, LoyaltyDemoConstants.ACCEPT_LANGUAGE);
		headers.put(CONTENT_TYPE, LoyaltyDemoConstants.APPLICATION_FORM_ENCODED);
		return headers;
	}

	/**
	 * O_Auth authorization request headers
	 * 
	 * @param accesToken
	 * @param config
	 * @return Map<String, String>
	 */
	private Map<String, String> getoAuthReuestHeaders(final String accesToken, final ContextAwareConfig config) {
		final Map<String, String> headers = new HashMap<>();
		headers.put(AUTHORIZATION, O_AUTH + StringUtils.SPACE + accesToken);
		headers.put(PROGRAM_CODE, config.loyaltyProgramCode());
		headers.put(ACCEPT_LANGUAGE, LoyaltyDemoConstants.ACCEPT_LANGUAGE);
		return headers;
	}

	/**
	 * authorization request headers with Content-Type
	 * 
	 * @param accesToken
	 * @param config
	 * @return Map<String, String>
	 */
	private Map<String, String> getoAuthReuestHeadersWithContentType(final String accesToken,
			final ContextAwareConfig config) {
		final Map<String, String> headers = getoAuthReuestHeaders(accesToken, config);
		headers.put(CONTENT_TYPE, LoyaltyDemoConstants.APPLICATION_JSON);
		return headers;
	}

	/**
	 * get Referral Code from Loyalty Referral Code API.
	 * 
	 * @param accesToken
	 * @param loyaltyProfileID
	 * @param config
	 * @return referralCode
	 */
	@Override
	public ReferralCode getUserReffralCode(final String loyaltyProfileID, final String accesToken,
			final ContextAwareConfig config) {
		log.debug("Start of getUserReffralCode API call method");
		final RestServiceResponse responseObject = restService.makePostWSCall(
				config.loyaltyDomain()
						+ config.loyaltyUserReffralCodeEndPointURL().replace(LOYALTY_PROFILE_ID, loyaltyProfileID),
				getoAuthReuestHeadersWithContentType(accesToken, config));
		if (responseObject != null && StringUtils.isNotBlank(responseObject.getResponse())) {
			final Gson gson = new Gson();
			ReferralCode referralCode = gson.fromJson(responseObject.getResponse(), ReferralCode.class);
			referralCode.setStatusCode(responseObject.getStatusCode());
			return referralCode;
		}
		return null;

	}

	/**
	 * Profile Point Balance
	 * 
	 * @param loyaltyProfileID
	 * @param accesToken
	 * @param config
	 * @return PointBalance
	 */
	@Override
	public PointBalanceResponse getProfilePointBalance(final String loyaltyProfileID, final String accesToken,
			final ContextAwareConfig config) {
		log.debug("Start of getProfilePointBalance API call method");
		RestServiceResponse responseModel = restService.makeGetWSCall(
				config.loyaltyDomain()
						+ config.loyaltyPointBalanceEndPointURL().replace(LOYALTY_PROFILE_ID, loyaltyProfileID),
				getoAuthReuestHeaders(accesToken, config));
		if (responseModel != null && StringUtils.isNotBlank(responseModel.getResponse())) {
			final Gson gson = new Gson();
			PointBalanceResponse pointBalance = gson.fromJson(responseModel.getResponse(), PointBalanceResponse.class);
			pointBalance.setStatusCode(responseModel.getStatusCode());
			return pointBalance;
		}
		return null;
	}

	/**
	 * Profile Details
	 * 
	 * @param profileId
	 * @param accesToken
	 * @param config
	 * @return responseModel
	 */
	@Override
	public LoyaltyProfile getProfile(final String accesToken, final String profileId, final ContextAwareConfig config) {
		log.debug("Start of getProfile API call method");
		RestServiceResponse responseModel = restService.makeGetWSCall(
				config.loyaltyDomain() + config.loyaltyProfileEndPointURL().replace(LOYALTY_PROFILE_ID, profileId),
				getoAuthReuestHeaders(accesToken, config));
		if (responseModel != null && StringUtils.isNotBlank(responseModel.getResponse())) {
			final Gson gson = new Gson();
			LoyaltyProfile loyaltyProfile = gson.fromJson(responseModel.getResponse(), LoyaltyProfile.class);
			loyaltyProfile.setStatusCode(responseModel.getStatusCode());
			return loyaltyProfile;
		}
		return null;

	}

	/**
	 * Profile Point Summary
	 *
	 * @param loyaltyProfileID
	 * @param accesToken
	 * @param config
	 * @return PointsSummaryResponse
	 */
	@Override
	public PointsSummaryResponse getProfilePointSummary(final String loyaltyProfileID, final String accesToken,
														 final ContextAwareConfig config) {
		RestServiceResponse responseModel = restService.makeGetWSCall(
				config.loyaltyDomain() + config.loyaltyPointSummaryEndPointURL().replace(LOYALTY_PROFILE_ID, loyaltyProfileID),
				getoAuthReuestHeadersWithContentType(accesToken, config));

		if (responseModel != null && StringUtils.isNotBlank(responseModel.getResponse())) {
			final Gson gson = new Gson();
			PointsActivtyDetails pointSummaryResponse[] = gson.fromJson(responseModel.getResponse(), PointsActivtyDetails[].class);
			PointsSummaryResponse finalResponse=new PointsSummaryResponse();
			finalResponse.setResponse(pointSummaryResponse);
			finalResponse.setStatusCode(responseModel.getStatusCode());
			return finalResponse;
		}
		return null;
	}

	/**
	 * Profile Order By Id
	 *
	 * @param transactionId
	 * @param profileId
	 * @param accessToken
	 * @param contextAwareConfig
	 */
	@Override
	public ActivityByIdResponse getProfileOrderById(String transactionId, String profileId, String accessToken, ContextAwareConfig contextAwareConfig) {
		String replaceProfileId = contextAwareConfig.loyaltyDomain() + contextAwareConfig.loyaltyProfileOrderByIdURL().replace(LOYALTY_PROFILE_ID, profileId);
		String loyaltyTransactionsByIdURL = replaceProfileId.replace(ORDER_ID, transactionId);
		RestServiceResponse responseModel = restService.makeGetWSCall(loyaltyTransactionsByIdURL,
				getoAuthReuestHeadersWithContentType(accessToken, contextAwareConfig));
		if (responseModel != null && StringUtils.isNotBlank(responseModel.getResponse())) {
			final Gson gson = new Gson();
			ActivityByIdResponse activityByIdResponse = gson.fromJson(responseModel.getResponse(), ActivityByIdResponse.class);
			activityByIdResponse.setStatusCode(responseModel.getStatusCode());
			return activityByIdResponse;
		}
		return null;
	}

	/**
	 * Profile Transactions By Id
	 *
	 * @param transactionId
	 * @param profileId
	 * @param accessToken
	 * @param contextAwareConfig
	 */
	@Override
	public ActivityByIdResponse getProfileTransactionsById(String transactionId, String profileId, String accessToken, ContextAwareConfig contextAwareConfig) {
		String replaceProfileId = contextAwareConfig.loyaltyDomain() +contextAwareConfig.loyaltyTransactionsByIdURL().replace(LOYALTY_PROFILE_ID, profileId);
		String loyaltyTransactionsByIdURL = replaceProfileId.replace(LOYALTY_TRANSACTION_ID, transactionId);
		RestServiceResponse responseModel = restService.makeGetWSCall(loyaltyTransactionsByIdURL,
				getoAuthReuestHeaders(accessToken, contextAwareConfig));
		if (responseModel != null && StringUtils.isNotBlank(responseModel.getResponse())) {
			final Gson gson = new Gson();
			ActivityByIdResponse activityByIdResponse = gson.fromJson(responseModel.getResponse(), ActivityByIdResponse.class);
			activityByIdResponse.setStatusCode(responseModel.getStatusCode());
			return activityByIdResponse;
		}
		return null;
	}

}
