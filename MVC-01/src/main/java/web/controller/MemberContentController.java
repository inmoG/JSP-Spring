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

@WebServlet("/memberContent.do")
public class MemberContentController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int num = Integer.parseInt(req.getParameter("num"));
        MemberDAO dao = new MemberDAO();
        MemberVO vo = dao.memberContent(num);

        resp.setContentType("text/html;charset=utf-8"); // MIME-TYPE -> 스트림으로 클라이언트에 데이터를 보내기 전에 보내는 데이터 타입이 무엇인지 전달하는 역할
        PrintWriter out = resp.getWriter(); // 스트림으로 클라이언트와 데이터 전송 터널을 생성한다.

        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css' rel='stylesheet'>");
        out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js'></script>");
        out.println("<title>회원 상세보기</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2 align='center'>내 정보</h2>");
        out.println("<table class='table table-bordered'>");
        if (vo != null) {
            // 스트림을 사용해 데이터 전송
            out.println("<h4>" + vo.getName() + " 회원의 상세 페이지</h4>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>번호</th>");
            // 브라우저에서 한글이 깨지는 이유는 클라이언트가 받는
            // 데이터(Byte)의 타입을 모르기 때문 -> 데이터 전송 전에 MIME-TYPE을 알려줘야 함
            out.println("<th>아이디</th>");
            out.println("<th>비밀번호</th>");
            out.println("<th>이름</th>");
            out.println("<th>나이</th>");
            out.println("<th>이메일</th>");
            out.println("<th>전화번호</th>");
            out.println("<tr>");
            out.println("</thead>");
            out.println("<tbody>");
            out.println("<tr>");
            out.println("<td>" + vo.getNum() + "</td>");
            out.println("<td>" + vo.getId() + "</td>");
            out.println("<td>" + vo.getPass() + "</td>");
            out.println("<td>" + vo.getName() + "</td>");
            out.println("<td><input type='text' name='age' value='" + vo.getAge() + "'/></td>");
            out.println("<td><input type='text' name='email' value='" + vo.getEmail() + "'/></td>");
            out.println("<td><input type='text' name='phone' value='" + vo.getPhone() + "'/></td>");
            out.println("</tr>");
            out.println("</tbody>");
            out.println("<tr>");
            out.println("<td colspan='7' align='center'>");
            out.println("<a href='/MVC01/memberList.do'>회원 리스트</a>");
            out.println("</td>");
            out.println("</tr>");
        } else {
            out.println("<tr>");
            out.println("<td colspan='2' align='center'>");
            out.println("일치하는 회원이 없습니다.");
            out.println("</td>");
            out.println("<td align='center'>");
            out.println("<a href='/MVC01/memberList.do'>회원 리스트</a>");
            out.println("</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}
