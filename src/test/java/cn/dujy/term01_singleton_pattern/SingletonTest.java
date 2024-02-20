package cn.dujy.term01_singleton_pattern;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class SingletonTest {

    /**
     * 懒汉 和 饿汉
     */
    @Test
    public void singleton() {
        // 饿汉
        EHanSingleton eHanSingleton = EHanSingleton.getInstance();
        EHanSingleton eHanSingleton2 = EHanSingleton.getInstance();
        log.info("饿汉模式：{}", eHanSingleton.equals(eHanSingleton2));

        // 饿汉
        LanHanSingleton lHanSingleton = LanHanSingleton.getInstance();
        LanHanSingleton lHanSingleton2 = LanHanSingleton.getInstance();
        System.out.println("懒汉模式：{}" + lHanSingleton.equals(lHanSingleton2));
    }

}