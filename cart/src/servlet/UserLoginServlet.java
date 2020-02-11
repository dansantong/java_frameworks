package servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UserDAO;

public class UserLoginServlet extends HttpServlet {
    protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        request.setCharacterEncoding("UTF-8");
        String name=request.getParameter("name");
        String password =request.getParameter("password");
        User user = new UserDAO().getUser(name,password);
        if(null!=user){
            //该用户的信息需要保存在该会话中,后面下单的时候会用到
            request.getSession().setAttribute("user",user);
            response.sendRedirect("/listProduct");
        }else{
            response.sendRedirect("/login.jsp");
        }
    }
}
