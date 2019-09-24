package com.ll.mybatis.service.util;

import com.ll.mybatis.service.BaseService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//代理具体的实现类，继承InvocationHandler接口
public class Invaction implements InvocationHandler {

    private BaseService obj; //具体被监控的对象

    public Invaction(BaseService baseService){
        this.obj = baseService;
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

        //0、声明一个局部变量，接受主要业务方法执行完毕后的返回值
        Object value;
        //1、确认当前被拦截的行为是吃饭还是上厕所
        String methodName = method.getName();
        //2、根据被拦截的行为不同，决定主要业务和次要业务如何绑定执行
        if("eat".equals(methodName)){       //饭前要洗手
            wash();     //洗手
            value = method.invoke(this.obj, args);//吃饭
        }else {         //便后要洗手
            value = method.invoke(this.obj,args);
            wash();
        }
        return value;       //返回被拦截的方法，需要调用的地方
    }

    //次要业务
    public void wash(){
        System.out.println("祈祷 -- -- -- -- .");
    }
}
