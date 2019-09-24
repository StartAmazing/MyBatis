package com.ll.mybatis.service.util;

import com.ll.mybatis.service.BaseService;
import com.ll.mybatis.service.serviceImpl.Dog;
import com.ll.mybatis.service.serviceImpl.Person;

public class TestMain {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        //Mike.eat()
        //Person mike = new Person();

        BaseService mike = ProxyFactory.build(Person.class);
        mike.eat();     //专门负责监控mike的代理对象

        BaseService dog = ProxyFactory.build(Dog.class);
        dog.eat();

    }
}
