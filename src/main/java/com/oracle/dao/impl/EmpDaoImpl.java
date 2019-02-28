package com.oracle.dao.impl;

import com.oracle.dao.EmpDao;
import com.oracle.dao.base.BaseDaoImpl;
import com.oracle.pojo.Emp;
import org.springframework.stereotype.Repository;

/**
 * @Description: 雇员的业务层接口实现类
 * @Author: 牛
 * @CreateDate: 2019/2/28 10:35
 * @UpdateUser: 牛
 * @UpdateDate: 2019/2/28 10:35
 * @UpdateRemark:
 * @Version: 1.0
 **/
@Repository("empDao")
public class EmpDaoImpl extends BaseDaoImpl<Emp, Integer> implements EmpDao {

}
