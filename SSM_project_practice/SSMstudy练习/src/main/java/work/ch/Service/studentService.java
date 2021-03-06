package work.ch.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.ch.Dao.studentDao;
import work.ch.Pojo.Student;

import java.util.List;

/**
 * @author shkstart
 * @create 2021-03-04-9:37
 */
@Service
public class studentService {

    @Autowired
    private studentDao studentDao;
    //查询所有学生信息
    public List<Student> getAllstu(){
       return studentDao.getAllStu();
    }
    //添加学生信息
    public void addStu(Student student){
        studentDao.addStu(student);
    }
}
