package com.pop.app.request.user;

import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * Created by xugang on 16/8/6.
 */
public class LoginRequest {
    private String account;
    private String password;
    private String ip;
    private String clintId;
    private int clientType;//1:android,2:ios

    public String getAccount() {
        return account;
    }

    @ApiModelProperty(value = "帐号")
    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    @ApiModelProperty(value = "密码")
    public void setPassword(String password) {
        this.password = password;
    }

    public String getIp() {
        return ip;
    }

    @ApiModelProperty(value = "IP")
    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getClintId() {
        return clintId;
    }
    @ApiModelProperty(value = "设备号")
    public void setClintId(String clintId) {
        this.clintId = clintId;
    }

    public int getClientType() {
        return clientType;
    }
    @ApiModelProperty(value = "设备类型 1:andorid 2:ios")
    public void setClientType(int clientType) {
        this.clientType = clientType;
    }
}
