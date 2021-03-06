import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import study.ch.Bean.Employee;
import study.ch.DAO.EmployeeDao;

/**
 * @author shkstart
 * @create 2021-02-18-14:34
 */
public class myBatisTest {
    @Test
    public void Test01() throws Exception {
        //1、根据全局配置文件创建一个SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //SqlSessionFactory就是SqlSession的工厂，负责创建SqlSession对象
        //SqlSession：sql会话，代表和数据库的一次会话
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2、获取数据库的一次会话:相当于getConnection()那到数据库连接
        SqlSession openSession = sqlSessionFactory.openSession();
        Employee employee =null;
        try {
            //3、使用SqlSession操作数据库,获取dao接口的实现
            EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
            //调用dao方法传入参数
            employee = employeeDao.getEmployById(1);
            System.out.println(employee);
        }finally {
            openSession.close();
        }
    }
}
