package study.ch.Dao;

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
    //当查询需要多个参数时,通过@Param（值）注解，指定在写sql语句中的#{值}，如果没有@Param注解，则使用#{0}或#{param1}（不推荐）
    //使用map（推荐）
    public Employee getEmpByIdAndName(Map<String, Object> map);
    //返回多条数据，也就是返回list集合,查询所有
    public List<Employee> getAll();
}
