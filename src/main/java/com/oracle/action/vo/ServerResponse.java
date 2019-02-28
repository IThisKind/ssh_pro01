package com.oracle.action.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;


/**
 * @Description: 封装后端返回的json数据
 * @Author: 牛向前
 * @CreateDate: 2019/2/8 21:59
 * @UpdateUser: 牛向前
 * @UpdateDate: 2019/2/8 21:59
 * @UpdateRemark:
 * @Version: 1.0
 **/
@Data
@NoArgsConstructor
public class ServerResponse<T> {

    /* 状态码*/
    private int statu;
    /* 错误信息*/
    private String errorMsg = "";
    /* 数据*/
    private T data;

    /**
     * 操作失败返回数据
     */
    public ServerResponse(int statu, String errorMsg, T data) {
        this.statu = statu;
        this.errorMsg = errorMsg;
        this.data = data;
    }

    /* 构造函数*/

    /**
     * 操作失败不返回数据
     */
    public ServerResponse(int statu, String errorMsg) {
        this.statu = statu;
        this.errorMsg = errorMsg;
    }

    /**
     * @Description: 操作成功返回数据
     * @Author: 牛
     * @Param: [statu, data]
     * @Return
     **/

    public ServerResponse(int statu, T data) {
        this.statu = statu;
        this.data = data;
    }

    /**
     * 成功返回数据
     */
    public static <T> ServerResponse<T> createBySuccess(T data) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), data);
    }

    /**
     * 成功返回数据 自定义成功码
     */
    public static <T> ServerResponse<T> createBySuccess(Integer code, T data) {
        return new ServerResponse<T>(code, data);
    }

    /**
     * 失败返回错误信息
     */
    public static <T> ServerResponse<T> createByException(String errorMsg) {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), errorMsg);
    }

    /**
     * 失败返回错误信息 自定义错误码
     */
    public static <T> ServerResponse<T> createByException(Integer code, String errorMsg) {
        return new ServerResponse<T>(code, errorMsg);
    }

    //使之不在序列化结果中
    @JSONField(serialize = false)
    public boolean checkIsSuccess() {
        return this.statu == ResponseCode.SUCCESS.getCode();
    }

}
