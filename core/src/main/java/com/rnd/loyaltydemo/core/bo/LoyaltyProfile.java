
package com.rnd.loyaltydemo.core.bo;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoyaltyProfile extends GenericResponse {

	@SerializedName("ProfileId")
	@Expose
	private String profileId;
	@SerializedName("Prefix")
	@Expose
	private String prefix;
	@SerializedName("FirstName")
	@Expose
	private String firstName;
	@SerializedName("SourceFirstName")
	@Expose
	private String sourceFirstName;
	@SerializedName("LastName")
	@Expose
	private String lastName;
	@SerializedName("SourceLastName")
	@Expose
	private String sourceLastName;
	@SerializedName("MiddleInit")
	@Expose
	private String middleInit;
	@SerializedName("Suffix")
	@Expose
	private String suffix;
	@SerializedName("SourceGender")
	@Expose
	private String sourceGender;
	@SerializedName("Gender")
	@Expose
	private String gender;
	@SerializedName("InLinkedPool")
	@Expose
	private Boolean inLinkedPool;
	@SerializedName("Addresses")
	@Expose
	private List<Address> addresses = null;
	@SerializedName("Emails")
    @Expose
    private List<Email> emails = null;
    @SerializedName("Phones")
    @Expose
    private List<Phone> phones = null;
    @SerializedName("ProgramCode")
    @Expose
    private String programCode;
	@SerializedName("SourceCode")
	@Expose
	private String sourceCode;
	@SerializedName("EnrollmentStatus")
	@Expose
	private String enrollmentStatus;
	@SerializedName("JoinDate")
	@Expose
	private String joinDate;
	@SerializedName("EnrollChannelCode")
	@Expose
	private String enrollChannelCode;
	@SerializedName("TierCode")
	@Expose
	private String tierCode;
	@SerializedName("TierName")
	@Expose
	private String tierName;
	@SerializedName("Username")
	@Expose
	private String username;
	@SerializedName("CardNumber")
	@Expose
	private String cardNumber;
	@SerializedName("Status")
	@Expose
	private String status;
	@SerializedName("SourceMiddleName")
	@Expose
	private String sourceMiddleName;
	@SerializedName("TermsConditionsAcceptedInd")
	@Expose
	private Boolean termsConditionsAcceptedInd;
	@SerializedName("TermsConditionsAcceptedDate")
	@Expose
	private String termsConditionsAcceptedDate;
	@SerializedName("AccountSourceCode")
	@Expose
	private String accountSourceCode;
	@SerializedName("SourceAccountNumber")
	@Expose
	private String sourceAccountNumber;
	@SerializedName("BrandOrgCode")
	@Expose
	private String brandOrgCode;
	@SerializedName("OrigActivityDate")
	@Expose
	private String origActivityDate;
	@SerializedName("MiddleName")
	@Expose
	private String middleName;
	@SerializedName("ActivityDate")
	@Expose
	private String activityDate;
	@SerializedName("AutoRewardOptInInd")
	@Expose
	private Boolean autoRewardOptInInd;
	@SerializedName("GamerAlias")
	@Expose
	private String gamerAlias;
	@SerializedName("GamerAvatar")
	@Expose
	private String gamerAvatar;
	@SerializedName("GamerAvatarImageUrl")
	@Expose
	private String gamerAvatarImageUrl;
	@SerializedName("GamerAvatarAemImageUrl")
	@Expose
	private String gamerAvatarAemImageUrl;
	@SerializedName("IsTestProfile")
	@Expose
	private Boolean isTestProfile;
	@SerializedName("PersonalizedMessages")
	@Expose
	private List<Object> personalizedMessages = null;
	@SerializedName("MomentResults")
	@Expose
	private List<Object> momentResults = null;
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
	@SerializedName("BirthDate")
	@Expose
	private String birthDate;

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(final String profileId) {
		this.profileId = profileId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getSourceFirstName() {
		return sourceFirstName;
	}

	public void setSourceFirstName(final String sourceFirstName) {
		this.sourceFirstName = sourceFirstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getSourceLastName() {
		return sourceLastName;
	}

	public void setSourceLastName(final String sourceLastName) {
		this.sourceLastName = sourceLastName;
	}

	public String getSourceGender() {
		return sourceGender;
	}

	public void setSourceGender(final String sourceGender) {
		this.sourceGender = sourceGender;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(final String genderVal) {
		gender = genderVal;
	}

	public Boolean getInLinkedPool() {
		return inLinkedPool;
	}

	public void setInLinkedPool(final Boolean inLinkedPool) {
		this.inLinkedPool = inLinkedPool;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(final List<Address> addresses) {
		this.addresses = addresses;
	}

	public String getProgramCode() {
		return programCode;
	}

	public void setProgramCode(final String programCode) {
		this.programCode = programCode;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(final String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public String getEnrollmentStatus() {
		return enrollmentStatus;
	}

	public void setEnrollmentStatus(final String enrollmentStatus) {
		this.enrollmentStatus = enrollmentStatus;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(final String joinDate) {
		this.joinDate = joinDate;
	}

	public String getEnrollChannelCode() {
		return enrollChannelCode;
	}

	public void setEnrollChannelCode(final String enrollChannelCode) {
		this.enrollChannelCode = enrollChannelCode;
	}

	public String getTierCode() {
		return tierCode;
	}

	public void setTierCode(final String tierCode) {
		this.tierCode = tierCode;
	}

	public String getTierName() {
		return tierName;
	}

	public void setTierName(final String tierName) {
		this.tierName = tierName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(final String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(final String status) {
		this.status = status;
	}

	public String getSourceMiddleName() {
		return sourceMiddleName;
	}

	public void setSourceMiddleName(final String sourceMiddleName) {
		this.sourceMiddleName = sourceMiddleName;
	}

	public Boolean getTermsConditionsAcceptedInd() {
		return termsConditionsAcceptedInd;
	}

	public void setTermsConditionsAcceptedInd(final Boolean termsConditionsAcceptedInd) {
		this.termsConditionsAcceptedInd = termsConditionsAcceptedInd;
	}

	public String getTermsConditionsAcceptedDate() {
		return termsConditionsAcceptedDate;
	}

	public void setTermsConditionsAcceptedDate(final String termsConditionsAcceptedDate) {
		this.termsConditionsAcceptedDate = termsConditionsAcceptedDate;
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

	public String getOrigActivityDate() {
		return origActivityDate;
	}

	public void setOrigActivityDate(final String origActivityDate) {
		this.origActivityDate = origActivityDate;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(final String middleName) {
		this.middleName = middleName;
	}

	public String getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(final String activityDate) {
		this.activityDate = activityDate;
	}

	public Boolean getAutoRewardOptInInd() {
		return autoRewardOptInInd;
	}

	public void setAutoRewardOptInInd(final Boolean autoRewardOptInInd) {
		this.autoRewardOptInInd = autoRewardOptInInd;
	}

	public String getGamerAlias() {
		return gamerAlias;
	}

	public void setGamerAlias(String gamerAlias) {
		this.gamerAlias = gamerAlias;
	}

	public String getGamerAvatar() {
		return gamerAvatar;
	}

	public void setGamerAvatar(String gamerAvatar) {
		this.gamerAvatar = gamerAvatar;
	}

	public String getGamerAvatarImageUrl() {
		return gamerAvatarImageUrl;
	}

	public void setGamerAvatarImageUrl(String gamerAvatarImageUrl) {
		this.gamerAvatarImageUrl = gamerAvatarImageUrl;
	}

	public String getGamerAvatarAemImageUrl() {
		return gamerAvatarAemImageUrl;
	}

	public void setGamerAvatarAemImageUrl(String gamerAvatarAemImageUrl) {
		this.gamerAvatarAemImageUrl = gamerAvatarAemImageUrl;
	}

	public Boolean getIsTestProfile() {
		return isTestProfile;
	}

	public void setIsTestProfile(final Boolean isTestProfile) {
		this.isTestProfile = isTestProfile;
	}

	public List<Object> getPersonalizedMessages() {
		return personalizedMessages;
	}

	public void setPersonalizedMessages(final List<Object> personalizedMessages) {
		this.personalizedMessages = personalizedMessages;
	}

	public List<Object> getMomentResults() {
		return momentResults;
	}

	public void setMomentResults(final List<Object> momentResults) {
		this.momentResults = momentResults;
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

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getMiddleInit() {
		return middleInit;
	}

	public void setMiddleInit(String middleInit) {
		this.middleInit = middleInit;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

}
