package interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 拦截器类
 */
public class IndexIntercepter extends HandlerInterceptorAdapter {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handller) throws Exception{
        System.out.println("preHandler(),在访问Controller之前被调用");
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)throws Exception{
        System.out.println("postHandle(),在访问Controller之后，访问视图之前被调用，这里可以注入一个时间到ModelAndView中，用于后续视图显示");
        modelAndView.addObject("date","由拦截器生成的时间："+new Date());
    }

    public void afterCompletion(HttpServletRequest request,HttpServletResponse response,Object handler,Exception ex)throws Exception{
        System.out.println("afterCompletion(),在访问视图之后被调用");
    }
}
