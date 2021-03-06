package study.ch.Controller;

import org.apache.taglibs.standard.lang.jstl.EmptyOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import study.ch.bean.Employee;
import study.ch.dao.EmployeeDao;

import java.util.Collection;

/**
 * @author shkstart
 * @create 2021-02-16-13:05
 */
@Controller
public class AjaxTestController {
    @Autowired
    EmployeeDao employeeDao;

    /**
     * 获取所有员工
     * @ResponseBody将返回的数据放在响应体中
     * 如果是对象，jackson包自动将对象转为json格式
     */
    @ResponseBody
    @RequestMapping("/getallajax")
    public Collection<Employee> ajaxGetAll(){
        Collection<Employee> all = employeeDao.getAll();
        return all;
    }
}
