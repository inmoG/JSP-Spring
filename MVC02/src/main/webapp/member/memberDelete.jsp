<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="web.model.*" %>
<%-- 컨트롤러용 JSP --%>
<%
    int parameter = Integer.parseInt(request.getParameter("num"));

    MemberDAO dao = new MemberDAO();
    int result = dao.memberDelete(parameter);

    if(result > 0){
        response.sendRedirect("memberList.jsp");
    } else {
        throw new ServletException("Not Delete");
    }
%>
