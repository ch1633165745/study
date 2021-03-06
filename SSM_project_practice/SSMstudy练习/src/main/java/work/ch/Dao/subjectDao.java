package work.ch.Dao;

import org.springframework.stereotype.Repository;
import work.ch.Pojo.Subject;

import java.util.List;

/**
 * @author shkstart
 * @create 2021-03-04-9:15
 */

public interface subjectDao {
    //获取所有课程
    public List<Subject> getAllSub();

    //添加课程
    public void addSub(Subject subject);
}
