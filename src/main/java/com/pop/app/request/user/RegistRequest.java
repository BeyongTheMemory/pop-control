package com.pop.app.request.user;

import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * Created by xugang on 16/8/6.
 */
public class RegistRequest {
    private String account;
    private String password;
    private String name;
    private String headUrl;
    private String introduction;

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
    public String getName() {
        return name;
    }
    @ApiModelProperty(value = "姓名")
    public void setName(String name) {
        this.name = name;
    }
    public String getHeadUrl() {
        return headUrl;
    }
    @ApiModelProperty(value = "头像")
    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }
    public String getIntroduction() {
        return introduction;
    }
    @ApiModelProperty(value = "介绍")
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
