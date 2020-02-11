package com.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

//该注解表明此类是bean
//@Component("p")
public class Product {
    private int id;
    private String name;
    /*//该注解通过匹配 数据类型 自动装配bean
    @Autowired*/
    //该注解通过匹配 名称 自动装配Bean，这两个注解都是用来实现依赖注入DI的
    //@Resource(name="c")
    private Category category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
