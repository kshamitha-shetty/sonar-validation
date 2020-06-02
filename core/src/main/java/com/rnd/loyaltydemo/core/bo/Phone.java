
package com.rnd.loyaltydemo.core.bo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Phone {

    @SerializedName("ProfileId")
    @Expose
    private String profileId;
    @SerializedName("PhoneId")
    @Expose
    private String phoneId;
    @SerializedName("PhoneNumber")
    @Expose
    private String phoneNumber;
    @SerializedName("SourcePhoneNumber")
    @Expose
    private String sourcePhoneNumber;
    @SerializedName("PhoneCountryCode")
    @Expose
    private String phoneCountryCode;
    @SerializedName("AcceptsText")
    @Expose
    private Boolean acceptsText;
    @SerializedName("Frequency")
    @Expose
    private Integer frequency;
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

    public void setProfileId(final String profileId) {
        this.profileId = profileId;
    }

    public String getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(final String phoneId) {
        this.phoneId = phoneId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSourcePhoneNumber() {
        return sourcePhoneNumber;
    }

    public void setSourcePhoneNumber(final String sourcePhoneNumber) {
        this.sourcePhoneNumber = sourcePhoneNumber;
    }

    public String getPhoneCountryCode() {
        return phoneCountryCode;
    }

    public void setPhoneCountryCode(final String phoneCountryCode) {
        this.phoneCountryCode = phoneCountryCode;
    }

    public Boolean getAcceptsText() {
        return acceptsText;
    }

    public void setAcceptsText(final Boolean acceptsText) {
        this.acceptsText = acceptsText;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(final Integer frequency) {
        this.frequency = frequency;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(final String channelCode) {
        this.channelCode = channelCode;
    }

    public Boolean getIsPreferred() {
        return isPreferred;
    }

    public void setIsPreferred(final Boolean isPreferred) {
        this.isPreferred = isPreferred;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(final String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getDeliveryStatusDescription() {
        return deliveryStatusDescription;
    }

    public void setDeliveryStatusDescription(final String deliveryStatusDescription) {
        this.deliveryStatusDescription = deliveryStatusDescription;
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

    public String getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(final String activityDate) {
        this.activityDate = activityDate;
    }

    public String getContactPointId() {
        return contactPointId;
    }

    public void setContactPointId(final String contactPointId) {
        this.contactPointId = contactPointId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
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

}
