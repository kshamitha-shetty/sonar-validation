
package com.rnd.loyaltydemo.core.bo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Email {

    @SerializedName("ProfileId")
    @Expose
    private String profileId;
    @SerializedName("EmailId")
    @Expose
    private String emailId;
    @SerializedName("EmailAddress")
    @Expose
    private String emailAddress;
    @SerializedName("SourceEmailAddress")
    @Expose
    private String sourceEmailAddress;
    @SerializedName("ChannelCode")
    @Expose
    private String channelCode;
    @SerializedName("IsPreferred")
    @Expose
    private Boolean isPreferred;
    @SerializedName("DeliveryStatus")
    @Expose
    private String deliveryStatus;
    @SerializedName("DeliveryStatusDescription")
    @Expose
    private String deliveryStatusDescription;
    @SerializedName("AccountSourceCode")
    @Expose
    private String accountSourceCode;
    @SerializedName("SourceAccountNumber")
    @Expose
    private String sourceAccountNumber;
    @SerializedName("BrandOrgCode")
    @Expose
    private String brandOrgCode;
    @SerializedName("ActivityDate")
    @Expose
    private String activityDate;
    @SerializedName("ContactPointId")
    @Expose
    private String contactPointId;
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

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getSourceEmailAddress() {
        return sourceEmailAddress;
    }

    public void setSourceEmailAddress(String sourceEmailAddress) {
        this.sourceEmailAddress = sourceEmailAddress;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public Boolean getIsPreferred() {
        return isPreferred;
    }

    public void setIsPreferred(Boolean isPreferred) {
        this.isPreferred = isPreferred;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getDeliveryStatusDescription() {
        return deliveryStatusDescription;
    }

    public void setDeliveryStatusDescription(String deliveryStatusDescription) {
        this.deliveryStatusDescription = deliveryStatusDescription;
    }

    public String getAccountSourceCode() {
        return accountSourceCode;
    }

    public void setAccountSourceCode(String accountSourceCode) {
        this.accountSourceCode = accountSourceCode;
    }

    public String getSourceAccountNumber() {
        return sourceAccountNumber;
    }

    public void setSourceAccountNumber(String sourceAccountNumber) {
        this.sourceAccountNumber = sourceAccountNumber;
    }

    public String getBrandOrgCode() {
        return brandOrgCode;
    }

    public void setBrandOrgCode(String brandOrgCode) {
        this.brandOrgCode = brandOrgCode;
    }

    public String getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(String activityDate) {
        this.activityDate = activityDate;
    }

    public String getContactPointId() {
        return contactPointId;
    }

    public void setContactPointId(String contactPointId) {
        this.contactPointId = contactPointId;
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
