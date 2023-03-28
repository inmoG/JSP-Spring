package kr.web.controller;
// JavaEE -> Servlet 골격


import kr.web.util.Myutil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// Servlet은 톰캣에서 구동되며 웹 어플리케이션에 사용되는 자바 클래스 형태이다.
@WebServlet("/hs.do") // <-- web.xml
public class HelloServlet extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // request, response는 클라이언트 구성 정보 즉, IP와 Port를 안다.
        Myutil util = new Myutil();
        int sum = util.sum();

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println(sum); // 5050
        out.println("</body>");
        out.println("</html>");
        // 서블릿에서 해석 후 클라이언트(브라우저)에게 응답해야 한다.
    }
}
