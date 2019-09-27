package com.ll.mybatis.entity;

import java.util.List;

public class Dept {

    private Integer deptNo;
    private String dname;
    private String dmanager;
    private Boolean flag;
    private Boolean status;
    private String country;

    //隶属于当前部门下的所有职员集合
    private List<Employee> employees;

    @Override
    public String toString() {
        return "Dept{" +
                "deptNo=" + deptNo +
                ", dname='" + dname + '\'' +
                ", dmanager='" + dmanager + '\'' +
                ", flag=" + flag +
                ", status=" + status +
                ", country='" + country + '\'' +
                ", employees=" + employees +
                '}';
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Dept(Integer deptNo, String dname, String dmanager) {
        this.deptNo = deptNo;
        this.dname = dname;
        this.dmanager = dmanager;
    }

    public Dept() {
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public String getDname() {
        return dname;
    }

    public String getDmanager() {
        return dmanager;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public void setDmanager(String dmanager) {
        this.dmanager = dmanager;
    }
}
