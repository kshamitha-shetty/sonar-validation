
package com.rnd.loyaltydemo.core.bo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Chain {

	@SerializedName("TierProgressionChainId")
	@Expose
	private String tierProgressionChainId;
	@SerializedName("TierCode")
	@Expose
	private String tierCode;
	@SerializedName("TierName")
	@Expose
	private String tierName;
	@SerializedName("TierProgressionCode")
	@Expose
	private String tierProgressionCode;
	@SerializedName("Aggregates")
	@Expose
	private List<Aggregate> aggregates = null;
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

	public String getTierProgressionChainId() {
		return tierProgressionChainId;
	}

	public void setTierProgressionChainId(String tierProgressionChainId) {
		this.tierProgressionChainId = tierProgressionChainId;
	}

	public String getTierCode() {
		return tierCode;
	}

	public void setTierCode(String tierCode) {
		this.tierCode = tierCode;
	}

	public String getTierName() {
		return tierName;
	}

	public void setTierName(String tierName) {
		this.tierName = tierName;
	}

	public String getTierProgressionCode() {
		return tierProgressionCode;
	}

	public void setTierProgressionCode(String tierProgressionCode) {
		this.tierProgressionCode = tierProgressionCode;
	}

	public List<Aggregate> getAggregates() {
		return aggregates;
	}

	public void setAggregates(List<Aggregate> aggregates) {
		this.aggregates = aggregates;
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
