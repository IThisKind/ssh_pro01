package com.oracle.action;


import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Description: 测试struts
 * @Author: 牛
 * @CreateDate: 2019/2/27 21:54
 * @UpdateUser: 牛
 * @UpdateDate: 2019/2/27 21:54
 * @UpdateRemark:
 * @Version: 1.0
 **/
@ParentPackage("struts-default")
@Action(value = "test_*", results = {
        @Result(name = "{1}", location = "/{1}.html"),
})
@AllowedMethods({"test", "test2"})
@Component("testAction")
@Scope("prototype")
public class TestAction extends ActionSupport {

    public String test() {
        System.out.println(1111);
        return "test";
    }

    public String test2() {
        System.out.println(2222);
        return "test2";
    }


}


