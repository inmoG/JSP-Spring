package web.controller;

import web.model.MemberDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/memberDelete.do")
public class MemberDeleteController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // http://localhost:8080/MVC01/memberDelete.do?num=7
        int num = Integer.parseInt(req.getParameter("num"));
        MemberDAO dao = new MemberDAO();
        int result = dao.memberDelete(num);
        if (result > 0) {
            // 삭제 성공
            resp.sendRedirect("/MVC01/memberList.do");
        } else {
//            삭제 실패
            throw new ServletException("Delete Fail");
        }
    }
}
