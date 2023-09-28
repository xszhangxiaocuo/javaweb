package github.xszhangxiaocuo.com.test3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "shopping", value = "/test3/shopping")
public class shopping extends HttpServlet {
    private String[] books;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String[] books = request.getParameterValues("books");
        HttpSession session = request.getSession();

        shoppingCart cart = (shoppingCart) session.getAttribute("cart");
        if (cart==null){
            cart = new shoppingCart();
        }
        if (books!=null) {
            for (String book : books) {
                cart.addItem(shoppingCart.itemNames[Integer.parseInt(book)]);
            }
        }
        session.setAttribute("cart",cart);
        request.getRequestDispatcher("/test3/cart").forward(request,response);
    }
}
