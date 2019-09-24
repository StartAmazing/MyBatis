package com.ll.mybatis.service.serviceImpl;

import com.ll.mybatis.service.SqlSession;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeptMapper implements SqlSession {
    PreparedStatement ps;
    @Override
    public int save(String sql) throws SQLException {       //JDBC主要业务 输送sql

        int num = ps.executeUpdate(sql);
        return num;

    }
}
