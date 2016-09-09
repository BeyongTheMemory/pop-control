package com.pop.app.rest;

import com.pop.app.response.qiniu.TokenResponse;
import com.pop.security.annotion.NeedRoles;
import com.qiniu.util.Auth;
import com.wordnik.swagger.annotations.*;
import ocean.fastdfs.FastdfsClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by xugang on 16/8/7.
 */
@RestController
@RequestMapping(value = "/qiniu")
@Api(value = "qiniu", description = "七牛相关api")
public class QiNiuControl {
    final static Logger logger = LoggerFactory.getLogger(QiNiuControl.class);
    @Autowired
    private FastdfsClientFactory fastdfsClientFactory;

    String ACCESS_KEY = "dr56VGibvHi2T2sUs7t_nFI384KvdrPqjI2XeCzv";
    String SECRET_KEY = "dMcguL6BSdxmjVqmLuUk9ob7jJfhrt0i0tTROefh";



    String headBucketName = "headimg";

    @ApiResponses(value = {@ApiResponse(code = 200, message = "请求成功")})
    @ApiOperation(value = "获取token", notes = "获取token")
    @RequestMapping(value = "/getToken", method = RequestMethod.POST)
    @NeedRoles
    public TokenResponse getToken(@RequestParam("type")String type) {
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        String token = "";
        switch (type){
            case "head":
                token = auth.uploadToken(headBucketName);
                break;
        }
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setToken(token);
        return tokenResponse;
    }


}
