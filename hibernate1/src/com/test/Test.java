package com.test;

import com.example.Product;
import com.example.Category;
import com.example.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import javax.management.Query;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] args){
        Configuration configuration=new Configuration();
        configuration.configure("hibernate.cfg.xml");
        //获取SessionFactory
        SessionFactory sf=configuration.buildSessionFactory();
        //获取Session
        Session s=sf.openSession();
        //在Session上开启一个事务
        Transaction transaction = s.beginTransaction();

        /*Product p =new Product();
        p.setName("iphoneX");
        p.setPrice(10000);
        //调用Session的save方法将对象保存到数据库
        s.save(p);
        Product p1=new Product();
        p1.setName("iphone11");
        p1.setPrice(5999);
        s.save(p1);
        //获取对象
        Product p2=(Product)s.get(Product.class,8);
        System.out.println("id=8的产品名称为"+p2.getName());
        //删除对象
        s.delete(p2);
        //修改对象
        Product p3=(Product)s.get(Product.class,6);
        System.out.println(p3.getName());
        p3.setName("iphone11pro");
        s.update(p3);*/

        /*//hibernate query language
        String name="iphone";
        org.hibernate.query.Query q=s.createQuery("from Product p where p.name like ?1");
        //%name%的意思应该是只要带iphone子字符串就行,%是通配符
        q.setString(1,"%"+name+"%");
        List<Product> ps = q.list();
        for(Product p:ps){
            System.out.println(p.getName());
        }

        //criteria查询
        Criteria c=s.createCriteria(Product.class);
        c.add(Restrictions.like("name","%"+name+"%"));
        List<Product> ps1 = c.list();
        for(Product p:ps1){
            System.out.println(p.getName());
        }

        //标准SQL查询
        String sql="select * from product1 p where p.name like '%"+name+"%'";
        org.hibernate.query.Query q1=s.createSQLQuery(sql);
        List<Object[]> list = q1.list();
        for(Object[] ob:list){
            for(Object o:ob){
                System.out.println(o+"\t");
            }
            System.out.println();
        }*/

        /*多对一
        Category c=new Category();
        c.setName("category1");
        s.save(c);
        //此时product1表中其实我们并未添加cid字段，该字段是由hibernate自行添加的
        Product p=(Product)s.get(Product.class,5);
        p.setCategory(c);
        s.update(p);
        System.out.println("更新完毕！");

        //一对多
        Category c1=(Category)s.get(Category.class,1);
        Set<Product> products=c1.getProducts();
        for(Product p1:products){
            System.out.println(p1.getName());
        }*/

        //多对多
        //增加三个用户
        Set<User> users=new HashSet<>();
        for(int i=0;i<3;i++){
            User u= new User();
            u.setName("user"+i);
            users.add(u);
            s.save(u);
        }
        //商品1被这三个用户购买
        Product p1=(Product)s.get(Product.class,1);
        p1.setUsers(users);
        s.save(p1);


        //提交事务
        transaction.commit();
        //关闭
        s.close();
        sf.close();
    }
}
