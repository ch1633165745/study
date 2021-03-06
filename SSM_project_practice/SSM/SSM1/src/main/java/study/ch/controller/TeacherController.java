package study.ch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import study.ch.Bean.Teacher;
import study.ch.Service.TeacherService;

/**
 * @author shkstart
 * @create 2021-03-01-10:38
 */
@Controller
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @RequestMapping("getTeacher")
    public String getTeacher(@RequestParam(value="id",defaultValue="1") Integer id, Model model){
        Teacher teacher = teacherService.getTeacher(id);
        model.addAttribute("teacher",teacher);
        return "success";
    }
}
