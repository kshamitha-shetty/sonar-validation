
package com.rnd.loyaltydemo.core.bo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileAggregate {

    @SerializedName("AggregateEntityCode")
    @Expose
    private String aggregateEntityCode;
    @SerializedName("AggregateTotal")
    @Expose
    private Integer aggregateTotal;

    public String getAggregateEntityCode() {
        return aggregateEntityCode;
    }

    public void setAggregateEntityCode(String aggregateEntityCode) {
        this.aggregateEntityCode = aggregateEntityCode;
    }

    public Integer getAggregateTotal() {
        return aggregateTotal;
    }

    public void setAggregateTotal(Integer aggregateTotal) {
        this.aggregateTotal = aggregateTotal;
    }

}
