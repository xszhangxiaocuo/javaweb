package github.xszhangxiaocuo.com.test3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

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
        //退出登录注销session
        if (request.getHeader("Referer")!=null&&request.getHeader("Referer").contains("/javaweb_war_exploded/test3/shopping")){
            request.getSession().invalidate();
            System.out.println("session已注销！");
        }
        //30s免密登录,session为空时不进行判断
        if (request.getSession(false)!=null) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("noPassword")) {
                    if (cookie.getValue().equals("true")) {
                        request.getRequestDispatcher("/shopping.html").forward(request, response);
                        return;
                    }
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
        //添加免登录cookie
        if (contact!=null&&contact.equals("noPassword")){
            Cookie cookie = new Cookie("noPassword","true");
            cookie.setMaxAge(30);
            response.addCookie(cookie);
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
        if (user.getName().equals("xszxc")&&user.getPassword().equals("123")){
            request.getRequestDispatcher("/shopping.html").forward(request,response);
        }else {
            request.getRequestDispatcher("/login_cookie.html").forward(request,response);
        }
    }
}
