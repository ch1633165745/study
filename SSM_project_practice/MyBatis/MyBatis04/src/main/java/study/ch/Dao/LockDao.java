package study.ch.Dao;

import study.ch.Bean.Lock;

/**
 * 多对一的关系
 */
public interface LockDao {
    //查询锁的时候将所有钥匙查出来
    public Lock getLockById(Integer id);

    //查lock的简单方法
    public Lock getLockByIdEasy(Integer id);
}
