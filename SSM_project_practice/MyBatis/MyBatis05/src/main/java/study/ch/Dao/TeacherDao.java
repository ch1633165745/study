package study.ch.Dao;

import study.ch.Bean.Teacher;

/**
 * @author shkstart
 * @create 2021-02-24-15:32
 */
public interface TeacherDao {
    //通过id获取老师对象（mybatis会自动封装）
    public Teacher getTById(Integer id);

}
