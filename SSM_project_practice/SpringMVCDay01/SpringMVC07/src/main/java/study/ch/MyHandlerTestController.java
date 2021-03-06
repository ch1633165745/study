package study.ch;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 */
@Controller
public class MyHandlerTestController {
    @RequestMapping("/test01")
    public String test(){
        System.out.println("请求处理了。。。");
        return "success";
    }
}
