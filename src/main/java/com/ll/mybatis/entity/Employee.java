package com.ll.mybatis.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
    private Integer empNo;
    private String ename;
    private String job;
    private Double sal;
    private Date hireDate;

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

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
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

    @Override
    public String toString() {
        return "Employee{" +
                "empNo=" + empNo +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", sal=" + sal +
                ", hireDate=" + hireDate +
                ", workAge=" + workAge +
                '}';
    }
}
