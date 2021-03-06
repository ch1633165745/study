package work.ch.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.security.provider.Sun;
import work.ch.Pojo.Subject;
import work.ch.Service.subjectService;

import javax.validation.Valid;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-03-04-9:16
 */
@Controller
public class subjectController {
    @Autowired
    private subjectService subjectService;
    //查询所有课程
    @RequestMapping("/sub")
    public String getAllSub(Model model){
        List<Subject> allSub = subjectService.getAllSub();
        //传入model中将数据带到页面
        model.addAttribute("allSub",allSub);
        return "subject";
    }

    //添加课程之前要做的准备，给页面一个初始值的subject
    @RequestMapping("/toAddSub")
    public String toAddSub(Model model){
        model.addAttribute("subject",new Subject());
        return "/subjectAdd";
    }
    //添加课程
    @RequestMapping("/subjectAdd")
    public String addSub(@Valid Subject subject, BindingResult bindingResult){
        //如果有错误回到subjectAdd页面
        if (bindingResult.hasErrors()){
            return "subjectAdd";
        }else {
            //成功添加，在执行一次查询所有课程，并重定向到课程主页
            subjectService.addSub(subject);
            return "redirect:/sub";
        }
    }
}
