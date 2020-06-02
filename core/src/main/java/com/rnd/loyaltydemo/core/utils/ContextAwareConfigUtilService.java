package com.rnd.loyaltydemo.core.utils;

import javax.jcr.RepositoryException;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.caconfig.ConfigurationBuilder;
import org.apache.sling.caconfig.resource.ConfigurationResourceResolver;
import org.osgi.framework.Constants;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rnd.loyaltydemo.core.config.ContextAwareConfig;
import com.rnd.loyaltydemo.core.config.LoyaltyDemoOSGIConfig;

/**
 * Context Aware Configuration Utility service class to identify configuration based on
 * the resource
 * 
 */
@Component(service = ContextAwareConfigUtilService.class, immediate = true, property = { "process.label=ContextAware Config Util Service",
		Constants.SERVICE_DESCRIPTION + "=ContextAware Config Util Service", Constants.SERVICE_VENDOR + "=Loyalty Demo"})

public class ContextAwareConfigUtilService {

	/**
	 * Logger configuration for
	 */
	private static final Logger log = LoggerFactory.getLogger(ContextAwareConfigUtilService.class);
	
	@Reference
	private ConfigurationResourceResolver configurationResourceResolver;
	
    @Reference
    private LoyaltyDemoOSGIConfig loyaltyDemoOSGIConfig;
	

	/**
	 * ContextAwareConfig with resource path
	 * 
	 * @param currentPagePath
	 * @param resourceResolver
	 * @return
	 */
	public ContextAwareConfig getContextAwareConfig(final String currentPagePath,
			final ResourceResolver resourceResolver) {
		if (StringUtils.isNotBlank(currentPagePath)) {
			try {
				final Resource contentResource = resourceResolver.getResource(currentPagePath);
				Resource configResource = configurationResourceResolver.getResource(contentResource,loyaltyDemoOSGIConfig.getLoyaltyApiConfilgBucketName(),
						loyaltyDemoOSGIConfig.getLoyaltyApiConfilgPath() );
				if (contentResource != null) {
					final ConfigurationBuilder configurationBuilder = configResource
							.adaptTo(ConfigurationBuilder.class);
					if (configurationBuilder != null) {
						return configurationBuilder.as(ContextAwareConfig.class);
					}
				}
			} catch (final Exception e) {
				log.error("OCAUtil::getContextAwareConfig::Exception", e);
			}
		}
		return null;
	}

	/**
	 * ContextAwareConfig with request object
	 * 
	 * @param request
	 * @return ContextAwareConfig	
	 */
	public ContextAwareConfig getContextAwareConfig(final SlingHttpServletRequest request) {
		try {
			final Resource contentResource = request.getResource();
			Resource configResource = configurationResourceResolver.getResource(contentResource,loyaltyDemoOSGIConfig.getLoyaltyApiConfilgBucketName(),
					loyaltyDemoOSGIConfig.getLoyaltyApiConfilgPath() );
			log.debug("configResource {}",configResource);
			final ConfigurationBuilder configurationBuilder = configResource.adaptTo(ConfigurationBuilder.class);
			if (configurationBuilder != null) {
				return configurationBuilder.as(ContextAwareConfig.class);
			}
		} catch (final Exception e) {
			log.error("OCAUtil::getContextAwareConfig::Exception", e);
		}
		return null;
	}
	
	/**
	 * Activate.
	 *
	 * @param componentContext the component context
	 * @throws RepositoryException the repository exception
	 * @throws LoginException      the login exception
	 */
	@Activate
	protected void activate(final ComponentContext componentContext) throws RepositoryException, LoginException {
		log.info("ContextAware Config Util :: Activate Method");
	}
}
