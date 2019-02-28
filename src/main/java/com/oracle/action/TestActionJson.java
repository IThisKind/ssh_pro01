package com.oracle.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.AllowedMethods;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.nio.channels.Pipe;

/**
 * @Description: 测试struts的json返回
 * @Author: 牛
 * @CreateDate: 2019/2/28 09:34
 * @UpdateUser: 牛
 * @UpdateDate: 2019/2/28 09:34
 * @UpdateRemark:
 * @Version: 1.0
 **/
@ParentPackage("json-default")
@Action(
        value = "json_*",
        results = {
                @Result(type = "json", params = {"root", "json"})
        }
)
@AllowedMethods({"test"})
@Component
@Scope("prototype")
public class TestActionJson extends ActionSupport {
    private Object json;

    public String test() {
        System.out.println(111);
        json = JSONObject.parse("{'a':2}");
        return "success";
    }
}
