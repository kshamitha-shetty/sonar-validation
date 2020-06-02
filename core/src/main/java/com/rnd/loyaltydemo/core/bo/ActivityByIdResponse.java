package com.rnd.loyaltydemo.core.bo;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ActivityByIdResponse extends GenericResponse{
	@SerializedName("ProfileId")
	@Expose
	private String profileId;
	@SerializedName("RawTransactionId")
	@Expose
	private String rawTransactionId;
	@SerializedName("CardNumber")
	@Expose
	private String cardNumber;
	@SerializedName("ProgramCode")
	@Expose
	private String programCode;
	@SerializedName("TransactionId")
	@Expose
	private String transactionId;
	@SerializedName("TransactionTypeCode")
	@Expose
	private String transactionTypeCode;
	@SerializedName("TransactionTypeCodeDesc")
	@Expose
	private String transactionTypeCodeDesc;
	@SerializedName("TransactionNetTotal")
	@Expose
	private String transactionNetTotal;
	@SerializedName("TransactionEligible")
	@Expose
	private String transactionEligible;
	@SerializedName("ShippingAndHandling")
	@Expose
	private String shippingAndHandling;
	@SerializedName("TransactionTotalTax")
	@Expose
	private String transactionTotalTax;
	@SerializedName("TransactionNumber")
	@Expose
	private String transactionNumber;
	@SerializedName("CurrencyCode")
	@Expose
	private String currencyCode;
	@SerializedName("TransactionDateTime")
	@Expose
	private String transactionDateTime;
	@SerializedName("TransactionDescription")
	@Expose
	private String transactionDescription;
	@SerializedName("StoreCode")
	@Expose
	private String storeCode;
	@SerializedName("AccountSourceCode")
	@Expose
	private String accountSourceCode;
	@SerializedName("SourceAccountNumber")
	@Expose
	private String sourceAccountNumber;
	@SerializedName("BrandOrgCode")
	@Expose
	private String brandOrgCode;
	@SerializedName("ShipToName")
	@Expose
	private String shipToName;
	@SerializedName("AddressLine1")
	@Expose
	private String addressLine1;
	@SerializedName("City")
	@Expose
	private String city;
	@SerializedName("StateCode")
	@Expose
	private String stateCode;
	@SerializedName("PostalCode")
	@Expose
	private String postalCode;
	@SerializedName("CountryCode")
	@Expose
	private String countryCode;
	@SerializedName("Status")
	@Expose
	private String status;
	@SerializedName(value = "ActivityDetails", alternate = {"TransactionDetails","OrderDetails"})
	@Expose
	private ActivityDetails[] activityDetails;

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public String getRawTransactionId() {
		return rawTransactionId;
	}

	public void setRawTransactionId(String rawTransactionId) {
		this.rawTransactionId = rawTransactionId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getProgramCode() {
		return programCode;
	}

	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionTypeCode() {
		return transactionTypeCode;
	}

	public void setTransactionTypeCode(String transactionTypeCode) {
		this.transactionTypeCode = transactionTypeCode;
	}

	public String getTransactionTypeCodeDesc() {
		return transactionTypeCodeDesc;
	}

	public void setTransactionTypeCodeDesc(String transactionTypeCodeDesc) {
		this.transactionTypeCodeDesc = transactionTypeCodeDesc;
	}

	public String getTransactionNetTotal() {
		return transactionNetTotal;
	}

	public void setTransactionNetTotal(String transactionNetTotal) {
		this.transactionNetTotal = transactionNetTotal;
	}

	public String getTransactionEligible() {
		return transactionEligible;
	}

	public void setTransactionEligible(String transactionEligible) {
		this.transactionEligible = transactionEligible;
	}

	public String getShippingAndHandling() {
		return shippingAndHandling;
	}

	public void setShippingAndHandling(String shippingAndHandling) {
		this.shippingAndHandling = shippingAndHandling;
	}

	public String getTransactionTotalTax() {
		return transactionTotalTax;
	}

	public void setTransactionTotalTax(String transactionTotalTax) {
		this.transactionTotalTax = transactionTotalTax;
	}

	public String getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getTransactionDateTime(){
		return transactionDateTime;

	}

	public void setTransactionDateTime(String transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

	public String getTransactionDescription() {
		return transactionDescription;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ActivityDetails[] getActivityDetails() {
		return activityDetails;
	}

	public void setActivityDetails(ActivityDetails[] activityDetails) {
		this.activityDetails = activityDetails;
	}

	public String getShipToName() {
		return shipToName;
	}

	public void setShipToName(String shipToName) {
		this.shipToName = shipToName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

}
