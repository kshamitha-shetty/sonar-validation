
package com.rnd.loyaltydemo.core.bo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Aggregate {

	@SerializedName("RefTierProgressionAggrId")
	@Expose
	private String refTierProgressionAggrId;
	@SerializedName("AggregateId")
	@Expose
	private String aggregateId;
	@SerializedName("AggregateCode")
	@Expose
	private String aggregateCode;
	@SerializedName("AggregateOrder")
	@Expose
	private Integer aggregateOrder;
	@SerializedName("AggregateType")
	@Expose
	private String aggregateType;
	@SerializedName("AnnualThreshold")
	@Expose
	private Integer annualThreshold;
	@SerializedName("RefTierProgressionChainId")
	@Expose
	private String refTierProgressionChainId;
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

	public String getRefTierProgressionAggrId() {
		return refTierProgressionAggrId;
	}

	public void setRefTierProgressionAggrId(String refTierProgressionAggrId) {
		this.refTierProgressionAggrId = refTierProgressionAggrId;
	}

	public String getAggregateId() {
		return aggregateId;
	}

	public void setAggregateId(String aggregateId) {
		this.aggregateId = aggregateId;
	}

	public String getAggregateCode() {
		return aggregateCode;
	}

	public void setAggregateCode(String aggregateCode) {
		this.aggregateCode = aggregateCode;
	}

	public Integer getAggregateOrder() {
		return aggregateOrder;
	}

	public void setAggregateOrder(Integer aggregateOrder) {
		this.aggregateOrder = aggregateOrder;
	}

	public String getAggregateType() {
		return aggregateType;
	}

	public void setAggregateType(String aggregateType) {
		this.aggregateType = aggregateType;
	}

	public Integer getAnnualThreshold() {
		return annualThreshold;
	}

	public void setAnnualThreshold(Integer annualThreshold) {
		this.annualThreshold = annualThreshold;
	}

	public String getRefTierProgressionChainId() {
		return refTierProgressionChainId;
	}

	public void setRefTierProgressionChainId(String refTierProgressionChainId) {
		this.refTierProgressionChainId = refTierProgressionChainId;
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
