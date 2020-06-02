package com.rnd.loyaltydemo.core.config;

import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;


/**
 * Loyalty Demo OSGI Configuration
 *
 * @author pannem
 */
@Component(immediate = true, service = LoyaltyDemoOSGIConfig.class, property = {
        "process.label = General OSGI Configs Service for Loyalty Demo",
        Constants.SERVICE_DESCRIPTION
                + "= This is a service acts as a controller for all general Loyalty Demo OSGI configurations",
        Constants.SERVICE_VENDOR + "=Loyalty Demo" })
@Designate(ocd = LoyaltyDemoOSGIConfig.Config.class)
public class LoyaltyDemoOSGIConfig {
	    
	@ObjectClassDefinition(name = "Loyalty Demo OSGI configuration", description = "Loyalty  Demo OSGI configuration")
	public @interface Config {
	    
	    /**
	     * @return loyaltyApiConfilgPath
	     */
	    @AttributeDefinition(name = "Loyalty API Config Path", description = "This holds the Default API Config Path")
	    String loyaltyApiConfilgPath()  default "dev/sling:configs/com.rnd.loyaltydemo.core.config.ContextAwareConfig";
	    
	    /**
	     * @return loyaltyApiConfilgBucketName
	     */
	    @AttributeDefinition(name = "Loyalty API Config Bucket Name", description = "This holds the Default API Config Bucket Name")
	    String loyaltyApiConfilgBucketName()  default "sling:configs";
	       
	}
	
	/** The config. */
    private Config config;

    /**
     * Configuration Activate method.
     *
     * @param config the config
     */
    @Activate
    protected void activate(Config config) {
        this.config = config;
    }
    
    /**
    * Gets the Loyalty API Config Path.
    *
    * @return the Loyalty API Config Path
    */
   public String getLoyaltyApiConfilgPath() {
       return config.loyaltyApiConfilgPath();
   }
   
   /**
    * Gets the Loyalty API Config Bucket Name.
    *
    * @return the Loyalty API Config Bucket Name
    */
   public String getLoyaltyApiConfilgBucketName() {
       return config.loyaltyApiConfilgBucketName();
   }

}
