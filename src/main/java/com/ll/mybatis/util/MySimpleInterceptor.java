package com.ll.mybatis.util;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;
@Intercepts({
        @Signature(method = "query", type = Executor.class, args = {
                MappedStatement.class,Object.class, RowBounds.class, ResultHandler.class
        })
})
public class MySimpleInterceptor implements Interceptor {
    /**
     *
     * @param invocation {代理对象，被监控的方法对象，当前被监控的方法在运行时需要的实参}
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        System.out.println("被拦截方法执行之前，做的辅助服务");
        Object proceed = invocation.proceed();
        System.out.println("被拦截方法执行之后，做的辅助服务");
        return proceed;
    }

    /**
     * @param target 表示被拦截的对象，应该是Executor接口实例对象
     * 作用：
     *            如果被拦截的对象所在的类有实现接口，那么就为当前
     *            拦截对象生成一个代理对象【$Proxy】
     *
     *            如果被拦截对象所在的类没有指定的接口
     *            这个对象之后行为就不会被代理操作
     * @return
     */
    @Override
    public Object plugin(Object target) {

        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
