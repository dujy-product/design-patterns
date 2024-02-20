package cn.dujy.term01_singleton_pattern;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 实例在需要用到的时候，才去创建
 *  优点：节省空间和代码
 *  缺点：存在线性安全问题，需要synchronized关键字
 */
@Data
@EqualsAndHashCode
public class LanHanSingleton {

    // 1、（私有的）无参构造
    private LanHanSingleton() {
    }

    // 2、懒汉
    private static LanHanSingleton instance;


    // 3、单例方法
    public static LanHanSingleton getInstance() {
        // 调用时才创建
        if (instance == null) {
            instance = new LanHanSingleton();
        }
        return instance;
    }
}
