package com.dao;

import com.pojo.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

import javax.management.Query;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public void addProduct(Product p){
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session s=sf.openSession();
        s.beginTransaction();

        s.save(p);

        s.getTransaction().commit();
        s.close();
        sf.close();
    }

    public Product getProduct(int id){
        Product p = null;
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session s=sf.openSession();

        p=(Product)s.get(Product.class,id);

        s.close();
        sf.close();
        return p;
    }

    public void deleteProduct(int id){
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session s=sf.openSession();
        s.beginTransaction();
        Product p=(Product)s.get(Product.class,id);

        s.delete(p);

        s.getTransaction().commit();
        s.close();
        sf.close();

    }


    public void update(Product p){
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session s=sf.openSession();
        s.beginTransaction();

        s.update(p);

        s.getTransaction().commit();
        s.close();
        sf.close();
    }

    public List<Product> listProduct(){
        List<Product> products= new ArrayList<>();
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session s=sf.openSession();

        org.hibernate.query.Query q=s.createQuery("from Product p");
        products=((org.hibernate.query.Query) q).list();

        s.close();
        sf.close();
        return products;
    }

}
