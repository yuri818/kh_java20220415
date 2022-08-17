<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.vo.Member" %>
<%
	// 스크립틀릿에 작성된 코드는 화면이 아니다 - 출력 내용은 없다
	Member loginUser = new Member();
	loginUser.setName("유리");
	// session은 내장객체라서 바로 사용 가능
	// 톰캣서버는 기본적인 세션값이 30분이다
	session.setAttribute("loginUser", loginUser);
%>