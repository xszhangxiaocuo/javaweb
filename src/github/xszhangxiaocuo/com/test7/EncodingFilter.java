package github.xszhangxiaocuo.com.test7;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "EncodingFilter",urlPatterns = "/*",
    initParams = {@WebInitParam(name = "encoding",value = "utf-8"),
                  @WebInitParam(name = "textType",value = "text/html;charset=utf-8")
    })

public class EncodingFilter implements Filter {
    private FilterConfig fc;
    public void init(FilterConfig config) throws ServletException {
        this.fc = config;
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        request.setCharacterEncoding(fc.getInitParameter("encoding"));
        response.setContentType(fc.getInitParameter("textType"));
        chain.doFilter(request, response);
    }
}
