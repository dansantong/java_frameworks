package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pojo.Category;
import service.CategoryService;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    //映射访问路径
    @RequestMapping("listCategory")
    public ModelAndView listCategory(){
        ModelAndView mav=new ModelAndView();
        List<Category> cs=categoryService.list();
        mav.addObject("cs",cs);
        mav.setViewName("listCategory");
        return mav;
    }

}
