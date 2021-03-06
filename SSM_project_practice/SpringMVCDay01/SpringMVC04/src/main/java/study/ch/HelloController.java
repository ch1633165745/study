package study.ch;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author shkstart
 * @create 2021-02-12-18:24
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello方法被调用了。。。");
        return "success";
    }
}
