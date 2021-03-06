package work.ch.Dao;

import org.springframework.stereotype.Repository;
import work.ch.Pojo.Student;

import java.util.List;

/**
 * @author shkstart
 * @create 2021-03-04-9:14
 */

public interface studentDao {
    //获取所有学生
    public List<Student> getAllStu();
    //添加学生信息
    public void addStu(Student student);
}
