import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import study.ch.Bean.Student;
import study.ch.Bean.Teacher;
import study.ch.Dao.StudentDao;
import study.ch.Dao.TeacherDao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-02-24-16:57
 */
public class Test01 {
    SqlSessionFactory sqlSessionFactory;

    @Before//before标签程序执行前提前运行
    public void initSqlSessionFactory() throws IOException {
        //1、根据全局配置文件得到sqlSessionFactory
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test
    public void test1(){
        SqlSession openSession = sqlSessionFactory.openSession(true);
        try {
            StudentDao studentDao = openSession.getMapper(StudentDao.class);
            Student sById = studentDao.getSById(3);
            System.out.println(sById);
        }finally {
            openSession.close();
        }
    }
}
