package servlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.OrderItem;
import bean.Product;
import dao.ProductDAO;

public class OrderItemAddServlet extends HttpServlet{
    protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        request.setCharacterEncoding("UTF-8");
        int num=Integer.parseInt(request.getParameter("num"));
        int pid=Integer.parseInt(request.getParameter("pid"));
        Product product = new ProductDAO().getProduct(pid);

        OrderItem oi=new OrderItem();
        oi.setNum(num);
        oi.setProduct(product);

        List<OrderItem> ois =(List<OrderItem>)request.getSession().getAttribute("ois");
        if(null==ois){
            ois=new ArrayList<OrderItem>();
            request.getSession().setAttribute("ois",ois);
            ois.add(oi);
        }else{
            //如果之前购买过该产品，找出记录数量加一即可
            boolean found=false;
            for(OrderItem orderItem:ois){
                if(orderItem.getProduct().getId()==oi.getProduct().getId()){
                    orderItem.setNum(orderItem.getNum()+oi.getNum());
                    found=true;
                    break;
                }
            }
            if(found==false) ois.add(oi);
        }


        response.sendRedirect("/listOrderItem");

    }
}
