package com.pop.app.request.pop;

/**
 * Created by xugang on 16/10/8.
 */
public class AddMessageRequest {
    private long popId;
    private String message;
    private double latitude;
    private double longitude;

    public long getPopId() {
        return popId;
    }

    public void setPopId(long popId) {
        this.popId = popId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
