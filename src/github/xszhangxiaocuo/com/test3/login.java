package github.xszhangxiaocuo.com.test3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "login", value = "/test3/login")
public class login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");//设置response使用utf-8并告知浏览器，解决中文乱码

        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("noPassword")){
                if (cookie.getValue().equals("true")){
                    request.getRequestDispatcher("/welcome.html").forward(request,response);
                }
            }
        }

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String contact = request.getParameter("contact");

        if (username==null&&password==null){
            request.getRequestDispatcher("/login_cookie.html").forward(request,response);
        }

        if (contact!=null&&contact.equals("noPassword")){
            Cookie cookie = new Cookie("noPassword","true");
            cookie.setMaxAge(30);
            response.addCookie(cookie);
        }
        if (username.equals("xszxc")&&password.equals("123")){
            request.getRequestDispatcher("/welcome.html").forward(request,response);
        }else {
            request.getRequestDispatcher("/login_cookie.html").forward(request,response);
        }
    }
}
