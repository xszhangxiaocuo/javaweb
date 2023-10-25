package github.xszhangxiaocuo.com.test7;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OnlineUserServlet", value = "/test7/OnlineUserServlet")
public class OnlineUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // 从ServletContext获取在线用户数
        Integer onlineUserCount = (Integer) getServletContext().getAttribute("user");

        // 在页面上显示在线用户数
        response.getWriter().write("<p>Online users: " + onlineUserCount + "</p>");

        // 提供一个注销链接
        response.getWriter().write("<a href='/javaweb_war_exploded/test7/ServletLogout'>Logout</a>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}