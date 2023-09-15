package github.xszhangxiaocuo.com.test2;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JdbcPropertiesListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();

        // 获取配置文件的输入流
        InputStream inputStream = servletContext.getResourceAsStream("/WEB-INF/jdbc.properties");

        if (inputStream != null) {
            Properties properties = new Properties();
            try {
                properties.load(inputStream);
                String driver = properties.getProperty("driver");
                String url = properties.getProperty("url");
                String username = properties.getProperty("username");
                String password = properties.getProperty("password");

                // 输出各参数的值到控制台
                System.out.println("Driver: " + driver);
                System.out.println("URL: " + url);
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("jdbc.properties文件未找到！");
        }
    }

}
