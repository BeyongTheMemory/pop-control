package com.pop.app.request.pop;

import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * Created by xugang on 16/8/9.
 */
public class GetPopRequest {
    private double lat;
    private double lon;


    public double getLat() {
        return lat;
    }

    @ApiModelProperty(value = "纬度")
    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }
    @ApiModelProperty(value = "经度")
    public void setLon(double lon) {
        this.lon = lon;
    }

}
