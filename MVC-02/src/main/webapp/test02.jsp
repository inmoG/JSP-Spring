<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="web.model.*" %>
<%
   MyCalc c = new MyCalc();
   int v = c.hap(1, 300);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>title</title>
</head>
<body>
결과 = <%=v%>
</body>
</html>