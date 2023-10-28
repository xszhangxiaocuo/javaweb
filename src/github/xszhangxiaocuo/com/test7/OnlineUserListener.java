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
        System.out.println("session被创建");
        count++;
        if (context == null) {
            context = se.getSession().getServletContext();
        }
        context.setAttribute("user", count);
        System.out.println("创建后count="+context.getAttribute("user"));
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session被销毁");
        count--;
        context.setAttribute("user", count);
        System.out.println("销毁后count="+context.getAttribute("user"));
    }
}
