package study.ch.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 所有异常都放入这个类中
 */
@ControllerAdvice
public class MyAllException {
    /**
     * 告诉springmvc这个方法专门用来处理ArithmeticException.class（算数异常）
     * value可以为数组:value ={a.class,b.class}
     */
    @ExceptionHandler(value = ArithmeticException.class)
    public ModelAndView handleException01(Exception e){

        System.out.println("程序出现了算数异常");
        ModelAndView view = new ModelAndView("myerror");
        view.addObject("exception",e);
        return view;
    }
}
