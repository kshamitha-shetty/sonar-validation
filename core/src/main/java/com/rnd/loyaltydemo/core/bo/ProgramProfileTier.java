
package com.rnd.loyaltydemo.core.bo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProgramProfileTier {

    @SerializedName("ProfileId")
    @Expose
    private String profileId;
    @SerializedName("TierProgressionDate")
    @Expose
    private String tierProgressionDate;
    @SerializedName("TierProgression")
    @Expose
    private TierProgression tierProgression;
    @SerializedName("ProgramProfileTiers")
    @Expose
    private List<ProgramProfileTiers> programProfileTiers = null;
    @SerializedName("ProfileAggregates")
    @Expose
    private List<ProfileAggregate> profileAggregates = null;
    @SerializedName("IsMaxTier")
    @Expose
    private Boolean isMaxTier;

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getTierProgressionDate() {
        return tierProgressionDate;
    }

    public void setTierProgressionDate(String tierProgressionDate) {
        this.tierProgressionDate = tierProgressionDate;
    }

    public TierProgression getTierProgression() {
        return tierProgression;
    }

    public void setTierProgression(TierProgression tierProgression) {
        this.tierProgression = tierProgression;
    }

    public List<ProgramProfileTiers> getProgramProfileTiers() {
        return programProfileTiers;
    }

    public void setProgramProfileTiers(List<ProgramProfileTiers> programProfileTiers) {
        this.programProfileTiers = programProfileTiers;
    }

    public List<ProfileAggregate> getProfileAggregates() {
        return profileAggregates;
    }

    public void setProfileAggregates(List<ProfileAggregate> profileAggregates) {
        this.profileAggregates = profileAggregates;
    }

    public Boolean getIsMaxTier() {
        return isMaxTier;
    }

    public void setIsMaxTier(Boolean isMaxTier) {
        this.isMaxTier = isMaxTier;
    }

}
