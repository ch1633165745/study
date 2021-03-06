package study.ch;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author shkstart
 * @create 2021-02-11-13:54
 */
@Controller
public class BookController {
    //查询请求get
    //参数1：拦截请求的地址
    //参数2：限制请求类型为get
    //@PathVariable可以获取参数以占位符中的信息
    @RequestMapping(value = "/book/{bookid}",method = RequestMethod.GET)
    public String selectBook(@PathVariable Integer bookid){
        System.out.println("查询到了1号图书，id为"+bookid);
        return "success";
    }
    //删除请求delete
    //参数1：拦截请求的地址
    //参数2：限制请求类型为DELETE
    //@PathVariable可以获取参数以占位符中的信息
    @RequestMapping(value = "/book/{bookid}",method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable Integer bookid){
        System.out.println("id为"+bookid+"的图书删除了");
        return "success";
    }
    //修改请求put
    //参数1：拦截请求的地址
    //参数2：限制请求类型为PUT
    //@PathVariable可以获取参数以占位符中的信息
    @RequestMapping(value = "/book/{bookid}",method = RequestMethod.PUT)
    public String updateBook(@PathVariable Integer bookid){
        System.out.println("id为"+bookid+"的图书修改了");
        return "success";
    }
    //添加请求post
    @RequestMapping(value = "/book",method = RequestMethod.POST)
    public String addBook(){
        System.out.println("添加图书成功");
        return "success";
    }
}
