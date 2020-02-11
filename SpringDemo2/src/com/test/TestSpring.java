package com.test;

import com.pojo.Category;
import com.pojo.Product;
import com.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args){
        //spring的配置文件默认是在WEB-INF下面，如果不在的话，例如此处在src下面，就需要配置路径
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring-config.xml"});

        Category c =(Category)context.getBean("c");
        System.out.println(c.getName());

        Product p=(Product)context.getBean("p");
        System.out.println(p.getName());
        System.out.println(p.getCategory().getName());

        ProductService s = (ProductService) context.getBean("s");
        s.doSomeService();


    }
}
