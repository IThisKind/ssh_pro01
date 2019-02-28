package com.oracle.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import com.oracle.pojo.Emp;
import com.oracle.service.EmpService;
import com.oracle.service.Page;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.convention.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description: 雇员的返回json数据格式动作
 * @Author: 牛
 * @CreateDate: 2019/2/28 11:35
 * @UpdateUser: 牛
 * @UpdateDate: 2019/2/28 11:35
 * @UpdateRemark:
 * @Version: 1.0
 **/
@Namespace("/")
@ParentPackage("json-default")
@Action(
        value = "emp-*",
        results = {
                @Result(name = "success", type = "json", params = {"root", "json"})
        }
)
@AllowedMethods({"getPage"})
@Component
@Scope("prototype")
@Setter
@Getter
public class EmpActionJson extends ActionSupport {
    @Resource(name = "empService")
    private EmpService empService;

    //当前页
    private Integer currentPage;
    //每页大小
    private Integer size;

    private Object json;

    /**
     * @Description: 查看一页数据
     * @Author: 牛
     * @Param: []
     * @Return java.lang.String
     **/
    public String getPage() {

        System.out.println("getPage_json");
        System.out.println(currentPage + "\t" + size);
        Page<Emp> page = empService.findOnePage(currentPage, size);
        json = JSONObject.toJSON(page);

        return "success";
    }
}
