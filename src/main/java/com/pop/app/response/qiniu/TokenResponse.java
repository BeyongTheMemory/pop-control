package com.pop.app.response.qiniu;

import com.pop.app.response.Response;
import com.pop.app.response.ResultResponse;

/**
 * Created by xugang on 16/8/24.
 */
public class TokenResponse extends Response {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
