package com.scdkay.website.constant;

/**
 * http请求码与请求信息
 * Created by liurui on 2017/7/13.
 */
public enum HttpStatus {
    SUCCESS(0, "请求成功！"),
    ERROR(-1, "请求出现未知错误！"),
    FAILURE(1, "请求失败！"),
    DBERROR(3, "数据库查询出错！"),
    REFUSE(4, "请求被拒绝！"),
    TIMEOUT(5, "请求超时！");


    int code;
    String message;

    HttpStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }


    public String getMessage() {
        return message;
    }

}
