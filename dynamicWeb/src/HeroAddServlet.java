

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeroAddServlet extends HttpServlet {
    protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        request.setCharacterEncoding("UTF-8");

        Hero hero = new Hero();
        hero.setName(request.getParameter("name"));
        hero.setHp(Float.parseFloat(request.getParameter("hp")));
        hero.setDamage(Integer.parseInt(request.getParameter("damage")));

        new HeroDAO().add(hero);

        //添加完毕后让客户端跳转到listHero查看所有的Hero，验证是否添加成功
        response.sendRedirect("/listHero");

    }
}
