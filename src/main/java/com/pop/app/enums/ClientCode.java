/**
 * Created with IntelliJ IDEA.
 * User: walker
 * Date: 15/8/5
 * Time: 23:0
 * To change this template use File | Settings | File Templates.
 */

package com.pop.app.enums;

public enum ClientCode {
    SUCCESS(1, "成功"),


    SYSTEM_WRONG(-200, "系统繁忙，请稍后重试"),
    ARGUMENT_WRONG(-201, "请求参数不合法"),
    NULL_WRONG(-202, "空值错误"),
    ;

    private int code;

    private String msg;

    private ClientCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
