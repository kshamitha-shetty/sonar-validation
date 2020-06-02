
package com.rnd.loyaltydemo.core.bo;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Address {

	@SerializedName("ProfileId")
	@Expose
	private String profileId;
	@SerializedName("AddressId")
	@Expose
	private String addressId;
	@SerializedName("CountryCode")
	@Expose
	private String countryCode;
	@SerializedName("SourceCountryCode")
	@Expose
	private String sourceCountryCode;
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
	@SerializedName("DoNotStandardize")
	@Expose
	private Boolean doNotStandardize;
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
	@SerializedName("AddressLine1")
	@Expose
	private String addressLine1;
	@SerializedName("AddressLine2")
	@Expose
	private String addressLine2;
	@SerializedName("AddressLine3")
	@Expose
	private String addressLine3;
	@SerializedName("SourceAddressLine1")
	@Expose
	private String sourceAddressLine1;
	@SerializedName("City")
	@Expose
	private String city;
	@SerializedName("SourceCity")
	@Expose
	private String sourceCity;
	@SerializedName("StateCode")
	@Expose
	private String stateCode;
	@SerializedName("SourceStateCode")
	@Expose
	private String sourceStateCode;
	@SerializedName("PostalCode")
	@Expose
	private String postalCode;
	@SerializedName("SourcePostalCode")
	@Expose
	private String sourcePostalCode;

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(final String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(final String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(final String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getSourceAddressLine1() {
		if (!StringUtils.isBlank(sourceAddressLine1)) {
			sourceAddressLine1 = StringUtils.capitalize(sourceAddressLine1);
		}
		return sourceAddressLine1;
	}

	public void setSourceAddressLine1(final String sourceAddressLine1) {
		this.sourceAddressLine1 = sourceAddressLine1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(final String city) {
		this.city = city;
	}

	public String getSourceCity() {
		return sourceCity;
	}

	public void setSourceCity(final String sourceCity) {
		this.sourceCity = sourceCity;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(final String stateCode) {
		this.stateCode = stateCode;
	}

	public String getSourceStateCode() {
		return sourceStateCode;
	}

	public void setSourceStateCode(final String sourceStateCode) {
		this.sourceStateCode = sourceStateCode;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(final String postalCode) {
		this.postalCode = postalCode;
	}

	public String getSourcePostalCode() {
		return sourcePostalCode;
	}

	public void setSourcePostalCode(final String sourcePostalCode) {
		this.sourcePostalCode = sourcePostalCode;
	}

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(final String profileId) {
		this.profileId = profileId;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(final String addressId) {
		this.addressId = addressId;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(final String countryCode) {
		this.countryCode = countryCode;
	}

	public String getSourceCountryCode() {
		return sourceCountryCode;
	}

	public void setSourceCountryCode(final String sourceCountryCode) {
		this.sourceCountryCode = sourceCountryCode;
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

	public Boolean getDoNotStandardize() {
		return doNotStandardize;
	}

	public void setDoNotStandardize(final Boolean doNotStandardize) {
		this.doNotStandardize = doNotStandardize;
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
