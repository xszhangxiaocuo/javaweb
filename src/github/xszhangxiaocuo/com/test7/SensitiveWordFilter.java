package github.xszhangxiaocuo.com.test7;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

@WebFilter(filterName = "SensitiveWordFilter",urlPatterns = "/test7/SensitiveWordServlet")
public class SensitiveWordFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        chain.doFilter(new NewRequest((HttpServletRequest) request), response);
    }
}

class NewRequest extends HttpServletRequestWrapper {

    public NewRequest(HttpServletRequest request) {
        super(request);
    }

    //改写获取参数
    public String getParameter(String name) {
        String info = super.getParameter(name);
        String[] words = {"狗屁","牛魔","小丑","大傻逼","卧槽"};
        System.out.println(info);
        if (name.equals("message")){
            for (String word : words) {
                if (info.contains(word)){
                    info=info.replace(word,"**");
                }
            }
       }
        System.out.println(info);
        return info;
    }

}
