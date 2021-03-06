package study.ch;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 1、实现HandlerInterceptor接口
 * 2、在springmvc配置文件中注册这个拦截器
 *         配置这个拦截器来拦截哪些请求的目标方法
 */
public class MyHandlerInterceptor implements HandlerInterceptor {
    @Override//目标方法运行之前调用
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("MyHandlerInterceptor的preHandle方法运行了");
        return true;//设置为true，放行
    }

    @Override//紧接目标方法执行完之后调用
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("MyHandlerInterceptor的postHandle方法运行了");
    }

    @Override//整个请求完成之后调用，来到目标页面之后，preHandle放行之后
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("MyHandlerInterceptor的afterCompletion方法运行了");
    }
}
