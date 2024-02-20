package cn.dujy.term01_singleton_pattern;


/**
 * 枚举实现的单例：
 * 优点：代码简洁清晰。并且它还自动支持序列化机制，绝对防止多次实例化。
 * 缺点：不适合大多数场合
 */
public enum SingletonEnum {

    // 枚举
    INSTANCE;

    // 公共的实例方法
    public SingletonEnum getInstance() {
        return INSTANCE;
    }
}
