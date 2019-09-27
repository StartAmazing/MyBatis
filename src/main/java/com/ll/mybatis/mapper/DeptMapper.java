package com.ll.mybatis.mapper;

import com.ll.mybatis.entity.Dept;
import org.apache.ibatis.annotations.Param;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

public interface DeptMapper {
    public void deptSave(Dept dept);
    public List<Dept> deptFind();
    public List<Dept> deptFind2(String param);
    public List<Dept> deptFind3(@Param("tableName") String tableName);
    public List<Dept> dept_1(Dept dept);
    public List<Dept> dept_2(Dept dept);
    public List<Dept> dept_3(Dept dept);
    public int deptUpdate(Dept dept);
    public int deptSave(List<Dept> depts);
    public List<Dept> deptFindByList(List<Integer> deptNos);
    public List<Dept> deptFindByArr(int[] array);
    public List<Dept> deptFindByMap(@Param("myMap") Map myMap);

    public List<Dept> deptWithEmpListFindById(Integer deptno);

    public List<Dept> deptFindByDeptNoWithEmp(Integer deptno);

}
