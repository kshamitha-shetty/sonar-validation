package com.rnd.loyaltydemo.core.utils;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.acs.commons.util.CookieUtil;
import com.google.gson.Gson;
import com.rnd.loyaltydemo.core.bo.AccessTokenResponse;
import com.rnd.loyaltydemo.core.constants.CookieConstants;

/**
 * Common utility class
 * 
 */

public class CommonUtil {

	private CommonUtil() {
		// Restricting Instantiation
	}

	/**
	 * Logger configuration for CommonUtil
	 */
	private static final Logger log = LoggerFactory.getLogger(CommonUtil.class);

	public static final String GENERIC_ERRORCODE = "403";
	public static final String PSWD_EXPIRED_MSG = "Password expired please contact support.";

	/**
	 * Setting cookie info to AccessTokenResponse POJO
	 * 
	 * @param request
	 * @param cookiePrefix
	 * @return AccessTokenResponse
	 */
	public static AccessTokenResponse getAccessTokenData(SlingHttpServletRequest request, String cookiePrefix) {
		final Cookie loyaltyAccessTokenCookieRead = CookieUtil.getCookie(request,
				cookiePrefix + CookieConstants.ACCESS_TOKEN_COOKIE_NAME);
						log.info("CommonUtilsaccesscookie"+loyaltyAccessTokenCookieRead);
		final Cookie profileIDCookieRead = CookieUtil.getCookie(request,
				cookiePrefix + CookieConstants.PROFILE_ID_COOKIE_NAME);
						log.info("CommonUtilsprofile"+loyaltyAccessTokenCookieRead);
		AccessTokenResponse accessTokenResponse = null;
		if (loyaltyAccessTokenCookieRead != null && profileIDCookieRead != null
				&& !StringUtils.isBlank(loyaltyAccessTokenCookieRead.getValue())
				&& !StringUtils.isBlank(profileIDCookieRead.getValue())) {

			accessTokenResponse = new AccessTokenResponse();
			accessTokenResponse.setAccessToken(loyaltyAccessTokenCookieRead.getValue());
			accessTokenResponse.setProfileId(profileIDCookieRead.getValue());
		}
		return accessTokenResponse;
	}

	/**
	 * Creating cookie while logging in
	 * 
	 * @param response
	 * @param prefix
	 * @param cookieName
	 * @param value
	 * @param expiry
	 * @param cookiePath
	 * @param secure
	 * @param httpSecure
	 * @return Cookie
	 */
	public static Cookie createCookie(SlingHttpServletResponse response, String prefix, String cookieName, String value,
			int expiry, String cookiePath, boolean secure, boolean httpSecure) {
		final Cookie cookie = new Cookie(prefix + cookieName, value);
		cookie.setMaxAge(expiry);
		cookie.setPath(cookiePath);
		cookie.setSecure(secure);
		cookie.setHttpOnly(httpSecure);
		CookieUtil.addCookie(cookie, response);
		return cookie;
	}
	
	/**
	 * Delete cookie from request.
	 * 
	 * @param request
	 * @param cookiePrefix
	 * @param cookieName
	 */
	public static void deleteCookie(SlingHttpServletRequest request, SlingHttpServletResponse response, String cookiePrefix, String cookieName,
			 String cookiePath, boolean secure, boolean httpSecure) {
		final Cookie cookie = CookieUtil.getCookie(request,
				cookiePrefix + cookieName);
		if (cookie != null) {
			cookie.setPath(cookiePath);
			cookie.setMaxAge(0);
			cookie.setHttpOnly(httpSecure);
			cookie.setSecure(secure);
	        response.addCookie(cookie);
		}
	}

	/**
	 * Converting JSON object to Generic object
	 * 
	 * @param jsonString
	 * @param obj
	 * @return Object
	 */
	public static Object getObjectFromJson(final String jsonString, final Object obj) {
		final Gson gson = new Gson();
		Object returnValue = null;
		try {
			returnValue = gson.fromJson(jsonString, obj.getClass());
		} catch (final Exception e) {
			log.error("Exception occured in CommonUtil :: getObjectFromJson {}", e);
		}
		return returnValue;
	}

	/**
	 * Converting Generic object to JSON string
	 * 
	 * @param obj
	 * @return String
	 */
	public static String getJsonFromObject(final Object obj) {
		final Gson gson = new Gson();
		String json = null;
		try {
			json = gson.toJson(obj);
		} catch (final Exception e) {
			log.error("Exception occured in CommonUtil :: getJsonFromObject {}", e);
		}
		return json;
	}

	/**
	 * Generic Response Error message
	 * 
	 * @param SlingHttpServletResponse, String
	 */
	public static void sendGenericResponseError(final SlingHttpServletResponse response, final String message)
			throws IOException {
		AccessTokenResponse res = new AccessTokenResponse();
		res.setErrorCode(GENERIC_ERRORCODE);
		res.setMessage(message);
		response.getWriter().write(CommonUtil.getJsonFromObject(res));
	}

	/**
	 * Generic Response Success message
	 * 
	 * @param SlingHttpServletResponse
	 */
	public static void sendGenericResponseSuccess(final SlingHttpServletResponse response) throws IOException {
		AccessTokenResponse res = new AccessTokenResponse();
		res.setStatusCode(HttpServletResponse.SC_OK);
		response.getWriter().write(CommonUtil.getJsonFromObject(res));
	}

	/**
	 * Generic Response PAssword Expiry message
	 * 
	 * @param SlingHttpServletResponse
	 */
	public static void sendGenericResponsePasswordExpiry(final SlingHttpServletResponse response) throws IOException {
		AccessTokenResponse res = new AccessTokenResponse();
		res.setMessage(PSWD_EXPIRED_MSG);
		res.setPwdExpired(Boolean.TRUE);
		response.getWriter().write(CommonUtil.getJsonFromObject(res));
	}

}
