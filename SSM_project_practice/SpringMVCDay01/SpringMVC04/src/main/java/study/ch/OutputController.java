package study.ch;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 将数据输出到页面：
 * 1、除了在方法上传入原生api（通过原生api的域空间进行数据输出到页面）之外（此处不要演示了）
 * 2、可以在方法处传入Map或者Model或者ModelMap，这些参数里保存的所有数据都会放在域中，可以在页面通过request请求域获取
 * 3、使用ModelAndView代替之前的String返回类型，可以同时返回success页面和数据
 * 4、在类前使用注解@SessionAttributes向session域中保存数据，不推荐（尽量使用原生API）
 * 5、@ModelAttribute可用于方法和类上（被Mybatis取代了，不常用）
 */
@Controller
public class OutputController {
    //map通过request请求域调用
    @RequestMapping("/handle01")
    public String handle01(Map<String,Object> map){
        map.put("msg","你好map");
        return "success";
    }
    //model通过request请求域调用
    @RequestMapping("/handle02")
    public String handle02(Model model){//Model是springframework的一个接口
        model.addAttribute("msg","你好model");
        return "success";
    }
    //modelMap通过request请求域调用
    @RequestMapping("/handle03")
    public String handle02(ModelMap modelMap){//modelMap是一个实现类
        modelMap.addAttribute("msg","你好modelMap");
        return "success";
    }
    //ModelAndView通过request请求域调用
    @RequestMapping("/handle04")
    public ModelAndView handle02( ){//modelMap是一个实现类
        ModelAndView mv = new ModelAndView("success");
        mv.addObject("msg","你好ModelAndView");
        return mv;
    }
}
