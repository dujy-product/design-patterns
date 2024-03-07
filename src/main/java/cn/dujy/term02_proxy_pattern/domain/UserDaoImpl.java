package cn.dujy.term02_proxy_pattern.domain;

import lombok.extern.slf4j.Slf4j;

/**
 * 接口的实现类
 */
@Slf4j
public class UserDaoImpl implements IUserDao {

    @Override
    public void save1() {
        log.info("用户——>保存数据方法1");
    }

    @Override
    public void save2() {
        log.info("用户——>保存数据方法2");
    }
}
