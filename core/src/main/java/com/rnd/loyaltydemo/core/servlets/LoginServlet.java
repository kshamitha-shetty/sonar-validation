package com.rnd.loyaltydemo.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.propertytypes.ServiceDescription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rnd.loyaltydemo.core.bo.AccessTokenResponse;
import com.rnd.loyaltydemo.core.config.ContextAwareConfig;
import com.rnd.loyaltydemo.core.constants.CookieConstants;
import com.rnd.loyaltydemo.core.constants.LoyaltyDemoConstants;
import com.rnd.loyaltydemo.core.service.LoyaltyService;
import com.rnd.loyaltydemo.core.utils.CommonUtil;
import com.rnd.loyaltydemo.core.utils.ContextAwareConfigUtilService;

/**
 * Login Authentication Servlet class
 * 
 */

@ServiceDescription("Login Authentication Servlet")
@Component(immediate = true, service = Servlet.class, property = { "sling.servlet.selectors=loginToken",
		"sling.servlet.extensions=json", "sling.servlet.resourcetypes=cq:Page",
		"sling.servlet.methods=" + HttpConstants.METHOD_POST })
public class LoginServlet extends SlingAllMethodsServlet {

	private static final long serialVersionUID = 7485497505460995864L;
	private static final Logger log = LoggerFactory.getLogger(LoginServlet.class);

	private static final String USERNAME = "j_username";
	private static final String PSWD_PARAM = "j_password";

	@Reference
	private transient ResourceResolverFactory resolverFactory;

	@Reference
	private transient LoyaltyService loyaltyService;
	
	@Reference
	private transient ContextAwareConfigUtilService caConfigUtilService;

	/**
	 * doPost method for authenticating user
	 * 
	 * @param SlingHttpServletRequest  - request object
	 * @param SlingHttpServletResponse - response object
	 * 
	 */
	@Override
	protected void doPost(final SlingHttpServletRequest request, final SlingHttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType(LoyaltyDemoConstants.APPLICATION_JSON);
		response.setCharacterEncoding(LoyaltyDemoConstants.UTF_8);

		final String username = request.getParameter(USERNAME);
		final String password = request.getParameter(PSWD_PARAM);

		if (username == null || username.length() == 0 || password == null || password.length() == 0) {
			log.debug("LoginServlet : doPost : mandatory params missing, returning fail auth");
			CommonUtil.sendGenericResponseError(response, StringUtils.EMPTY);
			return;
		}

		AccessTokenResponse accessTokenResponse = new AccessTokenResponse();
		ContextAwareConfig contextAwareConfig = null;
		try {

			contextAwareConfig = caConfigUtilService.getContextAwareConfig(request);
			accessTokenResponse = loyaltyService.login(username, password, contextAwareConfig);

		} catch (final Exception e) {
			CommonUtil.sendGenericResponseError(response, StringUtils.EMPTY);
			log.error("LoginServlet : doPost : error authenticating  : {} ", e);
			return;
		}

		if (accessTokenResponse != null && accessTokenResponse.getSuccess() != null && Boolean.TRUE.equals(accessTokenResponse.getSuccess())
				&& StringUtils.isNotBlank(accessTokenResponse.getAccessToken())
				&& Boolean.FALSE.equals(accessTokenResponse.getIsPasswordExpired())) {
			try {
				String cookiePath = CookieConstants.DEFAULT_COOKIE_PATH;
				String cookiePrefix = contextAwareConfig.cookiePrefix();
				CommonUtil.createCookie(response, cookiePrefix, CookieConstants.ACCESS_TOKEN_COOKIE_NAME,
						accessTokenResponse.getAccessToken(), contextAwareConfig.cookieExpiry(), cookiePath,
						Boolean.FALSE, Boolean.TRUE);
				log.info("LoginServlet : GEZt POST : user [{}] authenticated loyaltydemoly",
						accessTokenResponse.getUsername());

				CommonUtil.createCookie(response, cookiePrefix, CookieConstants.PROFILE_ID_COOKIE_NAME,
						accessTokenResponse.getProfileId(), contextAwareConfig.cookieExpiry(), cookiePath,
						Boolean.FALSE, Boolean.FALSE);
				CommonUtil.sendGenericResponseSuccess(response);
			} catch (final Exception e) {
				log.error("LoginServlet : doPost : Could not formulate JSON response {}", e.getMessage());
				CommonUtil.sendGenericResponseError(response, StringUtils.EMPTY);
			}
		} else {
			if (accessTokenResponse != null && StringUtils.isNotBlank(accessTokenResponse.getMessage())) {
				CommonUtil.sendGenericResponseError(response, accessTokenResponse.getMessage());
			} else if (accessTokenResponse != null && accessTokenResponse.getIsPasswordExpired()) {
				CommonUtil.sendGenericResponsePasswordExpiry(response);
			}
		}
	}

}
