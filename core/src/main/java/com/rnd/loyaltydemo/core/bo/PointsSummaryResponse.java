
package com.rnd.loyaltydemo.core.bo;

public class PointsSummaryResponse extends GenericResponse{

    private PointsActivtyDetails[] response = null;

    public PointsActivtyDetails[] getResponse() {
        return response;
    }

    public void setResponse(PointsActivtyDetails[] response) {
        this.response = response;
    }
}