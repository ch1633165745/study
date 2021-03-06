package study.ch.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.ch.Bean.Teacher;
import study.ch.Dao.TeacherDao;

/**
 * @author shkstart
 * @create 2021-02-28-21:08
 */
@Service
public class TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    public Teacher getTeacher(Integer id){
        return teacherDao.getTeacherById(id);
    }
}
