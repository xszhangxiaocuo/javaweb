package github.xszhangxiaocuo.com.test7;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

@WebListener
public class contextListener implements ServletContextListener, ServletContextAttributeListener,ServletRequestListener {

    public contextListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        System.out.println("context对象被创建了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
        System.out.println("context对象被销毁了");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("ServletContext attribute added: {" + event.getName() + "," + event.getValue() + "}");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("ServletContext attribute replaced: {" + event.getName() + "," + event.getValue() + "}");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("ServletContext attribute removed: {" + event.getName() + "," + event.getValue() + "}");
    }
}
