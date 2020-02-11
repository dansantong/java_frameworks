package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@org.springframework.stereotype.Controller
public class IndexController{
    @RequestMapping("/index")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)throws Exception{
        //ModelAndView对象将模型和视图结合在一起，视图是index.jsp，模型数据是message，内容是Hello Spring MVC
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("message","Hello Spring MVC");
        return mav;
    }

    @RequestMapping("/jump")
    public ModelAndView jump(){
        ModelAndView mav=new ModelAndView("redirect:/index");
        return mav;
    }

    @RequestMapping("/check")
    public ModelAndView check(HttpSession session){
        Integer i = (Integer) session.getAttribute("count");
        if(i==null){
            i=0;
        }
        i++;
        session.setAttribute("count",i);
        ModelAndView mav=new ModelAndView("check");
        return mav;

    }
}
