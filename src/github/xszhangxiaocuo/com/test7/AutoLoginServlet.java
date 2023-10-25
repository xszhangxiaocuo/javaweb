package github.xszhangxiaocuo.com.test7;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "AutoLoginServlet", value = "/test7/AutoLoginServlet")
public class AutoLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        ServletConfig sc = this.getServletConfig();
        sc.getServletContext();
        this.getServletContext();
        HttpSession session = request.getSession();
        session.getServletContext();

        if ("xszxc".equals(username)==false||"123".equals(password)==false){
            request.getRequestDispatcher("/rememberlogin.html").forward(request,response);
            return;
        }
        Users.addUser(username,password);
        User user = Users.getUser(username);
        request.getSession().setAttribute("user",user);
        String autoLoginDuration=request.getParameter("autoLoginDuration");
        if (autoLoginDuration!=null){
            int duration = Integer.parseInt(autoLoginDuration);
            Cookie cookie = new Cookie("autoLogin",username+"-"+password);
            cookie.setMaxAge(duration*60);  //单位分钟
            cookie.setPath(request.getContextPath());
            response.addCookie(cookie);
            request.getSession().setAttribute("user",user);
        }
       response.sendRedirect(request.getContextPath()+"/welcome.html");
    }
}