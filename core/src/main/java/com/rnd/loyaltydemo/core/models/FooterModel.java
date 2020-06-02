package com.rnd.loyaltydemo.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class FooterModel {

    @Inject
    @Named("logoRef")
    private String logoUrl;
    @Inject
    private String altText;
    @Inject
    private String copyright;
    @Inject
    private String optionalText;
    @Inject
    @Named("list")
    private List<LabelLink> labellinks;

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getAltText() {
        return altText;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getOptionalText() {
        return optionalText;
    }

    public void setOptionalText(String optionalText) {
        this.optionalText = optionalText;
    }

    public List<LabelLink> getLabellinks() {
        return labellinks;
    }

    public void setLabellinks(List<LabelLink> labellinks) {
        this.labellinks = labellinks;
    }
}
