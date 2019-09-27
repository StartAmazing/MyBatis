package com.ll.mybatis.mapper;

import com.ll.mybatis.entity.Employee;

import java.util.List;

public interface EmpMapper {

    public List<Employee> empFind();

    public List<Employee> empFind2(Employee employee);

    public Employee empFindByIdxxx(Integer empno);

}
