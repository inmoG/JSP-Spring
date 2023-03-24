package web.controller;

import web.model.MyCalc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/calc.do")
// Servlet은 Controller 역할을 한다.
// 클라이언트가 톰캣서버에 요청했을 때 톰캣 서버는 HttpServletRequest (요청 객체), HttpServletResponse (응답 객체)를 만들어 패킷을 저장한다.
// 요청 객체와 응답 객체는 service(HttpServletRequest req, HttpServletResponse resp) 메서드의 파라미터 값으로 전달된다.
// 따라서 header(ip, port), body를 확인해 어느 클라이언트가 보낸 요청인지 파악할 수 있다.
public class calcController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //    1. 클라이언트에서 넘어오는 폼 파라메터를 받는다. (파라메터 수집, number1, number2)
        int number1 = Integer.parseInt(req.getParameter("number1"));
        int number2 = Integer.parseInt(req.getParameter("number2"));

//        2. 비즈니스 로직 -> Model 로 분리하기
//        비즈니스 로직 (Model)
        // number1 + number2
//        int sum = 0;
//        for (int i = number1; i <= number2; i++) {
//            sum += i;
//        }

//        2. 분리한 비즈니스 로직 -> 내부 코드는 Model에 위치한다.
        MyCalc calc = new MyCalc();
        int sum = calc.hap(number1, number2);

//        3. 응답하는 부분 (프레젠테이션 로직 = View = JSP)
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("<td>TOTAL</td>");
        out.println("<td>");
        out.println(sum);
        out.println("</td>");
    }
}
