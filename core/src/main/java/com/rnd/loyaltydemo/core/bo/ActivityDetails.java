package com.rnd.loyaltydemo.core.bo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ActivityDetails {
	@SerializedName("TransactionDetailId")
	@Expose
	private String transactionDetailId;
	@SerializedName("TransactionId")
	@Expose
	private String transactionId;
	@SerializedName("DollarValueGross")
	@Expose
	private String dollarValueGross;
	@SerializedName("ItemNumber")
	@Expose
	private String itemNumber;
	@SerializedName("Quantity")
	@Expose
	private String quantity;
	@SerializedName("LineNumber")
	@Expose
	private String lineNumber;
	@SerializedName("Status")
	@Expose
	private String status;
	@SerializedName("BrandOrgCode")
	@Expose
	private String brandOrgCode;
	@SerializedName("ItemDescription")
	@Expose
	private String itemDescription;
	@SerializedName("TransactionDateTime")
	@Expose
	private String transactionDateTime;
	@SerializedName("ItemGiftFlag")
	@Expose
	private String itemGiftFlag;
	@SerializedName("GwpFlag")
	@Expose
	private String gwpFlag;
	@SerializedName("GiftWrapFlag")
	@Expose
	private String giftWrapFlag;
	@SerializedName("MarkDownFlag")
	@Expose
	private String markDownFlag;
	@SerializedName("TransactionNumber")
	@Expose
	private String transactionNumber;
	@SerializedName("EligibleRevenue")
	@Expose
	private String eligibleRevenue;
	@SerializedName("RewardTitle")
	@Expose
	private String rewardTitle;
	@SerializedName("TotalPointsPaid")
	@Expose
	private String totalPointsPaid;
	@SerializedName("OrderDetailStatusDescription")
	@Expose
	private String orderDetailStatusDescription;
	@SerializedName("ShippingInfoRequired")
	@Expose
	private String shippingInfoRequired;

	public String getTransactionDetailId() {
		return transactionDetailId;
	}

	public void setTransactionDetailId(String transactionDetailId) {
		this.transactionDetailId = transactionDetailId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getDollarValueGross() {
		return dollarValueGross;
	}

	public void setDollarValueGross(String dollarValueGross) {
		this.dollarValueGross = dollarValueGross;
	}

	public String getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBrandOrgCode() {
		return brandOrgCode;
	}

	public void setBrandOrgCode(String brandOrgCode) {
		this.brandOrgCode = brandOrgCode;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(String transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

	public String getItemGiftFlag() {
		return itemGiftFlag;
	}

	public void setItemGiftFlag(String itemGiftFlag) {
		this.itemGiftFlag = itemGiftFlag;
	}

	public String getGwpFlag() {
		return gwpFlag;
	}

	public void setGwpFlag(String gwpFlag) {
		this.gwpFlag = gwpFlag;
	}

	public String getGiftWrapFlag() {
		return giftWrapFlag;
	}

	public void setGiftWrapFlag(String giftWrapFlag) {
		this.giftWrapFlag = giftWrapFlag;
	}

	public String getMarkDownFlag() {
		return markDownFlag;
	}

	public void setMarkDownFlag(String markDownFlag) {
		this.markDownFlag = markDownFlag;
	}

	public String getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public String getEligibleRevenue() {
		return eligibleRevenue;
	}

	public void setEligibleRevenue(String eligibleRevenue) {
		this.eligibleRevenue = eligibleRevenue;
	}

	public String getShippingInfoRequired() {
		return shippingInfoRequired;
	}

	public void setShippingInfoRequired(String shippingInfoRequired) {
		this.shippingInfoRequired = shippingInfoRequired;
	}

	public String getRewardTitle() {
		return rewardTitle;
	}

	public void setRewardTitle(String rewardTitle) {
		this.rewardTitle = rewardTitle;
	}

	public String getTotalPointsPaid() {
		return totalPointsPaid;
	}

	public void setTotalPointsPaid(String totalPointsPaid) {
		this.totalPointsPaid = totalPointsPaid;
	}

	public String getOrderDetailStatusDescription() {
		return orderDetailStatusDescription;
	}

	public void setOrderDetailStatusDescription(String orderDetailStatusDescription) {
		this.orderDetailStatusDescription = orderDetailStatusDescription;
	}

}
