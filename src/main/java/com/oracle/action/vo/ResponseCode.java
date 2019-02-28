package com.oracle.action.vo;

/**
 * @Description: 定义响应的状态码以及错误信息
 * @Author: 牛向前
 * @CreateDate: 2019/2/8 22:12
 * @UpdateUser: 牛向前
 * @UpdateDate: 2019/2/8 22:12
 * @UpdateRemark:
 * @Version: 1.0
 **/
public enum ResponseCode {
    /* 成功*/
    SUCCESS(200, "success"),
    /* 服务器异常*/
    ERROR(500, "server_exception"),
    /* 数据没找到*/
    NOT_FOUND(404, "data_not_found");
    /* 错误码*/
    private int code;
    /* 错误信息*/
    private String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
