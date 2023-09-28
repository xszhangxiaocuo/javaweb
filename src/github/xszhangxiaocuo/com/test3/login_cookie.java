package github.xszhangxiaocuo.com.test3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "login_cookie", value = "/test3/login_cookie")
public class login_cookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");//设置response使用utf-8并告知浏览器，解决中文乱码

        //30s免密登录
        for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("noPassword")) {
                    if (cookie.getValue().equals("true")) {
                        request.getRequestDispatcher("/test3/successServlet").forward(request, response);
                        return;
                    }
                }
            }

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String contact = request.getParameter("contact");

        if (username==null&&password==null){
            request.getRequestDispatcher("/login_cookie.html").forward(request,response);
            return;
        }
        HttpSession session = request.getSession();
        User user = Users.getUser(username);
        if (user==null){
            Users.addUser(username,password);
            user = Users.getUser(username);
        }
        if (session.getAttribute("user")==null){
            session.setAttribute("user",user);
        }
        if (username.equals("xszxc")&&password.equals("123")){
            //添加免登录cookie
            if (contact!=null&&contact.equals("noPassword")){
                Cookie cookie = new Cookie("noPassword","true");
                cookie.setMaxAge(30);
                response.addCookie(cookie);
            }
            request.getRequestDispatcher("/test3/successServlet").forward(request,response);
        }else {
            request.getRequestDispatcher("/login_cookie.html").forward(request,response);
        }
    }
}

