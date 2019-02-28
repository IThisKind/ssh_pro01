package com.oracle.utils;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

/**
 * <p>Title: ValueContext</p>
 * <p>Description:值栈 </p>
 *
 * @author 丁乾文
 * @version 1.0
 * @date 2019年2月19日
 */
public class ValueContext {

    /**
     * 放置在Root栈中
     * <p>Title: putValueContext</p>
     * <p>Description: </p>
     *
     * @param key
     * @param value
     */
    public static void putValueContext(String key, Object value) {
        ActionContext.getContext().put(key, value);
    }

    /**
     * 压入栈顶
     * <p>Title: putValueStack</p>
     * <p>Description: </p>
     *
     * @param o
     */
    public static void putValueStack(Object o) {
        ServletActionContext.getContext().getValueStack().push(o);
    }
}
