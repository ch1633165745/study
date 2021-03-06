import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import study.ch.Bean.Teacher;
import study.ch.Dao.TeacherMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-03-01-18:31
 */
public class Test {
    SqlSessionFactory sqlSessionFactory;
    @Before//before标签程序执行前提前运行
    public void initSqlSessionFactory() throws IOException {
        //1、根据全局配置文件得到sqlSessionFactory
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    @org.junit.Test
    public void test02(){
        SqlSession openSession = sqlSessionFactory.openSession(true);
        TeacherMapper teacherMapper = openSession.getMapper(TeacherMapper.class);
        List<Teacher> teachers=new ArrayList<Teacher>();//创建一个集合
        for (int i=0;i<1000;i++){
            Teacher teacher = new Teacher();
            teacher.setTeachername("a");
            teacher.setClassName("b");
            teachers.add(teacher);//将每个teacher添加进集合
        }
        System.out.println("批量添加完成。。。");
        teacherMapper.insertBatch(teachers);
        openSession.close();
    }
    @org.junit.Test
    public void test01() throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("mbg.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        //代码生成
        myBatisGenerator.generate(null);
    }
}
