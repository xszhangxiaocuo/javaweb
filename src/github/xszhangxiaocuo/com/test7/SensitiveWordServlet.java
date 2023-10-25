package github.xszhangxiaocuo.com.test7;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SensitiveWordServlet", value = "/test7/SensitiveWordServlet")
public class SensitiveWordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String info = request.getParameter("message");
        PrintWriter out = response.getWriter();
        out.println("用户："+request.getParameter("username")+"<br>");
        out.println("留言："+request.getParameter("message"));
    }
}