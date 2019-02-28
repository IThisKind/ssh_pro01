package com.oracle.utils;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

/**
 * <p>Title: ValueContext</p>
 * <p>Description:值栈 </p>
 *
 * @version 1.0
 * @date 2019年2月19日
 */
public class ValueContext {

    /**
     * @Description:
     * @Author: 牛
     * @Param: [key, value]
     * @Return void
     **/
    public static void putValueContext(String key, Object value) {
        ActionContext.getContext().put(key, value);
    }

    /**
     * @Description:
     * @Author: 牛
     * @Param: [o]
     * @Return void
     **/
    public static void putValueStack(Object o) {
        ServletActionContext.getContext().getValueStack().push(o);
    }

    /**
     * @Description: 放入请求属性中
     * @Author: 牛
     * @Param: [key, value]
     * @Return void
     **/
    public static void setAtribute(String key, Object value) {
        ServletActionContext.getRequest().setAttribute(key, value);

    }
}
