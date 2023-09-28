package github.xszhangxiaocuo.com.test2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "RefererServlet", value = "/test2/RefererServlet")
public class RefererServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String referer = request.getHeader("Referer");
        // 检查Referer是否为空或不包含本网站首页
        if (referer == null || !referer.contains("/javaweb_war_exploded/referer.html")) {
            // 重定向回首页或其他适当的页面
            response.sendRedirect("/javaweb_war_exploded/login.html");
        } else {
            // 正常显示页面内容
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("没有盗链行为，显示正常！");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
