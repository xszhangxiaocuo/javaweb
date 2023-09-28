package github.xszhangxiaocuo.com.test3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "cart", value = "/test3/cart")
public class cart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession(false);
        PrintWriter out = response.getWriter();
        if (session==null){
            out.println("找不到session！");
            return;
        }
        shoppingCart cart = (shoppingCart) session.getAttribute("cart");
        if (cart==null){
            out.println("找不到购物车！");
            return;
        }
        if (session.getAttribute("user")==null){
            out.println("找不到用户信息！");
            return;
        }
        out.println("欢迎您！"+((User) session.getAttribute("user")).getName()+"<br>");
        out.println("您的购物车有"+cart.getNumber()+"个商品<br><br>");
        out.println("您已选购以下书籍：<br>");
        Map<String,Integer> books = cart.getItems();
        for (String key: books.keySet()){
            out.println(key+":"+books.get(key)+"本<br>");
        }

        out.println("<a href=\"/javaweb_war_exploded/shopping.html\">继续购物</a><br>");
        out.println("<a href=\"/javaweb_war_exploded/test3/login\">退出系统</a><br>");

    }
}
