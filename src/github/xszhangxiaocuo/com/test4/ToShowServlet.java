package github.xszhangxiaocuo.com.test4;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ToShowServlet", value = "/test4/ToShowServlet")
public class ToShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        Book book1 = new Book("1","书本1","出版社1");
        Book book2 = new Book("2","书本2","出版社2");
        Book book3 = new Book("3","书本3","出版社3");

        List<Book> book = new ArrayList<>();
        book.add(book1);
        book.add(book2);
        book.add(book3);

        HttpSession session = request.getSession();
        session.setAttribute("book",book);

        WebApplication webApplication = new WebApplication(this.getServletContext());
        TemplateEngine templateEngine = webApplication.getTemplateEngine();
        WebContext ctx = new WebContext(request,response,this.getServletContext());
        templateEngine.process("book",ctx,response.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
