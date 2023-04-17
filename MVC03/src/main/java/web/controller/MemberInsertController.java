package web.controller;

import web.model.MemberDAO;
import web.model.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/memberInsert.do")
public class MemberInsertController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        // 1. 파라메터 수집(VO)
        String id = req.getParameter("id");
        String pass = req.getParameter("pass");
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        // 파라메터 수집(VO)
//        MemberVO vo = new MemberVO(id, pass, name, age, email, phone); 권장하는 방식이 아니다.
        MemberVO vo = new MemberVO(); // 생성자 대신 Setter를 사용하는 방식은 범용적으로 사용되어 권장하며 스프링이 파라메터 수집하는 방식이기도 하다.
        vo.setId(id);
        vo.setPass(pass);
        vo.setName(name);
        vo.setAge(age);
        vo.setEmail(email);
        vo.setPhone(phone);

//        System.out.println(vo.toString());
        MemberDAO dao = new MemberDAO();
        int result = dao.memberInsert(vo);
        if (result > 0) {
            // 1 -> 가입 성공
//            out.println("Insert Success"); 다시 회원리스트가 출력되는 페이지로 이동해야 한다. -> (/MVC03/memberList.do) Servlet에서는 절대경로(/MVC03/)입력해줘야 함
            resp.sendRedirect("/MVC03/memberList.do");
        } else {
            // 0 -> 가입 실패 : WAS(Tomcat)에게 예외 객체를 던진다.
            throw new ServletException("Insert Error");
        }
    }
}
