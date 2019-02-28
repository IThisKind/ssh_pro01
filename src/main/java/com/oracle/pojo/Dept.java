package com.oracle.pojo;

import javax.persistence.*;
import java.util.List;

/**
 * @Description:
 * @Author: 牛
 * @CreateDate: 2019/2/27 22:00
 * @UpdateUser: 牛
 * @UpdateDate: 2019/2/27 22:00
 * @UpdateRemark:
 * @Version: 1.0
 **/
@Entity
public class Dept {
    private Integer deptno;
    private String dname;
    private String loc;
    private List<Emp> emps;

    @Id
    @Column(name = "DEPTNO", nullable = false)
    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    @Basic
    @Column(name = "DNAME", nullable = true, length = 14)
    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Basic
    @Column(name = "LOC", nullable = true, length = 13)
    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dept dept = (Dept) o;

        if (deptno != null ? !deptno.equals(dept.deptno) : dept.deptno != null) return false;
        if (dname != null ? !dname.equals(dept.dname) : dept.dname != null) return false;
        if (loc != null ? !loc.equals(dept.loc) : dept.loc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = deptno != null ? deptno.hashCode() : 0;
        result = 31 * result + (dname != null ? dname.hashCode() : 0);
        result = 31 * result + (loc != null ? loc.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "dept")
    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }
}
