package github.xszhangxiaocuo.com.test7;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AutoLoginFilter",urlPatterns = "/*")
public class AutoLoginFilter implements Filter {
    FilterConfig fc;

    public void init(FilterConfig config) throws ServletException {
        this.fc = config;
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if(req.getRequestURI().endsWith("/ServletLogout")||req.getRequestURI().endsWith("/OnlineUserServlet")){
            chain.doFilter(req,res);
            return;
        }

        boolean isLoggedIn = false;
        User user = (User) req.getSession().getAttribute("user");

        String autoLogin = null;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("autoLogin".equals(cookie.getName())) {
                    autoLogin = cookie.getValue();
                    break;
                }
            }
        }
        //判断自动登录没有过期
        if (autoLogin != null && !autoLogin.isEmpty()) {
            // 检查用户是否已经登录
            if (user != null) {
                isLoggedIn = true;
            } else {
                // 如果用户未登录，尝试从cookie中获取登录信息
                    String[] parts = autoLogin.split("-");
                    if (parts.length == 2) {
                        String username = parts[0];
                        String password = parts[1];

                        if ("xszxc".equals(username) && "123".equals(password)) {
                            isLoggedIn = true;
                            user = new User(username, password);
                            req.getSession().setAttribute("user", user);
                        }
                }
            }
        }

        // 检查是否已经登录，并且当前URL是登录页
        String currentURL = req.getRequestURI();
        boolean isLoginURL = currentURL != null && currentURL.endsWith("/rememberlogin.html");
        System.out.println(currentURL);
        System.out.println(isLoggedIn);
        System.out.println(isLoginURL);
        if (isLoggedIn && isLoginURL) {
            // 如果用户已登录并且当前是登录页面，则重定向到主页或欢迎页
            res.sendRedirect(req.getContextPath() + "/welcome.html");
        } else if (req.getParameter("username")==null&&isLoginURL==false&&isLoggedIn==false){
            res.sendRedirect(req.getContextPath()+"/rememberlogin.html");
        }else {
            chain.doFilter(request, response);
        }
    }
}
