package com.ll.mybatis.service;

import java.sql.SQLException;

public interface SqlSession {

    public int save(String sql) throws SQLException;

}
