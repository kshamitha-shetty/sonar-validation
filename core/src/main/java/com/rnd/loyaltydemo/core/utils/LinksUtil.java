package com.rnd.loyaltydemo.core.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceUtil;
import org.apache.sling.api.resource.ValueMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.Page;
import com.rnd.loyaltydemo.core.constants.GlobalConstants;

/**
 * The Class LinksUtil.
 *
 * @author ajena
 */
public class LinksUtil {

    private LinksUtil() {
        // Restricting Instantiation
    }

    private static final Logger LOG = LoggerFactory.getLogger(LinksUtil.class);

    /**
     * Check internal external URL by resource.
     *
     * @param url 
     * @param resource 
     * @return the string
     */
    public static String checkInternalExternalURLByResource(String url, final Resource resource) {
        try {
            if (null != resource) {
                if (isCQPage(resource) && url.startsWith(GlobalConstants.FORWARD_SLASH)) {
                    url = url + GlobalConstants.DOT_HTML;
                }
            } else if (url!=null) {
                if (url.startsWith(GlobalConstants.HTTP_PROTOCOL) || url.startsWith(GlobalConstants.HTTPS_PROTOCOL)
                        || url.startsWith(GlobalConstants.HASH)) {
                    return url;
                } else {
                    return GlobalConstants.HTTP_PROTOCOL + url;
                }
            }
        } catch (final Exception e) {
            LOG.error("Exception in LinksUtil.checkInternalExternalURL method {}", e);
        }
        return url;
    }

    /**
     * Check internal URL by page.
     *
     * @param page the page
     * @return the string
     */
    public static String checkInternalURLByPage(final Page page) {
        String url = null;
        if (null != page) {
            url = page.getPath();
            url = url + GlobalConstants.DOT_HTML;
        }
        return url;
    }

    /**
     * Check internal URL by path.
     *
     * @param path the path
     * @param resourceResolver the resource resolver
     * @return the string
     */
    public static String checkInternalURLByPath(final String path, final ResourceResolver resourceResolver) {
        String url = null;
        try {
            if (null != path) {
                if (path.startsWith(GlobalConstants.FORWARD_SLASH) && StringUtils.contains(path, GlobalConstants.DOT_HTML)) {
                    return path;
                } else if (path.startsWith(GlobalConstants.FORWARD_SLASH) && !StringUtils.contains(path, GlobalConstants.DOT_HTML) && StringUtils.contains(path, GlobalConstants.QUERY_STRING)) {
                    final String queryString = StringUtils.substringAfter(path, GlobalConstants.QUERY_STRING);
                    final String urlString = StringUtils.substringBefore(path, new StringBuilder(GlobalConstants.QUERY_STRING).append(queryString).toString());
                    return new StringBuilder(urlString).append(GlobalConstants.DOT_HTML).append(GlobalConstants.QUERY_STRING).append(queryString).toString();
                } else {
                    final Resource resource = resourceResolver.getResource(path);
                    url = checkInternalExternalURLByResource(path, resource);
                }
            }
        } catch (final Exception e) {
            LOG.error("LinksUtil :: checkInternalURLByPath :: Exception {}", e);
        }
        return url;
    }

    /**
     * Checks if is CQ page.
     *
     * @param resource the resource
     * @return true, if is CQ page
     */
    public static boolean isCQPage(final Resource resource) {
        final ValueMap properties = ResourceUtil.getValueMap(resource);
        final String primaryType = properties.get(GlobalConstants.JCR_PRIMARY_TYPE, String.class);
        if (primaryType != null && primaryType.equals(GlobalConstants.CQ_PAGE)) {
            return true;
        }
        return false;
    }

    /**
     * Checks if is new window.
     *
     * @param newWindow the new window
     * @return the string
     */
    public static String isNewWindow(final String newWindow) {
        if (StringUtils.isNotBlank(newWindow) && newWindow.equalsIgnoreCase(GlobalConstants.TRUE)) {
            return GlobalConstants.TARGET_BLANK;
        } else {
            return GlobalConstants.TARGET_SELF;
        }
    }
    
    /**
     * Gets the short url.
     *
     * @param url the url
     * @return the short url
     */
    public static String getShortUrl(String url) {
        try (ResourceResolver resourceResolver = JcrUtilService.getResourceResolver()) {
            if (resourceResolver != null && StringUtils.isNotBlank(url) && url.startsWith("/")) {
                return resourceResolver.map(url);
            }
            return url;
        }
    }
    
    /**
     * Gets the short url.
     *
     * @param url the url
     * @param resourceResolver the resource resolver
     * @return the short url
     */
    public static String getShortUrl(String url, final ResourceResolver resourceResolver) {
            if (resourceResolver != null && StringUtils.isNotBlank(url) && url.startsWith("/")) {
                return resourceResolver.map(url);
            }
            return url;
    }
}
