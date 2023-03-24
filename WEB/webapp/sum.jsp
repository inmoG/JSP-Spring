<!--지시자 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="kr.web.util.*" %>
<!-- 스크립트릿 -->
<%
    Myutil util = new Myutil();
    int sum = util.sum();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제목</title>
</head>
<body>
<!-- View (프레젠테이션) 로직 -->
<table border="1">
<tr>
<td>1 ~ 100 까지의 총합</td>
<td><%= sum %></td>
</tr>
</table>
</body>
</html>