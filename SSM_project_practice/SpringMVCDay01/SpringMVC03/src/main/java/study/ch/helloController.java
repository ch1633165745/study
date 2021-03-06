package study.ch;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.management.Agent;

/**
 * 获取请求带来的各种信息
 */
@Controller
public class helloController {
    //通过默认方法是获取请求参数，
    //直接给方法入参上写一个和参数相同的额变量，这个变量就是来接收请求参数的值
    //带：有值，没带：null
    @RequestMapping("/hello01")
    public String helloController1(String username){
        System.out.println("hello01中这个变量的值为"+username);
        return "success";
    }
    //参数1：通过@RequestParam方法是获取请求参数，参数默认是必须带的
    //在@RequestParam中指明要获取的参数名,变量名可不同
    //@RequestParam中三个参数：value指定要获取参数的key、
    //                        required表示这个参数是否必须的、
    //                         defaultValue指定一个默认值
    //补：与@PathVariable()区别：@PathVariable()是获取路径上占位符的值
    //参数2：@RequestHeader("User-Agent")获取请求头浏览器信息，用法和其参数与上方一样
    //参数3：@CookieValue("JSESSIONID")获取cookie的JSESSIONID的值，用法和其参数与上方一样
    @RequestMapping("/hello02")
    public String helloController2(@RequestParam("username") String name,
                                   @RequestHeader("User-Agent") String user_Agent,
                                   @CookieValue("JSESSIONID") String jsd
                                    ){
        System.out.println("hello02中这个变量的值为"+name);
        System.out.println("hello02中这个浏览器信息值为"+user_Agent);
        System.out.println("hello02中这个cookie的值为"+jsd);
        return "success";
    }
}
