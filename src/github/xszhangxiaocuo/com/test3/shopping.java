package github.xszhangxiaocuo.com.test3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "shopping", value = "/test3/shopping")
public class shopping extends HttpServlet {
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
