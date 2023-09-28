package github.xszhangxiaocuo.com.test3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "successServlet", value = "/test3/successServlet")
public class successServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out  = response.getWriter();
        HttpSession session = request.getSession(false);
        out.println("登录成功！欢迎您！");
        if (session==null||session.getAttribute("user")==null) {
            out.println("找不到用户信息！");
            return;
        }
        out.println("用户名："+((User) session.getAttribute("user")).getName());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
