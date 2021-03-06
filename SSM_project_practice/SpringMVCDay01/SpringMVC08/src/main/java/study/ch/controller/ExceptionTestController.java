package study.ch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author shkstart
 * @create 2021-02-17-12:21
 */
@Controller
public class ExceptionTestController {

    @RequestMapping("/handle01")
    public String handle01(Integer i){
        System.out.println("handle01被调用了");
        System.out.println(10/i);
        return "success";
    }







}
