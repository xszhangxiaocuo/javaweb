package github.xszhangxiaocuo.com.test3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "LastAccessServlet", value = "/test3/LastAccessServlet")
public class LastAccessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        boolean flag = false;
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("lastTime")){
                flag=true;

                String lastTime = cookie.getValue();
                lastTime = URLDecoder.decode(lastTime,"utf-8");
                response.getWriter().println("上次登录时间："+lastTime);

                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日"+"HH:mm:ss");
                String format_date = sdf.format(date);
                format_date = URLEncoder.encode(format_date,"utf-8");
                cookie.setValue(format_date);
                cookie.setMaxAge(60*60*24);
                response.addCookie(cookie);

                break;
            }
        }
        if (!flag){
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日"+"HH:mm:ss");
            String format_date = sdf.format(date);
            format_date=URLEncoder.encode(format_date,"utf-8");
            Cookie cookie = new Cookie("lastTime",format_date);
            response.addCookie(cookie);
            response.getWriter().println("这是您首次访问！");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
