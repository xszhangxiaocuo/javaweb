package github.xszhangxiaocuo.com.test7;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.ServletContext;

@WebListener
public class OnlineUserListener implements HttpSessionListener {

    private ServletContext context = null;
    private Integer count = 0; // 在线用户数

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        count++;
        if (context == null) {
            context = se.getSession().getServletContext();
        }
        context.setAttribute("user", count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        count--;
        context.setAttribute("user", count);
    }
}
