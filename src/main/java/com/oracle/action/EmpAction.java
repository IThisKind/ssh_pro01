package com.oracle.action;

import com.opensymphony.xwork2.ActionSupport;
import com.oracle.pojo.Emp;
import com.oracle.service.EmpService;
import com.oracle.service.Page;
import com.oracle.utils.ValueContext;
import lombok.*;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.AllowedMethods;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

/**
 * @Description: 雇员的动作类
 * @Author: 牛
 * @CreateDate: 2019/2/28 10:41
 * @UpdateUser: 牛
 * @UpdateDate: 2019/2/28 10:41
 * @UpdateRemark:
 * @Version: 1.0
 **/
@ParentPackage("/")
@Action(value = "emp_*",
        results = {
                @Result(name = "{1}", location = "/page.jsp")
        }
)
@Component
@Scope("prototype")
@AllowedMethods({"getPage"})
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmpAction extends ActionSupport {

    @Resource(name = "empService")
    private EmpService empService;

    //当前页
    private Integer currentPage;
    //每页大小
    private Integer size;

    /**
     * @Description: 查看一页数据
     * @Author: 牛
     * @Param: []
     * @Return java.lang.String
     **/
    public String getPage() {
        System.out.println("getPage");
        Page<Emp> page = empService.findOnePage(currentPage, size);
        ValueContext.setAtribute("page", page);

        return "list";
    }
}
