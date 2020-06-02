package com.rnd.loyaltydemo.core.servlets;

import javax.servlet.Servlet;
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
import com.rnd.loyaltydemo.core.bo.ActivityByIdResponse;
import com.rnd.loyaltydemo.core.bo.PointsSummaryResponse;
import com.rnd.loyaltydemo.core.config.ContextAwareConfig;
import com.rnd.loyaltydemo.core.constants.LoyaltyDemoConstants;
import com.rnd.loyaltydemo.core.service.LoyaltyService;
import com.rnd.loyaltydemo.core.utils.CommonUtil;
import com.rnd.loyaltydemo.core.utils.ContextAwareConfigUtilService;

@ServiceDescription("Points Summary Servlet")
@Component(immediate = true, service = Servlet.class, property = {
		"sling.servlet.selectors=" + PointsSummaryServlet.ACTIVITY_SUMMARY_LIST,
		"sling.servlet.selectors=" + PointsSummaryServlet.ACTIVITY_BY_ID,
		"sling.servlet.extensions=json",
		"sling.servlet.resourcetypes=cq:Page",
		"sling.servlet.methods=" + HttpConstants.METHOD_GET })
public class PointsSummaryServlet extends SlingAllMethodsServlet {
	
	public static final String ACTIVITY_SUMMARY_LIST = "activitySummaryList";
	
	public static final String ACTIVITY_BY_ID = "activityById";
	
	public static final String ACTIVITY_ID = "activityId";

	public static final String ORDER_DETAILS = "orderDetails";
	
	public static final String TRANSACTION_DETAILS = "transactionDetails";
	
	public static final String TYPE = "type";
	
	@Reference
	private transient LoyaltyService loyaltyService;
	
	private static final long serialVersionUID = 1L;
	
	@Reference
	private transient ContextAwareConfigUtilService caConfigUtilService;
	
	private static final Logger log = LoggerFactory.getLogger(PointsSummaryServlet.class);
	
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {
		response.setContentType(LoyaltyDemoConstants.APPLICATION_JSON);
		response.setCharacterEncoding(LoyaltyDemoConstants.UTF_8);
		log.debug("PointsSummaryServlet :: GET :: START::");
		String finalJson = "";
		ContextAwareConfig contextAwareConfig = null;
		try {
			contextAwareConfig = caConfigUtilService.getContextAwareConfig(request);
			if (contextAwareConfig == null) {
	             response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	            return;
	        }
			AccessTokenResponse accessTokenResponse = CommonUtil.getAccessTokenData(request, contextAwareConfig.cookiePrefix());
			if (accessTokenResponse == null || StringUtils.isBlank(accessTokenResponse.getAccessToken())
					|| StringUtils.isBlank(accessTokenResponse.getProfileId())) {
	             log.error("Profile ID/Access Token is not available in the cookie.");
	             response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	             return;
	        }
			String activityId = request.getParameter(ACTIVITY_ID);
			if (request.getRequestPathInfo().getSelectorString().contains(ACTIVITY_SUMMARY_LIST)) {
                PointsSummaryResponse pointSummaryResponse = loyaltyService.getProfilePointSummary(accessTokenResponse.getProfileId(),
						accessTokenResponse.getAccessToken(), contextAwareConfig);
				finalJson = new Gson().toJson(pointSummaryResponse);
			} else if (request.getRequestPathInfo().getSelectorString().contains(ACTIVITY_SUMMARY_LIST) && StringUtils.isNotBlank(activityId)) {
				ActivityByIdResponse activityByIdResponse = null;
				String type = request.getParameter(TYPE);
				if (type.equalsIgnoreCase(ORDER_DETAILS)) {
					activityByIdResponse = loyaltyService.getProfileOrderById(activityId,accessTokenResponse.getProfileId(),
						accessTokenResponse.getAccessToken(), contextAwareConfig);
				} else if (type.equalsIgnoreCase(TRANSACTION_DETAILS)) {					
					activityByIdResponse = loyaltyService.getProfileTransactionsById(activityId,accessTokenResponse.getProfileId(),
							accessTokenResponse.getAccessToken(), contextAwareConfig);
				}
				finalJson = new Gson().toJson(activityByIdResponse);
			}
			response.getWriter().write(finalJson);
		} catch (Exception e) {
			log.error("Points Summary Servlet:Error Occured::", e);
		}
	}
}
