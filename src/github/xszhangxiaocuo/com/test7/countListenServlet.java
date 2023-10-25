package github.xszhangxiaocuo.com.test7;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "countListenServlet", value = "/test7/countListenServlet")
public class countListenServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = this.getServletContext();

        Integer counter = (Integer) context.getAttribute("counter");

        // 如果counter是null，说明是第一次访问，设置counter为1，否则counter加1
        if (counter == null) {
            counter = 1;
        } else {
            counter = counter + 1;
        }

        context.setAttribute("counter", counter);
        response.getWriter().write("Counter: " + counter);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}