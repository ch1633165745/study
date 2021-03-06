package study.ch.Dao;

import study.ch.Bean.Key;

/**
 * 1对1的关系
 */
public interface KeyDao {
    //将key和lock一起查出来
    public Key getKeyById(int id);

    //查key的简单方法
    public Key getKeyByIdEasy(int id);


}
