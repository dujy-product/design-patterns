package cn.dujy.term02_proxy_pattern.JDK_proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理类的调用处理器
 * 每次生成动态代理类对象时,实现了InvocationHandler接口的调用处理器对象
 */
@Slf4j
public class InvocationHandlerImpl implements InvocationHandler {

    // 1、缓存被代理的对象，用于调用被代理对象的方法
    private Object target;

    // 2、有参构造
    public InvocationHandlerImpl(Object target) {
        this.target = target;
    }

    // 3、代理对象调用被代理对象的方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.warn("===> 开启事物");
        //下面invoke()方法是以反射的方式来创建对象，第一个参数是要创建的对象，第二个是构成方法的参数，由第二个参数来决定创建对象使用哪个构造方法
        Object result = method.invoke(target, args);
        log.warn("===> 关闭事物");
        return result;
    }
}
