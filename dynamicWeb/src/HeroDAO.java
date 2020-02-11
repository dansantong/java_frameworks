import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HeroDAO {

    //构造函数
    public HeroDAO(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException{
        //连接数据库，此处test为数据库名称，后续要访问的hero表位于该数据库下
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8", "root","admin");
    }

    //获取hero表中数据总条数
    public int getTotal(){
        int total=0;
        try(Connection c=getConnection();Statement s = c.createStatement()){
            String sql = "select count(*) from hero";

            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                total=rs.getInt(1);
            }
            System.out.println("total:"+total);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return total;
    }

    public void add(Hero hero){
        String sql="insert into hero values(null,?,?,?)";
        try(Connection c =getConnection();PreparedStatement ps = c.prepareStatement(sql)){
            ps.setString(1,hero.name);
            ps.setFloat(2,hero.hp);
            ps.setInt(3,hero.damage);

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                int id = rs.getInt(1);
                hero.id=id;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void update(Hero hero){
        String sql="update hero set name=?,hp=?,damage=? where id=?";
        try(Connection c =getConnection();PreparedStatement ps=c.prepareStatement(sql)){

            ps.setString(1,hero.name);
            ps.setFloat(2,hero.hp);
            ps.setInt(3,hero.damage);
            ps.setInt(4,hero.id);

            ps.execute();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id){
        try(Connection c = getConnection();Statement s =c.createStatement()){
            String sql = "delete from hero where id="+id;
            s.execute(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public Hero get(int id) {
        Hero hero = null;
        try (Connection c = getConnection(); Statement s = c.createStatement()) {
            String sql = "select * from hero where id=" + id;
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                hero = new Hero();
                String name = rs.getString(2);
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                hero.name = name;
                hero.hp = hp;
                hero.damage = damage;
                hero.id = id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hero;
    }

    //返回hero表中的所有记录
    public List<Hero> list(){
        return list(0,Short.MAX_VALUE);
    }

    public List<Hero> list(int start,int count){
        List<Hero> heros = new ArrayList<>();

        String sql = "select * from hero order by id desc limit ?,?";
        try(Connection c=getConnection();PreparedStatement ps=c.prepareStatement(sql)){

            ps.setInt(1,start);
            ps.setInt(2,count);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Hero hero = new Hero();
                int id = rs.getInt(1);
                String name = rs.getString(2);
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                hero.name = name;
                hero.hp = hp;
                hero.damage = damage;
                hero.id = id;
                heros.add(hero);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return heros;
    }



}
