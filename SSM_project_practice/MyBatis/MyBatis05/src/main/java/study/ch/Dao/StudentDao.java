package study.ch.Dao;

import study.ch.Bean.Student;

/**
 * @author shkstart
 * @create 2021-02-24-15:33
 */
public interface StudentDao {
    //通过id获取学生对象（mybatis会自动封装）
    public Student getSById(int i);
}
