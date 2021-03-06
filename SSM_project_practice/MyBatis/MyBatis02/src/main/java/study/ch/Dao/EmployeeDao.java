package study.ch.Dao;

import org.apache.ibatis.annotations.Param;
import study.ch.Bean.Employee;

import java.util.List;

/**
 * @author shkstart
 * @create 2021-02-18-22:55
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
    //当查询需要多个参数时,通过@Param（值）注解，指定在写sql语句中的#{值}，如果没有@Param注解，则使用#{0}或#{param1}，见Mybatis03模块
    public Employee getEmpByIdAndName(@Param("id") Integer id, @Param("name") String name);
    //返回多条数据，也就是返回list集合,查询所有，见Mybatis03模块
    public List<Employee> getAll();
}
