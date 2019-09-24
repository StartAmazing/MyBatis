package com.ll.mybatis.service.util;


import com.ll.mybatis.service.SqlSession;
import com.ll.mybatis.service.serviceImpl.DeptMapper;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class TestMain2 {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, SQLException {

        //得到代理对象
        SqlSession dao = SqlSessionProxyFactory.build(DeptMapper.class);

        String sql = "insert into dept values(50, '测试部','Alice',1,1)";

        Map statetmentMppper = new HashMap();

        statetmentMppper.put("dept.save","insert into dept values(50, '测试部','Alice',1,1)");
        dao.save((String) statetmentMppper.get("dept.save"));

    }
}
