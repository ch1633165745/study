import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import study.ch.Bean.Employee;
import study.ch.Dao.EmployeeDao;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author shkstart
 * @create 2021-02-18-23:31
 */
public class Test {
    SqlSessionFactory sqlSessionFactory;

    @Before//before标签程序执行前提前运行
    public void initSqlSessionFactory() throws IOException {
        //1、根据全局配置文件得到sqlSessionFactory
        String resource="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 增加测试（概念是线程，每次做一次操作拿一条SqlSession的线程）
     */
    @org.junit.Test
    public void Test04() throws Exception {
        //2、得到SqlSession对象openSession(true)，设置为自动提交
        SqlSession openSession = sqlSessionFactory.openSession();
        //3、创建该接口实现类
        EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
        //4、测试各个方法
        //增加
        try {
            int i = employeeDao.insertEmp(new Employee(null, "tomcat1", 1, "tomcat1@qq.com"));
            System.out.println(i);
        } finally {
            //增加需要手动提交
            openSession.commit();
            openSession.close();
        }
    }

    /**
     * 删除测试（概念是线程，每次做一次操作拿一条SqlSession的线程）
     */
    @org.junit.Test
    public void Test03() throws Exception {
        //2、得到SqlSession对象，openSession(true)，设置为自动提交
        SqlSession openSession = sqlSessionFactory.openSession(true);
        //3、创建该接口实现类
        EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
        //4、测试各个方法
        //删除
        try {
            boolean b = employeeDao.deleteEmp(5);
            System.out.println(b);
        } finally {
            openSession.close();
        }
    }

    /**
     * 修改测试（概念是线程，每次做一次操作拿一条SqlSession的线程）
     */
    @org.junit.Test
    public void Test02() throws Exception {
        //2、得到SqlSession对象，openSession(true)，设置为自动提交
        SqlSession openSession = sqlSessionFactory.openSession(true);
        //3、创建该接口实现类
        EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
        //4、测试各个方法
        //修改
        try {
            int i = employeeDao.updateEmp(new Employee(1, "tomcat", 0, "tomcat@qq.com"));
            System.out.println(i);
        } finally {
            openSession.close();
        }
    }

    /**
     * 查询测试（概念是线程，每次做一次操作拿一条SqlSession的线程）
     */
    @org.junit.Test
    public void Test01() throws Exception {
        //2、得到SqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();
        //3、创建该接口实现类
        EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
        //4、测试各个方法
        //查询
        try {
            Employee empById = employeeDao.getEmpById(1);
            System.out.println(empById);
        }finally {
            openSession.close();
        }
    }
}
