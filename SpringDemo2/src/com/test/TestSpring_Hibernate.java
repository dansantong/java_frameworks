package com.test;

import com.dao.CategoryDAO;
import com.pojo.Category;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;

public class TestSpring_Hibernate {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring-config.xml"});

        CategoryDAO dao=(CategoryDAO)context.getBean("dao");
        //CategoryDAO继承了HibernateTemplate，封装了session，可以直接调用增删查改方法

        /*//增加，且在增加前使能写入
        dao.setCheckWriteOperations(false);
        Category c=new Category();
        c.setName("category yyy");
        dao.save(c);

        //查询，修改，删除，不知道为什么不报错但是无法成功，c2查询出来了但是没有执行相应的sql
        Category c2=(Category)dao.get(Category.class,6);
        System.out.println(c2.getName());
        c2.setName("category2");
        System.out.println(c2.getName());

        dao.update(c2);

        dao.delete(c2);*/

        /*//分页查询
        DetachedCriteria dc=DetachedCriteria.forClass(Category.class);
        int start=5;//查询起始
        int count=5;//每页显示数量
        List<Category> cs=(List<Category>)dao.findByCriteria(dc,start,count);
        System.out.println(cs);*/

        /*//查询总数
        List<Long> l=(List<Long>)dao.find("select count(*) from com.pojo.Category c");
        System.out.println(l.get(0));*/

        //模糊查询
        List<Category> cs= (List<Category>)dao.find("from com.pojo.Category c where c.name like ?0","%c%");
        for(Category c:cs){
            System.out.println(c.getName());
        }

        DetachedCriteria dc=DetachedCriteria.forClass(com.pojo.Category.class);
        dc.add(Restrictions.like("name","%c%"));
        List<Category> cs1=(List<Category>)dao.findByCriteria(dc);
        for(Category c:cs1){
            System.out.println(c.getName());
        }


    }
}
