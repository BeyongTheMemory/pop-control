package com.pop.app.request.user;

import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * Created by xugang on 16/8/6.
 */
public class LoginRequest {
    private String account;
    private String password;
    private String ip;


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
}
