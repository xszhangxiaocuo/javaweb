package github.xszhangxiaocuo.com.test7;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletLogout", value = "/test7/ServletLogout")
public class ServletLogout extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 注销session
        request.getSession().invalidate();

        // 重定向到在线用户显示页面，更新用户数量
        response.sendRedirect(request.getContextPath()+"/test7/OnlineUserServlet");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}