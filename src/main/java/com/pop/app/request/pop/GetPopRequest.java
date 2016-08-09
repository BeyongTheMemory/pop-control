package com.pop.app.request.pop;

import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * Created by xugang on 16/8/9.
 */
public class GetPopRequest {
    private double lat;
    private double lon;
    private int range;
    private int pageNumber;
    private int pageSize;

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

    public int getRange() {
        return range;
    }
    @ApiModelProperty(value = "范围,m")
    public void setRange(int range) {
        this.range = range;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
