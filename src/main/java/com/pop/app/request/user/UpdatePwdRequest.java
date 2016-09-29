package com.pop.app.request.user;

/**
 * Created by xugang on 16/9/22.
 */
public class UpdatePwdRequest {
    public String oldPwd;
    public String newPwd;


    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }
}
