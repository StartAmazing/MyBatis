package com.ll.mybatis.service.util;

import com.ll.mybatis.service.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class SqlSessionProxyFactory {

    /**
     * JDK动态代理模式下，代理对象的数据类型应该由它所监控的
     * 行为来描述
     * 参数：Class文件，监控类
     */
    public static SqlSession build(Class classFile) throws IllegalAccessException, InstantiationException {
        //1. 创建一个被监控的实例对象
        SqlSession obj = (SqlSession) classFile.newInstance();
        //2. 创建一个通知对象
        InvocationHandler adviser = new Invocation(obj);
        //3. 向JVM申请负责去监obj对象中指定行为的监控对象（代理对象）
        /**
         *  loader: 被监控对象隶属的类文件在内存中真实地址
         *  interfaces: 被监控的对象隶属的类文件实现的接口
         *  h: 监控对象发现当前对象小明要执行被监控行为，应该有哪一个对象进行辅助
         */
        SqlSession $proxy = (SqlSession) Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), adviser);
        return $proxy;
    }
}
