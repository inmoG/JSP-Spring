<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="web.model.*" %>

<%
    MemberVO vo = (MemberVO) request.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="/MVC03/js/script.js"></script>
<title>MemberContent</title>
</head>
<body>
<form action="memberUpdate.do" method="post">
<table class="table table-bordered">
    <%
        if(vo != null) {
    %>
    <input type="hidden" name="num" value="<%= vo.getNum() %>"/>
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
        <tr>
            <td><%= vo.getNum() %></td>
            <td><%= vo.getId() %></td>
            <td><%= vo.getPass() %></td>
            <td><%= vo.getName() %></td>
            <td><input type="text" name="age" value="<%= vo.getAge() %>"</></td>
            <td><input type="text" name="email" value="<%= vo.getEmail() %>"</></td>
            <td><input type="text" name="phone" value="<%= vo.getPhone() %>"</></td>
            <td align="right"><input type="button" value="삭제" class="btn btn-warning" onclick="deleteMember(<%= vo.getNum() %>)"/></td>
        </tr>
        <tr>
            <td colspan="8" align="right">
                <input type="submit" value="수정" class="btn btn-primary"/>
                <input type="reset" value="취소" class="btn btn-warning"/>
                <input type="button" value="돌아가기" onclick="location.href='/MVC03/memberList.do'" class="btn btn-success"/>
            </td>
        </tr>
    </tbody>
    <%
    } else {
    %>
        <tr>
            <td>
                일치하는 회원이 없습니다.
                <input type="button" value="돌아가기" onclick="location.href='/MVC03/memberList.do'" class="btn btn-success"/>
            </td>
        </tr>
    <%
        }
    %>
</table>
</form>
</body>
</html>