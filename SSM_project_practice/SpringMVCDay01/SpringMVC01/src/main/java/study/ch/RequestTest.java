package study.ch;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * URL地址可以写模糊的通配符
 * ？：能代替任意一个字符
 * *：能代替任意多个字符，和一层路径
 * **：能代替多层路径
 */
@Controller
public class RequestTest {

    @RequestMapping("/antTest01")
    public String AntTest01(){
        System.out.println("AntTest01被调用了。。。");
        return "success";
    }
    @RequestMapping("/antTest0?")//以antTest0开头的，只有一个字符
    public String AntTest02(){
        System.out.println("AntTest02被调用了。。。");
        return "success";
    }
    @RequestMapping("/antTest0*")//以antTest0开头的，可任意多个字符
    public String AntTest03(){
        System.out.println("AntTest03被调用了。。。");
        return "success";
    }
    @RequestMapping("/a/*/antTest04")//a下的一层路径下所有文件下的antTest04
    public String AntTest04(){
        System.out.println("AntTest04被调用了。。。");
        return "success";
    }
    @RequestMapping("/a/**/antTest05")//a下的任意多层路径下所有文件下的antTest04
    public String AntTest05(){
        System.out.println("AntTest04被调用了。。。");
        return "success";
    }
    //  要查/user/admin或/user/abc   /user路径相同
    //{id}可以作为路径占位符，语法：{变量名}
    @RequestMapping("/user/{id}")
    public String pathVariableTest(@PathVariable("id")String id){
        System.out.println("路径上的占位符的值为"+id);
        return "success";
    }

}
