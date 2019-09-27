package com.ll.mybatis.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
    private Integer empno;
    private String ename;
    private String job;
    private Double sal;
    private Date hireDate;

    @Override
    public String toString() {
        return "Employee{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", sal=" + sal +
                ", hireDate=" + hireDate +
                ", dept=" + dept +
                ", deptNo=" + deptNo +
                ", workAge=" + workAge +
                '}';
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    //当前职员隶属的部门信息
    private Dept dept;

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    private Integer deptNo;

    public Employee() {
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    //职员工作年限
    private int workAge;

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public int getWorkAge() {
        return workAge;
    }

    public void setWorkAge(int workAge) {
        this.workAge = workAge;
    }

    //构造函数
    public Employee(Date tempDate){
        this.hireDate = tempDate;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        this.workAge = Integer.valueOf(simpleDateFormat.format(new Date())) - Integer.valueOf(simpleDateFormat.format(hireDate));
    }

}
