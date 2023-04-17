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
import java.util.ArrayList;

@WebServlet("/memberList.do")
public class MemberListController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 클라이언트 요청을 받는다. memberList.do (해당 컨트롤러는 파라메터가 없다.)
        // 2. 회원전체 리스트 가져오기 (Model 연동)
        MemberDAO dao = new MemberDAO();
        ArrayList<MemberVO> list = dao.memberList();

        // 객체 바인딩
        req.setAttribute("list", list);
        // 요청 의뢰
        RequestDispatcher rd = req.getRequestDispatcher("member/memberList.jsp");
        rd.forward(req, resp);
    }
}
