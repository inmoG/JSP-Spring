package web.controller;

import web.model.MemberDAO;
import web.model.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/memberUpdate.do")
public class MemberUpdateController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        int num = Integer.parseInt(req.getParameter("num"));
        int age = Integer.parseInt(req.getParameter("age"));
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        MemberVO vo = new MemberVO();
        vo.setNum(num);
        vo.setAge(age);
        vo.setEmail(email);
        vo.setPhone(phone);

        MemberDAO dao = new MemberDAO();
        int result = dao.memberUpdate(vo);

        if (result > 0) {
            resp.sendRedirect("/MVC01/memberList.do");
        } else {
            throw new ServletException("Update Error");
        }
    }
}
