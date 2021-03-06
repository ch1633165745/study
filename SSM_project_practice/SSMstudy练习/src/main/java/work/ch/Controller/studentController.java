package work.ch.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import work.ch.Pojo.Student;
import work.ch.Pojo.Subject;
import work.ch.Service.studentService;
import work.ch.Service.subjectService;

import javax.validation.Valid;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-03-04-9:15
 */
@Controller
public class studentController {
    @Autowired
    private studentService studentService;
    //查询所有学生信息
    @RequestMapping("/stu")
    public String getAllStu(Model model){
        List<Student> allStu = studentService.getAllstu();
        //传入model中将数据带到页面
        model.addAttribute("allStu",allStu);
        return "student";
    }
    //去添加页面之前的准备，给页面一个初始值的student
    @RequestMapping("/toAddStu")
    public String toAddStu(Model model){
        model.addAttribute("student",new Student());
        return "studentAdd";
    }
    //添加学生信息
    @RequestMapping("/stuAdd")
    public String  addStu(@Valid Student student, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            System.out.println("有校验错误");
            return "studentAdd";
        }else {
            System.out.println("要添加的员工信息为"+student);
            studentService.addStu(student);
            //请求重定向，再发送一次/stu的请求，执行相应的controller方法
            return "redirect:/stu";
        }
    }
}
