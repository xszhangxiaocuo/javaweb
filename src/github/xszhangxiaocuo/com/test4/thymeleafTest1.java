package github.xszhangxiaocuo.com.test4;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "thymeleafTest1", value = "/test4/thymeleafTest1")
public class thymeleafTest1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("name","重理工");
        request.setAttribute("age","32");

        response.setContentType("text/html;charset=utf-8");
        //创建模版引擎
        WebApplication webApplication = new WebApplication(this.getServletContext());
        TemplateEngine templateEngine = webApplication.getTemplateEngine();
        //获取上下文
        WebContext ctx = new WebContext(request,response,this.getServletContext());
        //渲染页面
        templateEngine.process("index1",ctx,response.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
