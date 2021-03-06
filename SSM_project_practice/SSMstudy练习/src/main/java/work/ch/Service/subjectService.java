package work.ch.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.ch.Dao.subjectDao;
import work.ch.Pojo.Subject;

import java.util.List;

/**
 * @author shkstart
 * @create 2021-03-04-9:37
 */
@Service
public class subjectService {
    @Autowired
    private subjectDao subjectDao;
    //查询所有课程
    public List<Subject> getAllSub(){
       return subjectDao.getAllSub();
    }
    //添加课程
    public void addSub(Subject subject){
        subjectDao.addSub(subject);
    }
}
