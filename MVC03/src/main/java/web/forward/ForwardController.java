package web.forward;

import web.model.MemberVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/fc.do")
public class ForwardController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // View page(result.jsp)로 data 전달해 View Page에서 출력하는 방법
        // 1. redirect
        String data = "apple";
//        req.setAttribute("data", data);
//        resp.sendRedirect("/MVC03/View/result.jsp?data="+data);
        // 2. web.forward
        String name = "Yang";
        int age = 27;
        String email = "inmo@naver.com";

        MemberVO vo = new MemberVO();
        vo.setName(name);
        vo.setAge(age);
        vo.setEmail(email);

        req.setAttribute("vo", vo); // 객체 바인딩
        RequestDispatcher rd = req.getRequestDispatcher("View/web.forward.jsp"); // 요청의뢰
        rd.forward(req, resp); // 포워드
    }
}
