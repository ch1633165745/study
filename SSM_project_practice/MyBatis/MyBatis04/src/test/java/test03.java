import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import study.ch.Bean.Key;
import study.ch.Bean.Lock;
import study.ch.Dao.KeyDao;
import study.ch.Dao.LockDao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 联合查询测试
 */
public class test03 {
    SqlSessionFactory sqlSessionFactory;

    @Before//before标签程序执行前提前运行
    public void initSqlSessionFactory() throws IOException {
        //1、根据全局配置文件得到sqlSessionFactory
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    /**
     * 创建keydao.xml和lockdao.xml文件，都做简单的查询所有操作
     * 在keydao.xml中配置自定义结果集，并用<association>标签中的
     * select属性告诉mybatis这个列（外键）的值是从哪引来的
     * column属性指定key中的哪一列
     */
    @Test
    public void Test03(){
        SqlSession openSession = sqlSessionFactory.openSession(true);
        try {
            //传入接口，创建一个动态代理对象
            KeyDao keyDao = openSession.getMapper(KeyDao.class);
            Key keyByIdEasy = keyDao.getKeyByIdEasy(3);
            System.out.println(keyByIdEasy);
            Lock lock = keyByIdEasy.getLock();
            System.out.println(lock);
            //分布查询存在的弊端,如果只查一个元素，但是每次都会执行两个sql语句，影响性能
            System.out.println(keyByIdEasy.getKeyName());
            //按需加载，需要的时候再去查询，只需要开启按需加载策略
            //延迟加载，不着急加载（查询对象）

        }finally {
            openSession.close();
        }
    }
    @Test//执行lockdao中的方法(一对多)
    public void test02(){
        SqlSession openSession = sqlSessionFactory.openSession(true);
        try {
            //传入接口，创建一个动态代理对象
            LockDao lockDao = openSession.getMapper(LockDao.class);
            Lock lockById = lockDao.getLockById(3);
            System.out.println(lockById);
            List<Key> keys = lockById.getKeys();
            for (Key key:keys){
                System.out.println(key);
            }
        }finally {
            openSession.close();
        }
    }
    @Test//执行keydao中的方法（一对一）
    public void test01(){
        SqlSession openSession = sqlSessionFactory.openSession(true);
        try {
            //传入接口，创建一个动态代理对象
            KeyDao keyDao = openSession.getMapper(KeyDao.class);
            Key keyById = keyDao.getKeyById(1);
            System.out.println(keyById);
        }finally {
            openSession.close();
        }
    }
}
