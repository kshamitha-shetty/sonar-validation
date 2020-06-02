
package com.rnd.loyaltydemo.core.bo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PointBalanceResponse extends GenericResponse{

    @SerializedName("ProfileId")
    @Expose
    private String profileId;
    @SerializedName("PendingPointsEnabled")
    @Expose
    private Boolean pendingPointsEnabled;
    @SerializedName("DefaultPointTypeId")
    @Expose
    private String defaultPointTypeId;
    @SerializedName("PointsBalance")
    @Expose
    private List<PointsBalanceDetails> pointsBalance = null;
    @SerializedName("PendingPointsBalance")
    @Expose
    private List<PointsBalanceDetails> pendingPointsBalance = null;
    @SerializedName("PoolingPointsBalance")
    @Expose
    private List<PointsBalanceDetails> poolingPointsBalance = null;
    @SerializedName("PendingPoolingPointsBalance")
    @Expose
    private List<PointsBalanceDetails> pendingPoolingPointsBalance = null;
    @SerializedName("ScheduledExpiringPointsBalance")
    @Expose
    private List<PointsBalanceDetails> scheduledExpiringPointsBalance = null;
    @SerializedName("PendingScheduledExpiringPointsBalance")
    @Expose
    private List<PointsBalanceDetails> pendingScheduledExpiringPointsBalance = null;
    @SerializedName("ScheduledExpiringPoolingPointsBalance")
    @Expose
    private List<PointsBalanceDetails> scheduledExpiringPoolingPointsBalance = null;
    @SerializedName("PendingScheduledExpiringPoolingPointsBalance")
    @Expose
    private List<PointsBalanceDetails> pendingScheduledExpiringPoolingPointsBalance = null;

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public Boolean getPendingPointsEnabled() {
        return pendingPointsEnabled;
    }

    public void setPendingPointsEnabled(Boolean pendingPointsEnabled) {
        this.pendingPointsEnabled = pendingPointsEnabled;
    }

    public String getDefaultPointTypeId() {
        return defaultPointTypeId;
    }

    public void setDefaultPointTypeId(String defaultPointTypeId) {
        this.defaultPointTypeId = defaultPointTypeId;
    }

    public List<PointsBalanceDetails> getPointsBalance() {
        return pointsBalance;
    }

    public void setPointsBalance(List<PointsBalanceDetails> pointsBalance) {
        this.pointsBalance = pointsBalance;
    }

    public List<PointsBalanceDetails> getPendingPointsBalance() {
        return pendingPointsBalance;
    }

    public void setPendingPointsBalance(List<PointsBalanceDetails> pendingPointsBalance) {
        this.pendingPointsBalance = pendingPointsBalance;
    }

    public List<PointsBalanceDetails> getPoolingPointsBalance() {
        return poolingPointsBalance;
    }

    public void setPoolingPointsBalance(List<PointsBalanceDetails> poolingPointsBalance) {
        this.poolingPointsBalance = poolingPointsBalance;
    }

    public List<PointsBalanceDetails> getPendingPoolingPointsBalance() {
        return pendingPoolingPointsBalance;
    }

    public void setPendingPoolingPointsBalance(List<PointsBalanceDetails> pendingPoolingPointsBalance) {
        this.pendingPoolingPointsBalance = pendingPoolingPointsBalance;
    }

    public List<PointsBalanceDetails> getScheduledExpiringPointsBalance() {
        return scheduledExpiringPointsBalance;
    }

    public void setScheduledExpiringPointsBalance(List<PointsBalanceDetails> scheduledExpiringPointsBalance) {
        this.scheduledExpiringPointsBalance = scheduledExpiringPointsBalance;
    }

    public List<PointsBalanceDetails> getPendingScheduledExpiringPointsBalance() {
        return pendingScheduledExpiringPointsBalance;
    }

    public void setPendingScheduledExpiringPointsBalance(List<PointsBalanceDetails> pendingScheduledExpiringPointsBalance) {
        this.pendingScheduledExpiringPointsBalance = pendingScheduledExpiringPointsBalance;
    }

    public List<PointsBalanceDetails> getScheduledExpiringPoolingPointsBalance() {
        return scheduledExpiringPoolingPointsBalance;
    }

    public void setScheduledExpiringPoolingPointsBalance(List<PointsBalanceDetails> scheduledExpiringPoolingPointsBalance) {
        this.scheduledExpiringPoolingPointsBalance = scheduledExpiringPoolingPointsBalance;
    }

    public List<PointsBalanceDetails> getPendingScheduledExpiringPoolingPointsBalance() {
        return pendingScheduledExpiringPoolingPointsBalance;
    }

    public void setPendingScheduledExpiringPoolingPointsBalance(List<PointsBalanceDetails> pendingScheduledExpiringPoolingPointsBalance) {
        this.pendingScheduledExpiringPoolingPointsBalance = pendingScheduledExpiringPoolingPointsBalance;
    }

}
