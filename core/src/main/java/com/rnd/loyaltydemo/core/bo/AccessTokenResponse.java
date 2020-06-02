package com.rnd.loyaltydemo.core.bo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccessTokenResponse extends GenericResponse{

	@SerializedName("ProgramCode")
	@Expose
	private String programCode;
	@SerializedName("ProfileId")
	@Expose
	private String profileId;
	@SerializedName("Username")
	@Expose
	private String username;
	@SerializedName("AccessToken")
	@Expose
	private String accessToken;
	@SerializedName("RefreshToken")
	@Expose
	private String refreshToken;
	@SerializedName("AccessTokenExpiration")
	@Expose
	private String accessTokenExpiration;
	@SerializedName("RefreshTokenExpiration")
	@Expose
	private String refreshTokenExpiration;
	@SerializedName("Success")
	@Expose
	private Boolean success;
	@SerializedName("RequireSsl")
	@Expose
	private Boolean requireSsl;
	@SerializedName("IsPasswordExpired")
	@Expose
	private Boolean isPasswordExpired;
	@SerializedName("TenantId")
	@Expose
	private String tenantId;
	@SerializedName("TenantName")
	@Expose
	private String tenantName;
	@SerializedName("TermsConditionsAcceptedInd")
	@Expose
	private Boolean termsConditionsAcceptedInd;
	
	public String getProgramCode() {
		return programCode;
	}

	public void setProgramCode(final String programCode) {
		this.programCode = programCode;
	}

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(final String profileId) {
		this.profileId = profileId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(final String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(final String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getAccessTokenExpiration() {
		return accessTokenExpiration;
	}

	public void setAccessTokenExpiration(final String accessTokenExpiration) {
		this.accessTokenExpiration = accessTokenExpiration;
	}

	public String getRefreshTokenExpiration() {
		return refreshTokenExpiration;
	}

	public void setRefreshTokenExpiration(final String refreshTokenExpiration) {
		this.refreshTokenExpiration = refreshTokenExpiration;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(final Boolean success) {
		this.success = success;
	}

	public Boolean getRequireSsl() {
		return requireSsl;
	}

	public void setRequireSsl(final Boolean requireSsl) {
		this.requireSsl = requireSsl;
	}

	public Boolean getIsPasswordExpired() {
		return isPasswordExpired;
	}

	public void setIsPasswordExpired(final Boolean isPasswordExpired) {
		this.isPasswordExpired = isPasswordExpired;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(final String tenantId) {
		this.tenantId = tenantId;
	}

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(final String tenantName) {
		this.tenantName = tenantName;
	}

	public Boolean getTermsConditionsAcceptedInd() {
		return termsConditionsAcceptedInd;
	}

	public void setTermsConditionsAcceptedInd(
			final Boolean termsConditionsAcceptedInd) {
		this.termsConditionsAcceptedInd = termsConditionsAcceptedInd;
	}

}
