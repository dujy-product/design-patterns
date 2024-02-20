package cn.dujy.term01_singleton_pattern;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 实例在初始化的时候就已经建好了<br/>
 * 优点：没有线程安全的问题<br/>
 * 缺点：浪费内存空间<br/>
 */
@Data
@EqualsAndHashCode
public class EHanSingleton {

    // 1、私有的构造方法
    private EHanSingleton() {
    }

    // 2、私有的实例
    private static EHanSingleton instance = new EHanSingleton();

    // 3、获取实例的方法
    public static EHanSingleton getInstance() {
        return instance;
    }
}
