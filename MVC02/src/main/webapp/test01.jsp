<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%-- JSP 주석 --%>
<%!
    // 메서드 선언문
    public int sum(int k, int j){
        int sum = 0;
        for(int i = k; i <= j; i++)
        {
            sum += i;
        }
        return sum;
    }
%>
<%
    // 순수한 JAVA Code
    int sum = 0;
    for(int i = 1; i <= 10; i++)
    {
        sum += i;
    }
    // JSP 내장 객체 (이미 만들어진 객체)
    // request, response, session, out, config, application, page, pageContext
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>title</title>
</head>
<body>
<h2>JSP</h2>
</dr>
<p>1 ~ 10까지의 합 <%= sum %></p>
<p>55 ~ 350까지의 합 <%= sum(55, 350) %></p>
</body>
</html>