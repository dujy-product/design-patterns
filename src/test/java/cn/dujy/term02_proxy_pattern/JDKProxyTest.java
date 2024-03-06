package cn.dujy.term02_proxy_pattern;

import cn.dujy.term02_proxy_pattern.JDK_proxy.InvocationHandlerImpl;
import cn.dujy.term02_proxy_pattern.JDK_proxy.UserDao;
import cn.dujy.term02_proxy_pattern.JDK_proxy.UserDaoImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Proxy;

@Slf4j
@SpringBootTest
public class JDKProxyTest {

    @Test
    public void JDKProxy() {

        // 被代理对象
        UserDao userDaoImpl = new UserDaoImpl();
        InvocationHandlerImpl invocationHandlerImpl = new InvocationHandlerImpl(userDaoImpl);

        //类加载器
        ClassLoader loader = userDaoImpl.getClass().getClassLoader();
        // 获取接口
        Class<?>[] interfaces = userDaoImpl.getClass().getInterfaces();

        // 主要装载器、一组接口及调用处理动态代理实例
        UserDao newProxyInstance = (UserDao) Proxy.newProxyInstance(loader, interfaces, invocationHandlerImpl);

        // 调用时才指定调用哪个方法
        newProxyInstance.save1();
        newProxyInstance.save2();

    }

}
