package com.rnd.loyaltydemo.core.bo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReferralCode extends GenericResponse {
	@SerializedName("ReferralCode")
	@Expose
	private String referalCode;

	@SerializedName("ProfileReferralCodeId")
	@Expose
	private String profileReferralCodeId;

	/**
	 * @return the referralCode
	 */
	public String getReferralCode() {
		return referalCode;
	}

	/**
	 * @param referralCode the referralCode to set
	 */
	public void setReferralCode(String referralCode) {
		this.referalCode = referralCode;
	}

	/**
	 * @return the profileReferralCodeId
	 */
	public String getProfileReferralCodeId() {
		return profileReferralCodeId;
	}

	/**
	 * @param profileReferralCodeId the profileReferralCodeId to set
	 */
	public void setProfileReferralCodeId(String profileReferralCodeId) {
		this.profileReferralCodeId = profileReferralCodeId;
	}
	
}
