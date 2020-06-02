
package com.rnd.loyaltydemo.core.bo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TierProgression extends GenericResponse{

    @SerializedName("TierProgressionCode")
    @Expose
    private String tierProgressionCode;
    @SerializedName("ProgramCode")
    @Expose
    private String programCode;
    @SerializedName("TierProgressionCycle")
    @Expose
    private Integer tierProgressionCycle;
    @SerializedName("TierProgressionFrequency")
    @Expose
    private String tierProgressionFrequency;
    @SerializedName("StartDate")
    @Expose
    private String startDate;
    @SerializedName("EndDate")
    @Expose
    private String endDate;
    @SerializedName("TierProgressionCycleStartDate")
    @Expose
    private String tierProgressionCycleStartDate;
    @SerializedName("TierProgressionCycleEndDate")
    @Expose
    private String tierProgressionCycleEndDate;
    @SerializedName("Chains")
    @Expose
    private List<Chain> chains = null;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("CreateUser")
    @Expose
    private String createUser;
    @SerializedName("CreateDate")
    @Expose
    private String createDate;
    @SerializedName("UpdateUser")
    @Expose
    private String updateUser;
    @SerializedName("UpdateDate")
    @Expose
    private String updateDate;

    public String getTierProgressionCode() {
        return tierProgressionCode;
    }

    public void setTierProgressionCode(String tierProgressionCode) {
        this.tierProgressionCode = tierProgressionCode;
    }

    public String getProgramCode() {
        return programCode;
    }

    public void setProgramCode(String programCode) {
        this.programCode = programCode;
    }

    public Integer getTierProgressionCycle() {
        return tierProgressionCycle;
    }

    public void setTierProgressionCycle(Integer tierProgressionCycle) {
        this.tierProgressionCycle = tierProgressionCycle;
    }

    public String getTierProgressionFrequency() {
        return tierProgressionFrequency;
    }

    public void setTierProgressionFrequency(String tierProgressionFrequency) {
        this.tierProgressionFrequency = tierProgressionFrequency;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTierProgressionCycleStartDate() {
        return tierProgressionCycleStartDate;
    }

    public void setTierProgressionCycleStartDate(String tierProgressionCycleStartDate) {
        this.tierProgressionCycleStartDate = tierProgressionCycleStartDate;
    }

    public String getTierProgressionCycleEndDate() {
        return tierProgressionCycleEndDate;
    }

    public void setTierProgressionCycleEndDate(String tierProgressionCycleEndDate) {
        this.tierProgressionCycleEndDate = tierProgressionCycleEndDate;
    }

    public List<Chain> getChains() {
        return chains;
    }

    public void setChains(List<Chain> chains) {
        this.chains = chains;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

}
