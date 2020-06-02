
package com.rnd.loyaltydemo.core.bo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PointsBalanceDetails {

	@SerializedName("PointAmount")
	@Expose
	private Double pointAmount;
	@SerializedName("PointTypeShortDescription")
	@Expose
	private String pointTypeShortDescription;
	@SerializedName("PointTypeId")
	@Expose
	private String pointTypeId;

	public Double getPointAmount() {
		return pointAmount;
	}

	public void setPointAmount(Double pointAmount) {
		this.pointAmount = pointAmount;
	}

	public String getPointTypeShortDescription() {
		return pointTypeShortDescription;
	}

	public void setPointTypeShortDescription(String pointTypeShortDescription) {
		this.pointTypeShortDescription = pointTypeShortDescription;
	}

	public String getPointTypeId() {
		return pointTypeId;
	}

	public void setPointTypeId(String pointTypeId) {
		this.pointTypeId = pointTypeId;
	}

}
