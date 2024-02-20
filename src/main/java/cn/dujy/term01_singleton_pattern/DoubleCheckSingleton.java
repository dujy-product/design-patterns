package cn.dujy.term01_singleton_pattern;

import lombok.Data;

/**
 * 双重校验锁实现的单例模式：基于懒汉模式 使用 【双重判断】和 【synchronized上锁】
 * 优点：保证了线程安全，又比直接上锁提高了执行效率，还节省了内存空间
 * 缺点：复杂
 */
@Data
public class DoubleCheckSingleton {


    // 1、私有构造器
    private DoubleCheckSingleton() {
    }

    // 2、懒汉
    private volatile static DoubleCheckSingleton instance = null;

    // 3、获取 单例的方法，与懒汉的区别就是 加上了 synchronized
    public static DoubleCheckSingleton getInstance() {
       if (instance == null){
           synchronized(DoubleCheckSingleton.class){
               if (instance == null){
                   instance = new DoubleCheckSingleton();
               }
           }
       }
       return instance;
    }

}
