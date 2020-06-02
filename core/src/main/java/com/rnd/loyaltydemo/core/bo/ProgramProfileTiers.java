
package com.rnd.loyaltydemo.core.bo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProgramProfileTiers{

    @SerializedName("IsCurrentTier")
    @Expose
    private Boolean isCurrentTier;
    @SerializedName("TierCode")
    @Expose
    private String tierCode;
    @SerializedName("TierName")
    @Expose
    private String tierName;
    @SerializedName("TierDescription")
    @Expose
    private String tierDescription;
    @SerializedName("Rank")
    @Expose
    private Integer rank;
 
    private double annualThresholdPercentage;

    public double getAnnualThresholdPercentage() {
		return annualThresholdPercentage;
	}

	public void setAnnualThresholdPercentage(double annualThresholdPercentage) {
		this.annualThresholdPercentage = annualThresholdPercentage;
	}

	public Boolean getIsCurrentTier() {
        return isCurrentTier;
    }

    public void setIsCurrentTier(Boolean isCurrentTier) {
        this.isCurrentTier = isCurrentTier;
    }

    public String getTierCode() {
        return tierCode;
    }

    public void setTierCode(String tierCode) {
        this.tierCode = tierCode;
    }

    public String getTierName() {
        return tierName;
    }

    public void setTierName(String tierName) {
        this.tierName = tierName;
    }

    public String getTierDescription() {
        return tierDescription;
    }

    public void setTierDescription(String tierDescription) {
        this.tierDescription = tierDescription;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

}
