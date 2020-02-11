package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bean.Product;

/**
 * 连接数据库后查询获取Product数据
 */

public class ProductDAO {
    public List<Product> ListProduct(){
        List<Product> products = new ArrayList<>();
        //连接数据库,并查询所有产品信息
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8","root","admin");

            String sql="select * from product order by id desc";
            PreparedStatement ps=c.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                Product product = new Product();
                int id=rs.getInt(1);
                String name=rs.getString(2);
                float price =rs.getFloat(3);
                product.setId(id);
                product.setName(name);
                product.setPrice(price);
                products.add(product);
            }

            ps.close();
            c.close();

        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return products;
    }

    public Product getProduct(int id){
        Product result=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8","root","admin");

            String sql="select * from product where id=?";
            PreparedStatement ps=c.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();

            if(rs.next()){
                result = new Product();
                result.setId(id);
                String name=rs.getString(2);
                float price =rs.getFloat(3);
                result.setName(name);
                result.setPrice(price);
            }

            ps.close();
            c.close();

        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;

    }


}
