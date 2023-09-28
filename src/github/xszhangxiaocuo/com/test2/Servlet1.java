package github.xszhangxiaocuo.com.test2;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet(name = "test2Servlet1", value = "/test2/Servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        ServletContext ctx = this.getServletContext();
        String param = ctx.getInitParameter("encoding");//获取servletcontext中的参数

        int count=0;
        if (ctx.getAttribute("count")==null) {
            ctx.setAttribute("count",count);
        }else {
            count = (int) ctx.getAttribute("count");
            count++;
            ctx.setAttribute("count", count);
        }
        out.println("encoding:"+param);
        response.setContentType("text/html;charset=utf-8");//设置response使用utf-8并告知浏览器，解决中文乱码
        out.println("访问计数："+count);

        InputStream input = ctx.getResourceAsStream("/WEB-INF/jdbc.properties");//读取文件并输出到控制台
        String str = new String(input.readAllBytes());
        System.out.println(str);
        out.println(str);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request,response);
    }
}
