package study.ch.Dao;

import org.apache.ibatis.annotations.Param;
import study.ch.Bean.Employee;

import java.util.List;
import java.util.Map;

/**
 * @author shkstart
 * @create 2021-02-20-15:39
 */

public interface EmployeeDao {
    //通过id查询
    public Employee getEmpById(Integer id);
    //通过employee的属性修改
    public int updateEmp(Employee employee);
    //通过id删除
    public boolean deleteEmp(Integer id);
    //通过employee的属性插入
    public int insertEmp(Employee employee);

    //返回多条数据，也就是返回list集合,查询所有
    public List<Employee> getAll();
}
