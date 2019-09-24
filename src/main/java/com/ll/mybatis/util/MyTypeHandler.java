package com.ll.mybatis.util;

import com.ll.mybatis.entity.Dept;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyTypeHandler implements TypeHandler{
    /**
     * SetParameter方法
     *          在生成SQL语句时被调用
     * @param ps        正在被创建的preparedStatement对象
     * @param i         要使用的占位符的位置
     * @param parameter     占位符的数据
     * @param jdbcType      jdbc类型
     * @throws SQLException
     */
    @Override
    public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        if(parameter == null){      //dept.flag == null insertsql flag设置为0
            ps.setInt(i,0);
            return;
        }
        System.out.println("类型转换器运行中");
        Boolean flag = (Boolean)parameter;
        if(flag){
            ps.setInt(i,1);
        }else{
            ps.setInt(i,0);
        }
    }

    /**
     * getResult方法:
     *          查询结束之后，在将ResultSet数据行转换为实体类对象时，
     *          通知TypeHandler将当前数据行某个字段转换为何种类型
     * @param rs
     * @param columnName
     * @return
     * @throws SQLException
     */
    @Override
    public Object getResult(ResultSet rs, String columnName) throws SQLException {
        int flag = rs.getInt(columnName);
        Boolean myFlag = Boolean.FALSE;
        if(flag == 1){
            myFlag = Boolean.TRUE;
        }
        return myFlag;
    }

    @Override
    public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }
}
