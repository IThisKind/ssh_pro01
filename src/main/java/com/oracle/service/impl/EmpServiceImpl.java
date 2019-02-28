package com.oracle.service.impl;

import com.oracle.pojo.Emp;
import com.oracle.service.EmpService;
import com.oracle.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @Description: 雇员的业务层接口实现类
 * @Author: 牛
 * @CreateDate: 2019/2/28 10:40
 * @UpdateUser: 牛
 * @UpdateDate: 2019/2/28 10:40
 * @UpdateRemark:
 * @Version: 1.0
 **/
@Service("empService")
public class EmpServiceImpl extends BaseServiceImpl<Emp, Integer> implements EmpService {
}
