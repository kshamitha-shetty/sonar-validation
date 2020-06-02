package com.rnd.loyaltydemo.core.models;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.acs.commons.util.CookieUtil;
import com.rnd.loyaltydemo.core.bo.AccessTokenResponse;
import com.rnd.loyaltydemo.core.bo.LoyaltyProfile;
import com.rnd.loyaltydemo.core.bo.PointBalanceResponse;
import com.rnd.loyaltydemo.core.config.ContextAwareConfig;
import com.rnd.loyaltydemo.core.constants.CookieConstants;
import com.rnd.loyaltydemo.core.constants.GlobalConstants;
import com.rnd.loyaltydemo.core.service.LoyaltyService;
import com.rnd.loyaltydemo.core.utils.CommonUtil;
import com.rnd.loyaltydemo.core.utils.ContextAwareConfigUtilService;

/**
 * The Class LoyaltyProfileModel.
 *
 * @author kshamitha
 *
 */
/**
 * @author kshamitha
 *
 */
@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class LoyaltyProfileDetailsModel {

	private static final Logger log = LoggerFactory.getLogger(LoyaltyProfileDetailsModel.class);
	@Inject
	private LoyaltyService loyaltyService;
	
	@Inject
	private ContextAwareConfigUtilService caConfigUtilService;

	LoyaltyProfile loyaltyProfile;

	@Self
	private SlingHttpServletRequest request;

	@Inject
	private ResourceResolver resResolver;

	@SlingObject
	private SlingHttpServletResponse response;

	private int points = 0;
	private boolean loggedIn = false;
	private String cookiePrefix;

	private AccessTokenResponse accessTokenResponse;
	private PointBalanceResponse pointBalance;

	/**
	 * 
	 * 
	 */
	@PostConstruct
	protected void init() {
		try {
			ContextAwareConfig contextAwareConfig = caConfigUtilService.getContextAwareConfig(request);
			cookiePrefix = contextAwareConfig.cookiePrefix();
			accessTokenResponse = CommonUtil.getAccessTokenData(request, cookiePrefix);

			if (null != accessTokenResponse && StringUtils.isNotBlank(accessTokenResponse.getProfileId())
					&& StringUtils.isNotBlank(accessTokenResponse.getAccessToken())) {
				loyaltyProfile = getProfile(accessTokenResponse, contextAwareConfig);
				if (null != loyaltyProfile && loyaltyProfile.getStatusCode() == HttpServletResponse.SC_OK) {
					createProfileCookie(loyaltyProfile, contextAwareConfig);
					request.setAttribute("pointBalance", pointBalance);
					request.setAttribute("loyaltyProfile", loyaltyProfile);
					request.setAttribute("loggedIn", true);
					loggedIn = Boolean.TRUE;
				}
			} else if (CookieUtil.getCookie(request, cookiePrefix + CookieConstants.ACCESS_TOKEN_COOKIE_NAME) != null) {
				CommonUtil.deleteCookie(request,response, cookiePrefix, CookieConstants.ACCESS_TOKEN_COOKIE_NAME,
						CookieConstants.DEFAULT_COOKIE_PATH,Boolean.FALSE,Boolean.TRUE);
			}

		} catch (final Exception e) {
			log.error("LoyaltyProfileDetailsModel : error  :{} ", e.getMessage());
		}
		log.info("LoyaltyProfileDetailsModel :: init :: End");
	}

	/**
	 * Get user profile and create the required cookie
	 * 
	 * @param loyaltyProfile
	 * @param contextAwareConfig
	 * 
	 */
	private void createProfileCookie(LoyaltyProfile loyaltyProfile, ContextAwareConfig contextAwareConfig) {
		if (loyaltyProfile != null) {
			try {
				String cookiePath = CookieConstants.DEFAULT_COOKIE_PATH;
				if (StringUtils.isNotBlank(loyaltyProfile.getGamerAvatar())) {
					String imagePath = contextAwareConfig.loyaltyImageUploadFolder() + GlobalConstants.FORWARD_SLASH
							+ loyaltyProfile.getGamerAvatar();
					Resource imgRes = resResolver.getResource(imagePath);
					if (imgRes != null) {
						loyaltyProfile.setGamerAvatarAemImageUrl(imagePath);
					}

				}
				pointBalance = getPointBalance(accessTokenResponse, contextAwareConfig);
				if (null != pointBalance && pointBalance.getStatusCode() == HttpServletResponse.SC_OK) {
					points = (int) Math.round(pointBalance.getPointsBalance().get(0).getPointAmount());
					if (Boolean.TRUE.equals(loyaltyProfile.getInLinkedPool())) {
						points = (int) Math.round(pointBalance.getPoolingPointsBalance().get(0).getPointAmount());
					}
				}
			    request.setAttribute(CookieConstants.COOKIE_PREFIX, cookiePrefix);
				CommonUtil.createCookie(response, cookiePrefix, CookieConstants.USER_NAME_COOKIE_NAME,
						URLEncoder.encode(loyaltyProfile.getUsername(), StandardCharsets.UTF_8.toString()),
						contextAwareConfig.cookieExpiry(), cookiePath, Boolean.FALSE, Boolean.FALSE);
				request.setAttribute(CookieConstants.USER_NAME_COOKIE_NAME, loyaltyProfile.getUsername());

				CommonUtil.createCookie(response, cookiePrefix, CookieConstants.USER_FIRST_NAME_COOKIE_NAME,
						URLEncoder.encode(loyaltyProfile.getFirstName(), StandardCharsets.UTF_8.toString()),
						contextAwareConfig.cookieExpiry(), cookiePath, Boolean.FALSE, Boolean.FALSE);
				request.setAttribute(CookieConstants.USER_FIRST_NAME_COOKIE_NAME, loyaltyProfile.getFirstName());

				CommonUtil.createCookie(response, cookiePrefix, CookieConstants.USER_POINTS_COOKIE_NAME,
						Integer.toString(points), contextAwareConfig.cookieExpiry(), cookiePath, Boolean.FALSE,
						Boolean.FALSE);
				request.setAttribute(CookieConstants.USER_POINTS_COOKIE_NAME, Integer.toString(points));

				CommonUtil.createCookie(response, cookiePrefix, CookieConstants.USER_CARDNUM_COOKIE_NAME,
						loyaltyProfile.getCardNumber(), contextAwareConfig.cookieExpiry(), cookiePath, Boolean.FALSE,
						Boolean.FALSE);
				request.setAttribute(CookieConstants.USER_CARDNUM_COOKIE_NAME, loyaltyProfile.getCardNumber());
				CommonUtil.createCookie(response, cookiePrefix, CookieConstants.USER_TIER_COOKIE_NAME,
						URLEncoder.encode(loyaltyProfile.getTierName(), StandardCharsets.UTF_8.toString()),
						contextAwareConfig.cookieExpiry(), cookiePath, Boolean.FALSE, Boolean.FALSE);
				request.setAttribute(CookieConstants.USER_TIER_COOKIE_NAME, loyaltyProfile.getTierName());

				CommonUtil.createCookie(response, cookiePrefix, CookieConstants.USER_LINKEDPOOL_COOKIE_NAME,
						String.valueOf(loyaltyProfile.getInLinkedPool()), contextAwareConfig.cookieExpiry(), cookiePath,
						Boolean.FALSE, Boolean.FALSE);
				request.setAttribute(CookieConstants.USER_LINKEDPOOL_COOKIE_NAME,
						String.valueOf(loyaltyProfile.getInLinkedPool()));

			} catch (final Exception e) {
				log.error("LoyaltyProfileModel : LoyaltyProfileModel : error  whie getting points: ", e);
			}
		}
	}

	/**
	 * @param accessTokenResponse
	 * @param config
	 * @return PointBalance
	 */
	private PointBalanceResponse getPointBalance(final AccessTokenResponse accessTokenResponse,
			final ContextAwareConfig config) {
		return loyaltyService.getProfilePointBalance(accessTokenResponse.getProfileId(),
				accessTokenResponse.getAccessToken(), config);
	}

	/**
	 * @param accessTokenResponse
	 * @param config
	 * @return LoyaltyProfile
	 */
	private LoyaltyProfile getProfile(final AccessTokenResponse accessTokenResponse, final ContextAwareConfig config) {
		return loyaltyService.getProfile(accessTokenResponse.getAccessToken(), accessTokenResponse.getProfileId(),
				config);
	}

	public LoyaltyProfile getLoyaltyProfile() {
		return loyaltyProfile;
	}

	public int getLoyaltyPoints() {
		return points;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}
	
	public String getCookiePrefix() {
		return cookiePrefix;
	}

}
