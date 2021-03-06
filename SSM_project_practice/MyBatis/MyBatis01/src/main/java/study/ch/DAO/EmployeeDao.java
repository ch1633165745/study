package study.ch.DAO;

import study.ch.Bean.Employee;

/**
 * @author shkstart
 * @create 2021-02-17-22:25
 */
public interface EmployeeDao {
    //按id查询员工
    public Employee getEmployById(Integer id);
}
