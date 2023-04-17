<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="web.model.*" %> // import

<%
    // 파라메터 수집 (VO)
    request.setCharacterEncoding("utf-8");
    String id = request.getParameter("id");
    String name = request.getParameter("name");
    String pass = request.getParameter("pass");
    int age = Integer.parseInt(request.getParameter("age"));
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");

    MemberVO vo = new MemberVO();
    vo.setId(id);
    vo.setName(name);
    vo.setPass(pass);
    vo.setAge(age);
    vo.setEmail(email);
    vo.setPhone(phone);

    MemberDAO dao = new MemberDAO();
    int result = dao.memberInsert(vo);

    if(result > 0) {
        response.sendRedirect("memberList.jsp");
    } else {
        throw new ServletException("Not Insert");
    }
%>
</body>
</html>

