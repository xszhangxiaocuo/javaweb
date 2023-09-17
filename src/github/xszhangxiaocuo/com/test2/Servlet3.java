package github.xszhangxiaocuo.com.test2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet3", value = "/test2/Servlet3")
public class Servlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //在web.xml中添加以下代码，解决控制台输出乱码
        //<init-param>
        //     <param-name>fileEncoding</param-name>
        //     <param-value>UTF-8</param-value>
        //  </init-param>
        request.setCharacterEncoding("utf-8");  //解决参数乱码
        response.setContentType("text/html;charset=utf-8");//解决页面显示乱码
        PrintWriter out = response.getWriter();
        out.println("你好");
        System.out.println(request.getParameter("username"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
