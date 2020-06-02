package com.rnd.loyaltydemo.core.bo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GenericResponse {
	@SerializedName("ErrorCode")
	@Expose
	private String errorCode;
	@SerializedName("Message")
	@Expose
	private String message;
	
	@SerializedName("statusCode")
	@Expose
	private int statusCode;

	@SerializedName("isPwdExpired")
	@Expose
	private boolean isPwdExpired;
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(final String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public boolean isPwdExpired() {
		return isPwdExpired;
	}

	public void setPwdExpired(boolean pwdExpired) {
		isPwdExpired = pwdExpired;
	}
}
