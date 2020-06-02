
package com.rnd.loyaltydemo.core.bo;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PointsActivtyDetails{

    @SerializedName("ProfileId")
    @Expose
    private String profileId;
    @SerializedName("ActPointId")
    @Expose
    private String actPointId;
    @SerializedName("PointType")
    @Expose
    private String pointType;
    @SerializedName("PointsAmount")
    @Expose
    private Double pointsAmount;
    @SerializedName("SupposedToEarnPoints")
    @Expose
    private Double supposedToEarnPoints;
    @SerializedName("ActivityType")
    @Expose
    private String activityType;
    @SerializedName("ActivityTypeDescription")
    @Expose
    private String activityTypeDescription;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("PointSubTypeId")
    @Expose
    private String pointSubTypeId;
    @SerializedName("BalancePoints")
    @Expose
    private Double balancePoints;
    @SerializedName("AccountSourceCode")
    @Expose
    private String accountSourceCode;
    @SerializedName("SourceAccountNumber")
    @Expose
    private String sourceAccountNumber;
    @SerializedName("BrandOrgCode")
    @Expose
    private String brandOrgCode;
    @SerializedName("PointTypeShortDescription")
    @Expose
    private String pointTypeShortDescription;
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
    @SerializedName("ActivityDate")
    @Expose
    private String activityDate;
    @SerializedName("BonusDescription")
    @Expose
    private String bonusDescription;
    @SerializedName("MomentId")
    @Expose
    private String momentId;
    
    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(final String profileId) {
        this.profileId = profileId;
    }

    public String getActPointId() {
        return actPointId;
    }

    public void setActPointId(final String actPointId) {
        this.actPointId = actPointId;
    }

    public String getPointType() {
        return pointType;
    }

    public void setPointType(final String pointType) {
        this.pointType = pointType;
    }

    public Double getPointsAmount() {
        return pointsAmount;
    }

    public void setPointsAmount(final Double pointsAmount) {
        this.pointsAmount = pointsAmount;
    }

    public Double getSupposedToEarnPoints() {
        return supposedToEarnPoints;
    }

    public void setSupposedToEarnPoints(final Double supposedToEarnPoints) {
        this.supposedToEarnPoints = supposedToEarnPoints;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(final String activityType) {
        this.activityType = activityType;
    }

    public String getActivityTypeDescription() {
        return activityTypeDescription;
    }

    public void setActivityTypeDescription(final String activityTypeDescription) {
        this.activityTypeDescription = activityTypeDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public String getPointSubTypeId() {
        return pointSubTypeId;
    }

    public void setPointSubTypeId(final String pointSubTypeId) {
        this.pointSubTypeId = pointSubTypeId;
    }

    public Double getBalancePoints() {
        return balancePoints;
    }

    public void setBalancePoints(final Double balancePoints) {
        this.balancePoints = balancePoints;
    }

    public String getAccountSourceCode() {
        return accountSourceCode;
    }

    public void setAccountSourceCode(final String accountSourceCode) {
        this.accountSourceCode = accountSourceCode;
    }

    public String getSourceAccountNumber() {
        return sourceAccountNumber;
    }

    public void setSourceAccountNumber(final String sourceAccountNumber) {
        this.sourceAccountNumber = sourceAccountNumber;
    }

    public String getBrandOrgCode() {
        return brandOrgCode;
    }

    public void setBrandOrgCode(final String brandOrgCode) {
        this.brandOrgCode = brandOrgCode;
    }

    public String getPointTypeShortDescription() {
        return pointTypeShortDescription;
    }

    public void setPointTypeShortDescription(final String pointTypeShortDescription) {
        this.pointTypeShortDescription = pointTypeShortDescription;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(final String createUser) {
        this.createUser = createUser;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(final String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(final String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(final String updateDate) {
        this.updateDate = updateDate;
    }

    public String getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(final String activityDate) {
        this.activityDate = activityDate;
    }

    public String getBonusDescription() {
        return bonusDescription;
    }

    public void setBonusDescription(final String bonusDescription) {
        this.bonusDescription = bonusDescription;
    }

    public String getMomentId() {
        return momentId;
    }

    public void setMomentId(final String momentId) {
        this.momentId = momentId;
    }

}