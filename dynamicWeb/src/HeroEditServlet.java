import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeroEditServlet extends HttpServlet{
    protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        int id = Integer.parseInt(request.getParameter("id"));

        Hero hero = new HeroDAO().get(id);

        StringBuffer format = new StringBuffer();
        response.setContentType("text/html; charset=UTF-8");

        format.append("<!DOCTYPE html>");
        //在这个页面上点击更新后，则触发了/updateHero uri，跳转到HeroUpdateServlet执行
        format.append("<form action = 'updateHero' method='post'>");
        format.append("名字：<input type='text' name='name' value='%s'><br>");
        format.append("血量：<input type='text' name='hp' value='%f'><br>");
        format.append("伤害：<input type='text' name='damage' value='%d'><br>");
        format.append("<input type='hidden' name='id' value='%d'>");
        format.append("<input type='submit' value='更新'>");
        format.append("</form>");

        String html= String.format(format.toString(),hero.getName(),hero.getHp(),hero.getDamage(),hero.getId());
        response.getWriter().write(html);


    }
}
