<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 세션에 담긴 모든 정보가 다 삭제됨.
	session.invalidate();
// 세션에 담긴 정보중 특정한 정보만 삭제하려면
//	session.removeAttribute("이름"); // 이름에 대응하는 값만 삭제가능함
// 세션에 있는 값이 다 지워진 상태이므로 로그인화면으로 가게 된다.(세션값없는 if문으로)
	response.sendRedirect("./loginForm.jsp");
%>