package com.pop.app.request.pop;

/**
 * Created by xugang on 16/8/9.
 */
public class NewPopRequest {
    private int type;
    private long longitude;
    private long latitude;
    private long altitude;
    private int model;
    private String imgUrl;
    private String message;
    private int isShowy;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getAltitude() {
        return altitude;
    }

    public void setAltitude(long altitude) {
        this.altitude = altitude;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getIsShowy() {
        return isShowy;
    }

    public void setIsShowy(int isShowy) {
        this.isShowy = isShowy;
    }
}
