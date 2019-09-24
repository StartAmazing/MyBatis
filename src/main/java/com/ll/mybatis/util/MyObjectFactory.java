package com.ll.mybatis.util;

import com.ll.mybatis.entity.Dept;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

/**
 * 自定义对象工厂
 */
public class MyObjectFactory extends DefaultObjectFactory {
    @Override
    public Object create(Class type) {        //重新定义Dept类实例对象创建规则,其他类实例创建规则不变
        if(type == Dept.class){
            //依靠父类提供的create方法创建一个实例对象
            Dept dept = (Dept) super.create(type);
            //设置自定义规则
            dept.setCountry("China");
            return dept;
        }
        return super.create(type);
    }
}
