package cn.dujy.term02_proxy_pattern.domain;

import lombok.extern.slf4j.Slf4j;

/**
 * jdk动态代理：必须接口
 */
@Slf4j
public class NodeDao {
    public void save1() {
        log.info("机构——>保存数据方法1");
    }

    public void save2() {
        log.info("机构——>保存数据方法2");
    }
}
