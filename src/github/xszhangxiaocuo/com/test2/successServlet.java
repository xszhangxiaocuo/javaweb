package github.xszhangxiaocuo.com.test2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "successServlet", value = "/test2/successServlet")
public class successServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        PrintWriter out  = response.getWriter();
        out.println("登录成功！");
        out.println("用户名："+(String) request.getAttribute("username"));
        out.println("密码："+(String) request.getAttribute("password"));
        out.println("用户名："+(String) request.getParameter("username"));
        out.println("密码："+(String) request.getParameter("password"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
