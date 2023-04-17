<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="web.model.*" %>
<%@ page import="java.util.*" %>

<%
    ArrayList<MemberVO> list = (ArrayList<MemberVO>) request.getAttribute("list");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="/MVC03/js/script.js"></script>
<title>MemberList</title>
</head>
<body>
<h3>[MVC03 예제 - Controller + View]</h3>
<table class="table table-bordered">
    <thead>
        <tr>
            <td>번호</td>
            <td>아이디</td>
            <td>비밀번호</td>
            <td>이름</td>
            <td>나이</td>
            <td>이메일</td>
            <td>전화번호</td>
            <td>삭제</td>
        </tr>
    </thead>
    <tbody>
    <% for(MemberVO vo : list) { %>
        <tr>
            <td><%= vo.getNum() %></td>
            <td><a href="memberContent.do?num=<%=vo.getNum()%>"/><%=vo.getId()%></td>
            <td><%= vo.getPass() %></td>
            <td><%= vo.getName() %></td>
            <td><%= vo.getAge() %></td>
            <td><%= vo.getEmail() %></td>
            <td><%= vo.getPhone() %></td>
            <td align="right"><input type="button" value="삭제" class="btn btn-warning" onclick="deleteMember(<%=vo.getNum()%>)"/></td>
        </tr>
    <% } %>
        <tr>
            <td colspan="8" align="right"><input type="button" value="회원가입" onclick="location.href='member/memberRegister.html'" class="btn btn-success"/></td>
        </tr>
    </tbody>
</table>

</body>
</html>