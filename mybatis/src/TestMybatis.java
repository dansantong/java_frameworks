import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Category;
import pojo.Order;
import pojo.OrderItem;
import pojo.Product;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    public static void main(String[] args) throws IOException {
        String resource="mybatis-config.xml";
        InputStream inputStream =Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session=sqlSessionFactory.openSession();

        /*Category c2= new Category();
        c2.setName("category2");
        session.insert("addCategory",c2);

        Category c3=new Category();
        c3.setId(4);
        session.delete("deleteCategory",c3);

        Category c4=session.selectOne("getCategory",5);
        System.out.println(c4.getName());

        c4.setName("category zzz");
        session.update("updateCategory",c4);*/

       /* //listCategory是Category.xml里设置的id
        List<Category> cs=session.selectList("listCategory");
        for(Category c:cs){
            System.out.println(c);
            List<Product> ps=c.getProducts();
            for(Product p:ps){
                System.out.println("\t"+p);
            }
        }*/

        /*List<Product> ps=session.selectList("listProduct");
        for(Product p:ps){
            System.out.println(p+"分类\t"+p.getCategory());
        }*/

        /*List<Order> os=session.selectList("listOrder");
        for(Order o:os){
            System.out.println(o.getCode());
            List<OrderItem> ois=o.getOrderItems();
            for(OrderItem oi:ois){
                System.out.println(oi.getNumber());
                System.out.println(oi.getProduct());
            }
        }*/

        Order o1=session.selectOne("getOrder",1);
        Product p1=session.selectOne("getProduct",6);
        OrderItem oi=new OrderItem();
        oi.setOrder(o1);
        oi.setProduct(p1);
        session.insert("deleteOrderItem",oi);
        session.commit();
        session.close();
    }
}
