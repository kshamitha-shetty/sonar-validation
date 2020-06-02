package com.rnd.loyaltydemo.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.propertytypes.ServiceDescription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.rnd.loyaltydemo.core.bo.AccessTokenResponse;
import com.rnd.loyaltydemo.core.bo.ReferralCode;
import com.rnd.loyaltydemo.core.config.ContextAwareConfig;
import com.rnd.loyaltydemo.core.constants.LoyaltyDemoConstants;
import com.rnd.loyaltydemo.core.service.LoyaltyService;
import com.rnd.loyaltydemo.core.utils.CommonUtil;
import com.rnd.loyaltydemo.core.utils.ContextAwareConfigUtilService;

@ServiceDescription("Get Referral Code Servlet")
@Component(immediate = true, service = Servlet.class, property = { "sling.servlet.selectors=referralCode",
		"sling.servlet.extensions=json", "sling.servlet.resourcetypes=cq:Page",
		"sling.servlet.methods=" + HttpConstants.METHOD_GET })
public class GetReferalCodeServlet extends SlingAllMethodsServlet {

	private static final long serialVersionUID = 4887111267327829568L;
	private static final Logger log = LoggerFactory.getLogger(GetReferalCodeServlet.class);

	@Reference
	private transient LoyaltyService loyaltyService;
	
	@Reference
	private transient ContextAwareConfigUtilService caConfigUtilService;
	
	/**
	 * doGet method for referral code .
	 * 
	 * @param SlingHttpServletRequest  - request object
	 * @param SlingHttpServletResponse - response object
	 * 
	 */
	@Override
	protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(LoyaltyDemoConstants.APPLICATION_JSON);
		response.setCharacterEncoding(LoyaltyDemoConstants.UTF_8);
		String finalJson = StringUtils.EMPTY;
		try {
			ContextAwareConfig contextAwareConfig = caConfigUtilService.getContextAwareConfig(request);
			if (contextAwareConfig == null) {
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				return;
			}
			AccessTokenResponse accessTokenResponse = CommonUtil.getAccessTokenData(request,
					contextAwareConfig.cookiePrefix());
			if (accessTokenResponse != null && StringUtils.isNotBlank(accessTokenResponse.getAccessToken())
					&& StringUtils.isNotBlank(accessTokenResponse.getProfileId())) {
				ReferralCode getReffralCode = loyaltyService.getUserReffralCode(accessTokenResponse.getProfileId(),
						accessTokenResponse.getAccessToken(), contextAwareConfig);
				finalJson = new Gson().toJson(getReffralCode);
			}
			response.getWriter().write(finalJson);
		} catch (Exception e) {
			log.error("Get Refferal code servlet:Error Occured::{}", e.getMessage());
			CommonUtil.sendGenericResponseError(response, StringUtils.EMPTY);
		}
	}
}
