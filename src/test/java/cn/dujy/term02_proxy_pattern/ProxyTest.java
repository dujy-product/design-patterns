package cn.dujy.term02_proxy_pattern;

import cn.dujy.term02_proxy_pattern.JDK_proxy.InvocationHandlerImpl;
import cn.dujy.term02_proxy_pattern.CGLIB_proxy.MethodInterceptorImpl;
import cn.dujy.term02_proxy_pattern.domain.IUserDao;
import cn.dujy.term02_proxy_pattern.domain.NodeDao;
import cn.dujy.term02_proxy_pattern.domain.UserDaoImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

@Slf4j
@SpringBootTest
public class ProxyTest {

    /**
     * 缺点：必须是面向接口，目标业务类必须实现接口 <br/>
     * 优点：不用关心代理类，只需要在运行阶段才指定代理哪一个对象
     * <p>
     * 关键： <br/>
     * 1、实现 InvocationHandler 接口<br/>
     * 2、使用 Proxy.newProxyInstanc() 创建代理对象<br/>
     */
    @Test
    public void JDKProxy() {
        // 1、被代理对象（实现类）
        IUserDao IUserDaoImpl = new UserDaoImpl();

        // 2、获取：代理类的类加载器、被代理对象的接口、代理程序
        // 类加载器 —— 获取被代理对象的类加载器
        ClassLoader loader = IUserDaoImpl.getClass().getClassLoader();
        // 接口 —— 获取被代理对象的接口
        Class<?>[] interfaces = IUserDaoImpl.getClass().getInterfaces();
        // 代理程序 —— 被代理对象的调用处理程序
        InvocationHandlerImpl invocationHandlerImpl = new InvocationHandlerImpl(IUserDaoImpl);

        // 3、创建代理的对象
        IUserDao userDaoImplProxy = (IUserDao) Proxy.newProxyInstance(loader, interfaces, invocationHandlerImpl);

        // 4、调用时才指定调用哪个方法
        userDaoImplProxy.save1();
        userDaoImplProxy.save2();
    }

    /**
     * 优点：可以代理非接口对象 <br/>
     * <p>
     * 关键：<br/>
     * 1、实现 MethodInterceptor 接口<br/>
     * 2、使用 Enhancer.create() 创建代理对象
     */
    @Test
    public void CGLIBProxy() {
        // 1、被代理对象（普通类）
        NodeDao nodeDao = new NodeDao();

        // 2、获取：代理类的类class、代理程序
        // 获取【代理对象nodeDao】
        Class<? extends NodeDao> nodeDaoClass = nodeDao.getClass();
        // 代理程序 —— 被代理对象的调用处理程序
        MethodInterceptorImpl methodInterceptorImpl = new MethodInterceptorImpl(nodeDao);

        // 3、创建代理对象
        NodeDao nodeDaoProxy = (NodeDao) Enhancer.create(nodeDaoClass,methodInterceptorImpl);

        // 4、调用代理对象的方法
        nodeDaoProxy.save1();
        nodeDaoProxy.save2();
    }

}
