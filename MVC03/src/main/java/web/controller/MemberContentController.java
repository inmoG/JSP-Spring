package web.controller;

import web.model.MemberDAO;
import web.model.MemberVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/memberContent.do")
public class MemberContentController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int num = Integer.parseInt(req.getParameter("num"));
        MemberDAO dao = new MemberDAO();
        MemberVO vo = dao.memberContent(num);

        // 객체 바인딩
        req.setAttribute("vo", vo);
        // 요청의뢰
        RequestDispatcher rd = req.getRequestDispatcher("member/memberContent.jsp");
        // 포워딩
        rd.forward(req, resp);

    }
}
