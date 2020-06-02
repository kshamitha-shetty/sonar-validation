package com.rnd.loyaltydemo.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rnd.loyaltydemo.core.utils.LinksUtil;

/**
 * The Class BannerComponent.
 *
 * @author pannem
 */
@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class BannerComponentModel {

	private static final Logger log = LoggerFactory
			.getLogger(BannerComponentModel.class);
	
	/** The link path. */
	@Inject
	@Optional
	private String linkPath;
	
	/** The resource resolver. */
	@SlingObject
	private ResourceResolver resourceResolver;

	@SlingObject
	private Resource resource;
	
	private boolean isPopupLink = false;
	/**
	 * Inits the.
	 */
	@PostConstruct
	protected void init() {
		log.info("Banner Component Init Method");
		if (StringUtils.isNotBlank(linkPath)) {
			linkPath = LinksUtil.checkInternalExternalURLByResource(linkPath, resourceResolver.getResource(linkPath));
			if (linkPath.startsWith("#") && linkPath.length() > 1) {
				isPopupLink = true;
			}
		}
	}
	
	/**
	 * Gets the link path.
	 *
	 * @return the link path
	 */
	public String getLinkPath() {
		return linkPath;
	}
	
	public boolean isPopupModalLink() {
		return isPopupLink;
	}
}
