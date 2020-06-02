package com.rnd.loyaltydemo.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
/**
 * 
 * @author spathak2
 *
 */
@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ColumnContainerPojo {

	@Inject
	private String columnWidth;

	@Inject
	private String[] columnClass;

	@Inject
	private String columnWidthTablet;

	@Inject
	private String columnWidthMobile;

	private String columnCssClass;

	public String getColumnWidth() {
		return columnWidth;
	}

	public void setColumnWidth(String columnWidth) {
		this.columnWidth = columnWidth;
	}

	public String getColumnWidthTablet() {
		return columnWidthTablet;
	}

	public String[] getColumnClass() {
		return columnClass;
	}

	public void setColumnClass(String[] columnClass) {
		this.columnClass = columnClass;
	}

	public String getColumnCssClass() {
		return columnCssClass;
	}

	public void setColumnCssClass(String columnCssClass) {
		this.columnCssClass = columnCssClass;
	}

	public void setColumnWidthTablet(String columnWidthTablet) {
		this.columnWidthTablet = columnWidthTablet;
	}

	public String getColumnWidthMobile() {
		return columnWidthMobile;
	}

	public void setColumnWidthMobile(String columnWidthMobile) {
		this.columnWidthMobile = columnWidthMobile;
	}

}
