<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="web.model.*" %>
<%
    int num = Integer.parseInt(request.getParameter("num"));
    int age = Integer.parseInt(request.getParameter("age"));
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");

    MemberVO vo = new MemberVO();
    vo.setNum(num);
    vo.setAge(age);
    vo.setEmail(email);
    vo.setPhone(phone);

    MemberDAO dao = new MemberDAO();
    int result = dao.memberUpdate(vo);

    if(result > 0) {
        response.sendRedirect("/MVC02/member/memberList.jsp");
    } else {
        throw new ServletException("Not Update");
    }
%>

<%--
        기본형 타입 초기값을 알아보기 위한 디버깅 코드
        String toStr = vo.toString();
        System.out.println(toStr);
--%>
