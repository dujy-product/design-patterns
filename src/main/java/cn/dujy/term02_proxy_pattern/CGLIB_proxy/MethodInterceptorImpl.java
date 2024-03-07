package cn.dujy.term02_proxy_pattern.CGLIB_proxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


@Slf4j
public class MethodInterceptorImpl implements MethodInterceptor {

    private Object targetObject;

    /**
     * 这里的目标类型为Object，则可以接受任意一种参数作为被代理类，实现了动态代理
     *
     * @param target 1
     */
    public MethodInterceptorImpl(Object target) {
        // 设置需要创建子类的类
        this.targetObject = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        log.warn("===> 开启事物");
        Object result = methodProxy.invoke(targetObject, args);
        log.warn("===> 关闭事物");
        // 返回代理对象
        return result;
    }
}
