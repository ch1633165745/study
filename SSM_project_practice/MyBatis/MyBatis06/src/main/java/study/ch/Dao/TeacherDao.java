package study.ch.Dao;

import org.apache.ibatis.annotations.Param;
import study.ch.Bean.Teacher;

import java.util.List;

/**
 * @author shkstart
 * @create 2021-02-24-21:19
 */
public interface TeacherDao {
    //根据id查老师
    public Teacher getTeacherById(Integer id);
    //根据传入的属性来查询，自动拼接（if标签判断后面是否还有属性，使用where标签或trim标签）
    public List<Teacher> getTeacherByCondition(Teacher teacher);
    //传入一个id集合，查出在这个集合中的所有数据（使用foreach标签），List不能直接调用@Param为元素起个名
    public List<Teacher> getTeacherByIdIn(@Param("ids") List<Integer> ids);
    //判断传入的数据，执行相应的筛选条件（choose标签）
    public List<Teacher> getTeacherByConditionChoose(Teacher teacher);
    //set标签实现修改
    public int updateTeacher(Teacher teacher);
}
