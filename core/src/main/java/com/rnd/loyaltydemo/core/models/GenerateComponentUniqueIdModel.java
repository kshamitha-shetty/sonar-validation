package com.rnd.loyaltydemo.core.models;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class GenerateComponentUniqueIdModel.
 *
 * @author pannem
 */
@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class GenerateComponentUniqueIdModel {

	private static final String SECTION = "Section";

	private static final Logger log = LoggerFactory
			.getLogger(GenerateComponentUniqueIdModel.class);
	
	@SlingObject
	private Resource resource;
	
	private String componentId;
	/**
	 * Inits the.
	 */
	@PostConstruct
	protected void init() {
		log.info("Component Unuique ID Genarator Init Method");
		componentId = SECTION + Math.abs(resource.getPath().hashCode() - 1);
	}
	
	public String getComponentId() {
		return componentId;
	}
}
