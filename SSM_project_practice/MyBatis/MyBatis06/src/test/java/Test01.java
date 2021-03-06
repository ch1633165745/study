import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;
import study.ch.Bean.Teacher;
import study.ch.Dao.TeacherDao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-02-24-21:37
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
    public void test5(){
        SqlSession openSession = sqlSessionFactory.openSession(true);
        try {
            TeacherDao teacherDao = openSession.getMapper(TeacherDao.class);
            Teacher teacher = new Teacher();
            teacher.setId(1);
            teacher.setName("hahaha");
            int i = teacherDao.updateTeacher(teacher);
            System.out.println(i);
        }finally {
            openSession.close();
        }
    }
    @Test//使用choose标签实现if..else效果,实现有id根据id查，有id和name根据id查，无id有name根据name查，都没有执行1=1查出所有
    public void test4(){
        SqlSession openSession = sqlSessionFactory.openSession(true);
        try{
            TeacherDao teacherDao = openSession.getMapper(TeacherDao.class);
            Teacher teacher = new Teacher();
           // teacher.setId(1);
            //teacher.setName("jack");
            List<Teacher> teacherByConditionChoose = teacherDao.getTeacherByConditionChoose(teacher);
            System.out.println(teacherByConditionChoose);
        }finally {
            openSession.close();
        }
    }
    @Test//判断满足集合中的条件，使用foreach标签
    public void teat3(){
        SqlSession openSession = sqlSessionFactory.openSession(true);
        try {
            TeacherDao teacherDao = openSession.getMapper(TeacherDao.class);
            List<Integer> list = new ArrayList<Integer>();
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            List<Teacher> teachers = teacherDao.getTeacherByIdIn(list);
            for (Teacher teacher:teachers) {
                System.out.println(teacher);
            }
        }finally {
            openSession.close();
        }
    }
    @Test//传入多个筛选条件，使用if标签和trim标签或where标签
    public void test2(){
        SqlSession openSession = sqlSessionFactory.openSession();
        try{
            TeacherDao teacherDao = openSession.getMapper(TeacherDao.class);
            Teacher teacher = new Teacher();
            teacher.setId(1);
            teacher.setName("%a%");//模糊查询，带a的字符
            //teacher.setBirth(new Date());
            List<Teacher> teachers = teacherDao.getTeacherByCondition(teacher);
            System.out.println(teachers);
        }finally {
            openSession.close();
        }
    }
    @Test//根据id查
    public void test1(){
        SqlSession openSession = sqlSessionFactory.openSession(true);
        try {
            TeacherDao teacherDao = openSession.getMapper(TeacherDao.class);
            Teacher teacher = teacherDao.getTeacherById(1);
            System.out.println(teacher);
        }finally {
            openSession.close();
        }
    }
}
