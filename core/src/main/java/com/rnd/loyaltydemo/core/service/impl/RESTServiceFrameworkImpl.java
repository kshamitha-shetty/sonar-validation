package com.rnd.loyaltydemo.core.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rnd.loyaltydemo.core.bo.RestServiceResponse;
import com.rnd.loyaltydemo.core.constants.LoyaltyDemoConstants;
import com.rnd.loyaltydemo.core.service.RESTServiceFramework;

/**
 * REST Service Framework class has GET, PUT, POST, PATCH methods for calling
 * loyalty WEB Service
 * 
 */

@Component(service = RESTServiceFramework.class, enabled = true, name = "Loyalty Demo REST Service Consumer", immediate = true)
public class RESTServiceFrameworkImpl implements RESTServiceFramework {

	private static final Logger log = LoggerFactory.getLogger(RESTServiceFrameworkImpl.class);

	/**
	 * GET WEB Service call
	 * 
	 * @param endPointUrl
	 * @param requestParams
	 * @param headers
	 * 
	 * @return RestServiceResponse
	 */
	@Override
	public RestServiceResponse makeGetWSCall(String endPointUrl, final Map<String, String> requestParams,
			final Map<String, String> headers) {
		try (final CloseableHttpClient client = HttpClients.createDefault()) {
			if (null != requestParams && !requestParams.isEmpty()) {
				StringBuilder params = getRequestParams(requestParams);
				endPointUrl = endPointUrl.contains("?") ? endPointUrl + "&" + params.toString()
						: endPointUrl + "?" + params.toString();
			}
			log.debug("endPointUrl:::: {} ", endPointUrl);
			final HttpGet get = new HttpGet(endPointUrl);

			if (null != headers && !headers.isEmpty()) {
				for (Map.Entry<String, String> entry : headers.entrySet()) {
					get.addHeader(entry.getKey(), entry.getValue());
				}
			}

			final CloseableHttpResponse response = client.execute(get);
			return getServiceResponse(response);
		} catch (final Exception e) {
			log.error("Exception ::: {}", e);
		}
		return null;
	}

	private RestServiceResponse getServiceResponse(final CloseableHttpResponse response) throws IOException {
		final int statusCode = response.getStatusLine().getStatusCode();
		log.debug("Status code is :::::: {} ", statusCode);
		final HttpEntity entity = response.getEntity();
		String serviceResponse = entity != null ? EntityUtils.toString(entity, LoyaltyDemoConstants.UTF_8)
				: StringUtils.EMPTY;
		log.debug("Service Response :::::: {} ", serviceResponse);
		RestServiceResponse responseModel = new RestServiceResponse();
		responseModel.setStatusCode(statusCode);
		responseModel.setResponse(serviceResponse);
		return responseModel;
	}

	private StringBuilder getRequestParams(final Map<String, String> requestParams) {
		StringBuilder params = new StringBuilder();
		final int size = requestParams.size();
		int index = 0;
		for (Map.Entry<String, String> entry : requestParams.entrySet()) {
			if (index++ == size - 1)
				params.append(entry.getKey()).append("=").append(entry.getValue());
			else
				params.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
		}
		return params;
	}

	/**
	 * GET WEB Service call without requestParams
	 * 
	 * @param endPointUrl
	 * @param headers
	 * 
	 * @return RestServiceResponse
	 * 
	 */
	@Override
	public RestServiceResponse makeGetWSCall(final String endPointUrl, final Map<String, String> headers) {
		return makeGetWSCall(endPointUrl, null, headers);
	}

	/**
	 * POST WEB Service call
	 * 
	 * @param endPointUrl
	 * @param requestBody
	 * @param requestParams
	 * @param headers
	 * 
	 * @return RestServiceResponse
	 */
	@Override
	public RestServiceResponse makePostWSCall(final String endPointUrl, final String requestBody,
			final Map<String, String> requestParams, final Map<String, String> headers) {
		try (final CloseableHttpClient client = HttpClients.createDefault()) {
			log.debug("requestBody:::  {} ", requestBody);
			log.debug("headers:::  {} ", headers);
			final HttpPost post = new HttpPost(endPointUrl);
			if (null != headers && !headers.isEmpty()) {
				for (Map.Entry<String, String> entry : headers.entrySet()) {
					post.addHeader(entry.getKey(), entry.getValue());
				}
			}

			if (StringUtils.isNotEmpty(requestBody)) {
				final StringEntity stringEntity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
				post.setEntity(stringEntity);
			} else if (null != requestParams && !requestParams.isEmpty()) {
				final List<BasicNameValuePair> parametersBody = getParametersBody(requestParams);
				post.setEntity(new UrlEncodedFormEntity(parametersBody));
			}
			log.debug("endPointUrl:::::: {} ", endPointUrl);

			final CloseableHttpResponse response = client.execute(post);
			return getServiceResponse(response);
		} catch (final Exception e) {
			log.error("Exception post request", e);
		}
		return null;
	}

	private List<BasicNameValuePair> getParametersBody(final Map<String, String> requestParams) {
		return requestParams.entrySet().parallelStream()
				.map(entry -> new BasicNameValuePair(entry.getKey(), entry.getValue())).collect(Collectors.toList());
	}

	/**
	 * POST WEB Service call without requestParams
	 * 
	 * @param endPointUrl
	 * @param requestBody
	 * @param headers
	 * 
	 * @return RestServiceResponse
	 */
	@Override
	public RestServiceResponse makePostWSCall(final String endPointUrl, final String requestBody,
			final Map<String, String> headers) {
		return makePostWSCall(endPointUrl, requestBody, null, headers);
	}
	
	/**
	 * POST WEB Service call without requestParams and requestBody
	 * 
	 * @param endPointUrl
	 * @param headers
	 * 
	 * @return RestServiceResponse
	 */
	@Override
	public RestServiceResponse makePostWSCall(final String endPointUrl, final Map<String, String> headers) {
		return makePostWSCall(endPointUrl, StringUtils.EMPTY, null, headers);
	}

	/**
	 * PATCH WEB Service call
	 * 
	 * @param endPointUrl
	 * @param requestBody
	 * @param requestParams
	 * @param headers
	 * 
	 * @return RestServiceResponse
	 * 
	 */
	@Override
	public RestServiceResponse makePatchWSCall(final String endPointUrl, final String requestBody,
			final Map<String, String> requestParams, final Map<String, String> headers) {
		try (final CloseableHttpClient client = HttpClients.createDefault()) {
			final HttpPatch patch = new HttpPatch(endPointUrl);
			if (null != headers && !headers.isEmpty()) {
				for (Map.Entry<String, String> entry : headers.entrySet()) {
					patch.addHeader(entry.getKey(), entry.getValue());
				}
			}

			if (StringUtils.isNotEmpty(requestBody)) {
				final StringEntity stringEntity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
				patch.setEntity(stringEntity);
			} else if (null != requestParams && !requestParams.isEmpty()) {
				final List<BasicNameValuePair> parametersBody = getParametersBody(requestParams);
				patch.setEntity(new UrlEncodedFormEntity(parametersBody));
			}

			final CloseableHttpResponse response = client.execute(patch);
			return getServiceResponse(response);
		} catch (final Exception e) {
			log.error("Exception patch request", e);
		}
		return null;
	}

	/**
	 * PATCH WEB Service call requestParams
	 * 
	 * @param endPointUrl
	 * @param requestBody
	 * @param headers
	 * 
	 * @return RestServiceResponse
	 */
	@Override
	public RestServiceResponse makePatchWSCall(final String endPointUrl, final String requestBody,
			final Map<String, String> headers) {
		return makePatchWSCall(endPointUrl, requestBody, null, headers);
	}

	/**
	 * PUT WEB Service call
	 * 
	 * @param endPointUrl
	 * @param requestBody
	 * @param requestParams
	 * @param headers
	 * 
	 * @return RestServiceResponse
	 * 
	 */
	@Override
	public RestServiceResponse makePutWSCall(final String endPointUrl, final String requestBody,
			final Map<String, String> requestParams, final Map<String, String> headers) {
		try (final CloseableHttpClient client = HttpClients.createDefault()) {
			final HttpPut put = new HttpPut(endPointUrl);
			if (null != headers && !headers.isEmpty()) {
				for (Map.Entry<String, String> entry : headers.entrySet()) {
					put.addHeader(entry.getKey(), entry.getValue());
				}
			}

			if (StringUtils.isNotEmpty(requestBody)) {
				log.debug("requestBody:::::: {} ", requestBody);

				final StringEntity stringEntity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
				put.setEntity(stringEntity);
			} else if (null != requestParams && !requestParams.isEmpty()) {
				final List<BasicNameValuePair> parametersBody = getParametersBody(requestParams);
				put.setEntity(new UrlEncodedFormEntity(parametersBody));
			}
			log.debug("endPointUrl:::::: {} ", endPointUrl);

			final CloseableHttpResponse response = client.execute(put);
			return getServiceResponse(response);
		} catch (final Exception e) {
			log.error("Exception Put request", e);
		}
		return null;
	}

	/**
	 * PUT WEB Service call without requestParams
	 * 
	 * @param endPointUrl
	 * @param requestBody
	 * @param headers
	 * 
	 * @return RestServiceResponse
	 * 
	 */
	@Override
	public RestServiceResponse makePutWSCall(final String endPointUrl, final String requestBody,
			final Map<String, String> headers) {
		return makePutWSCall(endPointUrl, requestBody, null, headers);
	}

}
