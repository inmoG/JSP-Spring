<!--지시자 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 스크립트릿 -->
<%
    java.util.Date day = new java.util.Date();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제목</title>
</head>
<body>

<! -- 인모 홈페이지 방문을 환영합니다. (동적인 페이지) <br>
지금 시간이 몇 시입니까? <%= day.toString() %> <!-- 출력식 -->

</body>
</html>