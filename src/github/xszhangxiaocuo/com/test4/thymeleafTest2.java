package github.xszhangxiaocuo.com.test4;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "thymeleafTest2", value = "/test4/thymeleafTest2")
public class thymeleafTest2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("cn","这是修改了启动页面的index2.html");
        request.setAttribute("cqut","注意：<a href='https://www.cqut.edu.cn'>学校官网</a>");

        request.setAttribute("description","这是模版替换的网页描述");
        request.setAttribute("keywords","这是模版替换的关键词");

        response.setContentType("text/html;charset=utf-8");

        WebApplication webApplication = new WebApplication(this.getServletContext());
        TemplateEngine templateEngine = webApplication.getTemplateEngine();
        WebContext ctx = new WebContext(request,response,this.getServletContext());
        templateEngine.process("index2",ctx,response.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
