package com.rnd.loyaltydemo.core.vo;

public class CarouselImageVO {
    private String image;

	private String imageMobile;

	private String label;

	private String alt;
    
    private String linkUrl;
    
    public String getImage() {
		return image;
	}
	public void setImage(final String image) {
		this.image = image;
	}
	public String getImageMobile() {
		return imageMobile;
	}
	public void setImageMobile(final String imageMobile) {
		this.imageMobile = imageMobile;
	}
	public String getAlt() {
		return alt;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(final String label) {
		this.label = label;
	}
	public void setAlt(final String alt) {
		this.alt = alt;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(final String linkUrl) {
		this.linkUrl = linkUrl;
	}
}
