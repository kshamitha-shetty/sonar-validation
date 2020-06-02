package com.rnd.loyaltydemo.core.models;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import com.day.cq.tagging.Tag;
import com.day.cq.tagging.TagManager;
import com.rnd.loyaltydemo.core.utils.JcrUtilService;

/**
 * 
 * @author spathak2
 *
 */
@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ColumnContainerModel {

	@Inject
	private List<ColumnContainerPojo> columnLayout;

	private String containerClassStr;
    
	
	@Inject
	private String[] containerClass;

	TagManager tagManager = null;
	
    /**
     * Initializing the properties
     */
	@PostConstruct
	protected void init() {
		ResourceResolver resolver = JcrUtilService.getResourceResolver();
		tagManager = (null != resolver) ? resolver.adaptTo(TagManager.class) : null;

		if (null != columnLayout) {
			for (ColumnContainerPojo colLayout : columnLayout) {
				String[] columnClassArray = colLayout.getColumnClass();
				colLayout.setColumnCssClass(getSpaceSeparatedCssClass(columnClassArray));
			}
		}
		if (null != containerClass) {
			containerClassStr = getSpaceSeparatedCssClass(containerClass);
		}

	}
    /**
     * 
     * @param tagArray
     * @return Space seperated string
     */
	private String getSpaceSeparatedCssClass(String[] tagArray) {
		if(null != tagArray) {
		List<String> tagNamesArrayList = new ArrayList<>();
		for (String tagValue : tagArray) {
			Tag tag = tagManager.resolve(tagValue);
			if (tag != null) {
				String tagName = tag.getName();
				tagNamesArrayList.add(tagName);
			}
		}
		return StringUtils.join(tagNamesArrayList, " ");
		}
		return null;
	
	}

	public List<ColumnContainerPojo> getColumnLayout() {
		return columnLayout;
	}

	public void setColumnLayout(List<ColumnContainerPojo> columnLayout) {
		this.columnLayout = columnLayout;
	}

	public String getContainerClassStr() {
		return containerClassStr;
	}

	public void setContainerClassStr(String containerClassStr) {
		this.containerClassStr = containerClassStr;
	}

}
