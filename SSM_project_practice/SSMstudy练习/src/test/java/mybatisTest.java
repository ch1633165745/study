import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import work.ch.Pojo.Student;
import work.ch.Pojo.Subject;
import work.ch.Service.studentService;
import work.ch.Service.subjectService;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-03-04-9:55
 */
public class mybatisTest {

    ApplicationContext ioc=new ClassPathXmlApplicationContext("spring/Spring.xml");
    @Test
    public void Test1(){
        studentService studentService1 = ioc.getBean(studentService.class);
        List<Student> students = studentService1.getAllstu();
        Iterator<Student> iterator = students.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        subjectService subjectService = ioc.getBean(subjectService.class);
        List<Subject> subjects = subjectService.getAllSub();
        for (Subject sub:subjects){
            System.out.println(sub);
        }
    }
}
