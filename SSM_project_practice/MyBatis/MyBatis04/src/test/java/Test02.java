import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import study.ch.Bean.Cat;
import study.ch.Dao.CatDao;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author shkstart
 * @create 2021-02-21-20:07
 */
public class Test02 {
    SqlSessionFactory sqlSessionFactory;

    @Before//before标签程序执行前提前运行
    public void initSqlSessionFactory() throws IOException {
        //1、根据全局配置文件得到sqlSessionFactory
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test01(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        /**
         * mybatis中自动封装结果集
         * 1）按照sql中列名和java类属性名一一对应（不区分大小写）
         * 2）如果不一一对应
         *      a）开启了驼峰命名规则（aaa_bbb---->aaaBbb）
         *      b)在sql语句中（CatDao.xml中）起别名使用resultMap标签
         */
        try {
            CatDao catDao = sqlSession.getMapper(CatDao.class);
            Cat catById = catDao.getCatById(1);
            System.out.println(catById);
        }finally {
            sqlSession.close();
        }
    }
}
