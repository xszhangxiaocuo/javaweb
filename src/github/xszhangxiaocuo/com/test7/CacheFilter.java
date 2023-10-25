package github.xszhangxiaocuo.com.test7;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebFilter(filterName = "CacheFilter",urlPatterns = {"*.jpg"},
    initParams = {@WebInitParam(name = "jpg",value = "10")
    }
)
public class CacheFilter implements Filter {
    private FilterConfig fc;
    public void init(FilterConfig config) throws ServletException {
        this.fc = config;
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;
        String uri = req.getRequestURI();
        System.out.println(uri);
        if (uri.endsWith(".jpg")){
            // 设置缓存控制和过期时间
            long expiryTime = System.currentTimeMillis() + Long.parseLong(fc.getInitParameter("jpg"))*1000; // 设置为从现在起10s（单位为毫秒）
            res.setDateHeader("Expires", expiryTime);
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date(expiryTime);
            String str = sdf.format(date);
            System.out.println(str);
        }
        chain.doFilter(req, res);
    }
}
