package com.ll.mybatis.service.util;

import com.ll.mybatis.service.SqlSession;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//代理具体的实现类，继承InvocationHandler接口
public class Invocation implements InvocationHandler {

    private SqlSession obj; //具体被监控的对象
    private Connection connection;
    private PreparedStatement pStatement;

    public Invocation(SqlSession sqlSession){
        this.obj = sqlSession;
    }
    /**
     * invoke 方法： 在被监控行为将要执行时，会被JVM拦截，被监控行为和行为实现
     * 方会被当做参数输送到invoke
     * ****通知jvm，这个被拦截方法是如何与当前次要的业务方法绑定实现的
     * 举个例子：
     *      小明.eat(); //JVM拦截
     *      eat方法被封装为Method类型对象         第二个参数
     *      eat方法运行时接受所有的实参封装到Object[]中        第三个参数
     *      将负责监控小明的代理对象作为invoke方法的第一个参数 ---其实在实现中并没有用到这个代理对象
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object value;
        //1.执行jdbc初始化次要业务
        init();
        //2. 执行jdbc主要业务
        Field psField = obj.getClass().getDeclaredField("ps");
        psField.setAccessible(true);
        psField.set(obj,pStatement);
        value = method.invoke(obj,args);
        //3. 执行jdbc结束次要业务
//        close();
        return value;       //返回被拦截的方法，需要调用的地方
    }

    //次要业务
    private void init() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kaikeba?serverTimezone=GMT%2B8","root","liucanlie");
        pStatement = connection.prepareStatement("select * from dept");
    }

    public void close() throws SQLException {
        if(pStatement != null){
            pStatement.close();
        }
        if(connection!= null){
            connection.close();
        }
    }
}
