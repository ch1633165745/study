package study.ch;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author shkstart
 * @create 2021-02-10-17:16
 */
@Controller
public class MyFirstContorller {

    @RequestMapping("/hello")
    public String requestMapping(){
        System.out.println("请求收到了，并已经处理");
        return "success";
    }
}
