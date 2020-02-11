package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pojo.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ProductController {
    //add方法的参数product用于接受来自addProduct.jsp的参数注入
    //且参数product会被默认当做值加入ModelAndView中，即默认有mav.addObject("product",product)
    @RequestMapping("/addProduct")
    public ModelAndView add(Product product) throws Exception{
        ModelAndView mav=new ModelAndView("/showProduct");
        return mav;
    }
}
