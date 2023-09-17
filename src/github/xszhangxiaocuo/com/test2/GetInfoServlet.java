package github.xszhangxiaocuo.com.test2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "GetInfoServlet", value = "/test2/GetInfoServlet")
public class GetInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");//设置response使用utf-8并告知浏览器，解决中文乱码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        if (username.equals("xszxc")&&password.equals("123")){
            request.getRequestDispatcher("/welcome.html").forward(request,response);
        }else {
            request.getRequestDispatcher("/login.html").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
