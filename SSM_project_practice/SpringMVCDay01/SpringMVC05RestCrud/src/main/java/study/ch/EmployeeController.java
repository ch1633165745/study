package study.ch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import study.ch.bean.Department;
import study.ch.bean.Employee;
import study.ch.dao.DepartmentDao;
import study.ch.dao.EmployeeDao;

import javax.validation.Valid;
import java.util.Collection;

/**
 * @author shkstart
 * @create 2021-02-14-14:32
 */

public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    /**
     * 查询所有部门信息(去主页前要做的事，展现当前所有员工)：
     * employeeDao.getAll()查询所有员工信息
     * 利用参数model请求域空间用于转发到liet页面
     */
    @RequestMapping("/emps")
    public String getEmps(Model model){
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps",all);
        return "list";
    }

    /**
     * 去add页面要做的准备：
     * 1）查询现在所有部门，2）指明employee，让页面有个初始的Employee，防止报错
     * 用来处理员工添加页面:去之前需查询所有部门信息，进行展示
     */
    @RequestMapping("/toaddpage")
    public String toAddPage(Model model){

        //command也就是设置个默认值可都为空（必须要求否则会报错）
        model.addAttribute("employee",new Employee());//代替command
        return "add2";
    }
    /**
     * 添加功能：
     * 将添加数据封装成employee对象
     * 调用save方法，进行添加操作
     *处理emp发过来的请求，请求类型为post
     * 注意：返回时请求需要重定向到再做一次上面的页面查询
     */
    @RequestMapping(value = "/emp",method = RequestMethod.POST)
    public String toEmp(@Valid Employee employee, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            System.out.println("有校验错误");
            return "add2";
        }else {
            System.out.println("要添加的员工"+employee);
            employeeDao.save(employee);
            //请求重定向，再次做一次所有员工查询请求
            return "redirect:/emps";
        }
    }

    /**
     * 去求改页面要做的准备
     * 查询此次要求改的员工信息
     */
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.GET)
    public String getEmp(@PathVariable("id") Integer id,Model model){
        //查出员工信息
        Employee employee = employeeDao.get(id);
        //放在请求域中
        model.addAttribute("employee",employee);

        return "/edit";
    }
    /**
     *通过@RequestParam获取id，每次进入页面前先判断该页面是否有id，有id通过id获得employee，放入域空间中
     */
    @ModelAttribute//每次执行页面都会优先执行
    public void myModelAttribute(
            @RequestParam(value = "id",required = false) Integer id,Model model){
        if (id!=null) {
            Employee employee = employeeDao.get(id);
            model.addAttribute(employee);
        }
        /**
         * 每次运行都查一下部门信息，防止add中部门消息缺失
         */
        Collection<Department> departments = departmentDao.getDepartments();//查询所有部门
        model.addAttribute("deps",departments);//将部门信息带到页面（通过请求域）
        System.out.println("执行过myModelAttribute方法了");
    }
    /**
     * 修改功能
     * 使用@ModelAttribute每次进入页面判断是否有id通过id获得employee
     * 避免了页面返回null的问题
     * 注意：返回时请求需要重定向到再做一次上面的页面查询
     */
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.PUT)
    public String updateEmp(@ModelAttribute("employee") Employee employee){
        employeeDao.save(employee);//将修改过后的employee保存
        System.out.println(employee);//控制台打印一下employee，看看有没有属性为null
        return "redirect:/emps";//请求重定向，再做一次所有员工查询
    }
    /**
     * 删除员工
     */
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.DELETE)
    public String deletEmp(@ModelAttribute("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
