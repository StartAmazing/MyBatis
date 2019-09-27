package com.ll;

import com.ll.mybatis.entity.Dept;
import com.ll.mybatis.entity.Employee;
import com.ll.mybatis.mapper.DeptMapper;
import com.ll.mybatis.mapper.EmpMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MybatisMain {

    public static void main(String[] args) throws IOException {

    }

    @Test
    public void testMybatisInsert() throws IOException {
        Dept dept = new Dept();
        dept.setDeptNo(1);
        dept.setDname("融合中台");
        dept.setDmanager("lullaby");
        dept.setFlag(true);     //表中与之对应的数据值应该是1
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();
        session.insert("insertDept",dept);
        session.commit();
        session.close();
    }

    @Test
    public void testMybatisSelect() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();
        session.clearCache();
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        List<Dept> depts = mapper.deptFind();
        depts.forEach(System.out::println);
        session.commit();
        session.close();
    }

    @Test
    public void testMybatisFind2() throws Exception{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();
        DeptMapper dao = session.getMapper(DeptMapper.class);
        List<Dept> list = dao.deptFind2("SALE");
        list.forEach(System.out::println);
        session.commit();
        session.close();
    }

    @Test
    public void testMybatisFind3() throws Exception {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();
        DeptMapper dao = session.getMapper(DeptMapper.class);
        List<Dept> list = dao.deptFind3("dept2");
        list.forEach(System.out::println);
        session.commit();
        session.close();
    }


    @Test
    public void testResultMap() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sqlSessionFactory.openSession();
        EmpMapper mapper = session.getMapper(EmpMapper.class);
        List<Employee> employees = mapper.empFind();
        employees.forEach(System.out::println);
        session.commit();
        session.close();
    }

    @Test
    public void testDynamic_Sql() throws Exception{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        Dept dept = new Dept();
        dept.setDeptNo(50);
        List<Dept> depts = mapper.dept_1(new Dept());
        depts.forEach(System.out::println);
        session.commit();
        session.close();
    }

    @Test
    public void testDynamic_Sql2() throws Exception{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        Dept dept = new Dept();
        dept.setDeptNo(50);
        List<Dept> depts = mapper.dept_2(dept);
        depts.forEach(System.out::println);
        session.commit();
        session.close();
    }
    @Test
    public void testDynamic_Sql3() throws Exception{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        Dept dept = new Dept();
        dept.setDeptNo(1);
        List<Dept> depts = mapper.dept_3(dept);
        depts.forEach(System.out::println);
        session.commit();
        session.close();
    }

    @Test
    public void testWhen_sql() throws Exception{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sqlSessionFactory.openSession();
        EmpMapper mapper = session.getMapper(EmpMapper.class);
        Employee employee = new Employee();
        employee.setSal(14000.0);
        List<Employee> employees = mapper.empFind2(employee);
        employees.forEach(System.out::println);
        session.commit();
        session.close();
    }

    @Test
    public void testSet() throws Exception{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sqlSessionFactory.openSession();
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        Dept dept = new Dept();
        dept.setDeptNo(1);
        dept.setDname("PCM事业部");
        dept.setDmanager("LL");
        mapper.deptUpdate(dept);
        session.commit();
        session.close();
    }

    @Test
    public void testForEach() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sqlSessionFactory.openSession();
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        List<Dept> depts = new ArrayList<>();
        Dept deptA = new Dept();
        deptA.setDeptNo(20);
        deptA.setDname("甄云事业部");
        deptA.setDmanager("LuC");
        Dept deptB = new Dept();
        deptB.setDeptNo(30);
        deptB.setDname("会计金融事业部");
        deptB.setDmanager("Alice");
        depts.add(deptA);
        depts.add(deptB);
        mapper.deptSave(depts);
        session.commit();
        session.close();
    }

    @Test
    public void testForEach2() throws Exception{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sqlSessionFactory.openSession();
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        List<Integer> deptNos = new ArrayList<>();
        deptNos.add(30);
        deptNos.add(20);
        deptNos.add(50);
        List depts = mapper.deptFindByList(deptNos);
        session.close();
        depts.forEach(item -> {
            System.out.println(item.toString());
        });
    }

    @Test
    public void testForEachArr() throws Exception{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sqlSessionFactory.openSession();
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        List depts = mapper.deptFindByArr(new int[]{10,20,30});
        session.close();
        depts.forEach(item -> {
            System.out.println(item.toString());
        });
    }

    @Test
    public void testForEachMap() throws Exception{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sqlSessionFactory.openSession();
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(1121,40);
        map.put(1222,50);
        List depts = mapper.deptFindByMap(map);
        session.close();
        depts.forEach(item -> {
            System.out.println(item.toString());
        });
    }

    @Test
    public void testJoinSelect() throws Exception{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sqlSessionFactory.openSession();
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        List<Dept> depts = mapper.deptWithEmpListFindById(10);
        depts.forEach( dept -> {
            depts.forEach(dept1 -> {
                System.out.println(dept);
            });
            dept.getEmployees().forEach(System.out::println);
        });
    }

    @Test
    public void testJoinSelectWithEmp() throws Exception{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sqlSessionFactory.openSession();
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        List<Dept> depts = mapper.deptFindByDeptNoWithEmp(10);
        depts.forEach( dept -> {
            depts.forEach(dept1 -> {
                System.out.println(dept);
            });
            dept.getEmployees().forEach(System.out::println);
        });
    }

    @Test
    public void testManyToOneWithAssosicationTag() throws Exception{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sqlSessionFactory.openSession();
        EmpMapper mapper = session.getMapper(EmpMapper.class);
        Employee employee = mapper.empFindByIdxxx(3);
        System.out.println(employee);
    }
}
