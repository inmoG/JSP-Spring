package web.controller;

import web.model.MemberDAO;
import web.model.MemberVO;

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

        // 3. 회원전체 리스트를 HTML로 만들어서 응답하기
//        응답되는 데이터 안에 한글이 있는 경우 -> 인코딩 해야한다.
        resp.setContentType("text/html;charset=utf-8"); // MIME-TYPE -> 스트림으로 클라이언트에 데이터를 보내기 전에 보내는 데이터 타입이 무엇인지 전달하는 역할
        PrintWriter out = resp.getWriter(); // 스트림으로 클라이언트와 데이터 전송 터널을 생성한다.
//        스트림을 사용해 데이터 전송
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css' rel='stylesheet'>");
        out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js'></script>");
        out.println("<title>회원 관리</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2 align='center'>회원 리스트</h2>");
        out.println("<table class='table table-bordered'>");
        out.println("<thead>");
        out.println("<th>번호</th>");
        // 브라우저에서 한글이 깨지는 이유는 클라이언트가 받는
        // 데이터(Byte)의 타입을 모르기 때문 -> 데이터 전송 전에 MIME-TYPE을 알려줘야 함
        out.println("<th>아이디</th>");
        out.println("<th>비밀번호</th>");
        out.println("<th>이름</th>");
        out.println("<th>나이</th>");
        out.println("<th>이메일</th>");
        out.println("<th>전화번호</th>");
        out.println("<th>삭제</th>");
        out.println("<tr>");
        out.println("</thead>");
        out.println("<tbody>");
        for (MemberVO vo : list) {
            out.println("<tr>");
            out.println("<td>" + vo.getNum() + "</td>");
            out.println("<td><a href='/MVC01/memberContent.do?num=" + vo.getNum() + "'/>" + vo.getId() + "</td>");
            out.println("<td>" + vo.getPass() + "</td>");
            out.println("<td>" + vo.getName() + "</td>");
            out.println("<td>" + vo.getAge() + "</td>");
            out.println("<td>" + vo.getEmail() + "</td>");
            out.println("<td>" + vo.getPhone() + "</td>");
            out.println("<td><a href='/MVC01/memberDelete.do?num=" + vo.getNum() + "'>삭제</a></td>");
            // ?num=" + vo.getNum() + " -> (?변수=파라메터 값) 파라메터를 달고 request 하는 방식을 get 방식이라 부르고 넘어가는 값을 queryString이라 부른다.
            out.println("</tr>");
        }
        out.println("</tbody>");
        out.println("<tr>");
        out.println("<td colspan='8' align='center'>");
        out.println("<a href='member/memberRegister.html'>회원가입</a>");
        out.println("</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}
