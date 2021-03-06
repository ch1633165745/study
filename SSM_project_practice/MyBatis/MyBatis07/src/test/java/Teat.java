import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.event.annotation.AfterTestClass;
import study.ch.Bean.Teacher;
import study.ch.Dao.TeacherDao;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author shkstart
 * @create 2021-02-27-12:34
 */
public class Teat {
    SqlSessionFactory sqlSessionFactory;

    @Before//before标签程序执行前提前运行
    public void initSqlSessionFactory() throws IOException {
        //1、根据全局配置文件得到sqlSessionFactory
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 开启二级缓存后
     */
    @Test
    public void Test3(){
        SqlSession openSession1 = sqlSessionFactory.openSession(true);
        TeacherDao teacherDao1 = openSession1.getMapper(TeacherDao.class);
        Teacher teacher1= teacherDao1.getTeacherById(1);
        System.out.println(teacher1);
        openSession1.close();

        SqlSession openSession2 = sqlSessionFactory.openSession(true);
        TeacherDao teacherDao2 = openSession2.getMapper(TeacherDao.class);
        Teacher teacher2= teacherDao2.getTeacherById(1);
        System.out.println(teacher2);
        openSession2.close();
    }

    /**
     * mybatis一级缓存失效的几种情况
     *      一级缓存是sqlSession级别的缓存（每次根数据库一次会话，就开启一个sqlSession）
     *      1）不同的sqlSession使用不同的一级缓存，只有在同一个会话中的数据，保存在这个会话的一级缓存中，下次查询会从这个缓存中拿
     *      2）同一个方法不同的参数，由于之前未查过，所以还会发新的sql
     *      3）在这个sqlSession期间执行上任何一次增删改操作（增删改操作会把缓存清空）
     *      4）openSession.clearCache()手动清空缓存当前sqlSession的一级缓存
     * 每次查询先看一级缓存中有没有，如没有再去发送新的sql给数据库，每个sqlSession拥有自己的一级缓存
     */
    @Test
    public void Test2(){
        //第一次会话
        SqlSession openSession1 = sqlSessionFactory.openSession(true);
        TeacherDao teacherDao1 = openSession1.getMapper(TeacherDao.class);
        Teacher teacher1 = teacherDao1.getTeacherById(1);
        System.out.println(teacher1);
        System.out.println("================================");
        //3)在再次查询之间（同一个sqlSession中）执行一个任意的增删改操作
        //Teacher teacher = new Teacher();
        //teacher.setId(2);//修改一个无关的数据
        //teacher.setName("刘老师");
        //int i = teacherDao1.updateTeacher(teacher);

        //4)手动执行清空当前sqlSession的一级缓存操作
        //System.out.println("手动清空当前会话的一级缓存");
        //openSession1.clearCache();

        System.out.println("================================");
        Teacher teacher2 = teacherDao1.getTeacherById(1);
        System.out.println(teacher2);

        //2)同一个方法不同的参数
        //Teacher teacher2 = teacherDao1.getTeacherById(2);
        //System.out.println(teacher2);

        //1)第二次会话
        //SqlSession openSession2 = sqlSessionFactory.openSession(true);
        //TeacherDao teacherDao2 = openSession2.getMapper(TeacherDao.class);
        //Teacher teacher2 = teacherDao2.getTeacherById(1);
        //System.out.println(teacher2);

        openSession1.close();
        //openSession2.close();

    }
    @Test//mybatis一级缓存
    public void Txest1(){
        SqlSession openSession = sqlSessionFactory.openSession(true);
        try {
            TeacherDao teacherDao = openSession.getMapper(TeacherDao.class);
            Teacher teacher1 = teacherDao.getTeacherById(1);
            System.out.println(teacher1);
            System.out.println("================");
            Teacher teacher2 = teacherDao.getTeacherById(1);
            System.out.println(teacher2);
            System.out.println(teacher2==teacher1);
        }finally {
            openSession.close();
        }
    }
}
