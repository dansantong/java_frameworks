package com.dao;
import org.springframework.orm.hibernate5.HibernateTemplate;

/**
 * Hibernate中封装了很多和session有关的方法，使得从外面看看不出来是hibernate
 * Hibernate类具有setSessionFactory方法，用于接收来自Spring的SessionFactory注入
 * CategoryDAO集成HibernateTemplate后，直接具有save,get,update,delete方法
 */

public class CategoryDAO extends HibernateTemplate{

}
