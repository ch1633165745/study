package study.ch;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import study.ch.Bean.Employee;
import study.ch.Dao.EmployeeDao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shkstart
 * @create 2021-02-20-15:50
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
    /**
     * 增加测试（概念是线程，每次做一次操作拿一条SqlSession的线程）
     */
    @Test//增加
    public void Test04() throws Exception {
        //2、得到SqlSession对象openSession(true)，设置为自动提交
        SqlSession openSession = sqlSessionFactory.openSession();
        //3、创建该接口实现类
        EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
        //4、测试各个方法
        //增加的employee参数，因为id为自增赋值为null
        Employee employee = new Employee(null, "tomcat1", 1, "tomcat1@qq.com");
        //增加
        try {
            int i = employeeDao.insertEmp(employee);
            System.out.println(i);
            System.out.println("自增插入的id值为"+employee.getId());//获取自增的id值
        } finally {
            //增加需要手动提交
            openSession.commit();
            openSession.close();
        }
    }
    @Test//查询
    public void test01(){
        //拿到一条数据库连接，设置自动提交（true）
        SqlSession openSession = sqlSessionFactory.openSession(true);
        try {
            //获取EmployeeDao的映射器，传入EmployeeDao.class，创建出一个代理对象
            EmployeeDao empDao = openSession.getMapper(EmployeeDao.class);
            //调用代理对象的方法
            Employee emp = empDao.getEmpById(1);
            System.out.println(emp);
        }finally {
            openSession.close();
        }
    }
    @Test//查询多个参数使用map
    public void test02(){
        //拿到一条数据库连接，设置自动提交（true）
        SqlSession openSession = sqlSessionFactory.openSession(true);
        try {
            //获取EmployeeDao的映射器，传入EmployeeDao.class，创建出一个代理对象
            EmployeeDao empDao = openSession.getMapper(EmployeeDao.class);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id",1);
            map.put("name","tomcat");
            //调用代理对象的方法
            Employee emp = empDao.getEmpByIdAndName(map);
            System.out.println(emp);
        }finally {
            openSession.close();
        }
    }
    @Test//查询所有
    public void test03(){
        //拿到一条数据库连接，设置自动提交（true）
        SqlSession openSession = sqlSessionFactory.openSession(true);
        try {
            //获取EmployeeDao的映射器，传入EmployeeDao.class，创建出一个代理对象
            EmployeeDao empDao = openSession.getMapper(EmployeeDao.class);
            //调用代理对象的方法
            List<Employee> empAll = empDao.getAll();
            System.out.println(empAll);
        }finally {
            openSession.close();
        }
    }
}
