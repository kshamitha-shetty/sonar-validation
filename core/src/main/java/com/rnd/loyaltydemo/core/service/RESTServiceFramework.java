package com.rnd.loyaltydemo.core.service;

import java.util.Map;

import com.rnd.loyaltydemo.core.bo.RestServiceResponse;

public interface RESTServiceFramework {

	RestServiceResponse makeGetWSCall(String endPointUrl, Map<String, String> requestParams,
			Map<String, String> headers);

	RestServiceResponse makeGetWSCall(String endPointUrl, Map<String, String> headers);

	RestServiceResponse makePostWSCall(String endPointUrl, String requestBody, Map<String, String> requestParams,
			Map<String, String> headers);

	RestServiceResponse makePostWSCall(String endPointUrl, String requestBody, Map<String, String> headers);
	
	RestServiceResponse makePostWSCall(String endPointUrl, Map<String, String> headers);

	RestServiceResponse makePatchWSCall(String endPointUrl, String requestBody, Map<String, String> requestParams,
			Map<String, String> headers);

	RestServiceResponse makePatchWSCall(String endPointUrl, String requestBody, Map<String, String> headers);

	RestServiceResponse makePutWSCall(String endPointUrl, String requestBody, Map<String, String> requestParams,
			Map<String, String> headers);

	RestServiceResponse makePutWSCall(String endPointUrl, String requestBody, Map<String, String> headers);

}
