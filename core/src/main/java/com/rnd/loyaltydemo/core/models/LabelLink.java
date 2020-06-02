package com.rnd.loyaltydemo.core.models;

import com.rnd.loyaltydemo.core.utils.LinksUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class LabelLink {

    @Inject
    private String label;

    @Inject
    private String link;

    @Inject
    private boolean newWindow;

    @SlingObject
    private ResourceResolver resourceResolver;

    @PostConstruct
    protected void init() {
        if (StringUtils.isNotBlank(link)) {
            link = LinksUtil.checkInternalExternalURLByResource(link, resourceResolver.getResource(link));
        }
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean isNewWindow() {
        return newWindow;
    }

    public void setNewWindow(boolean newWindow) {
        this.newWindow = newWindow;
    }
}
