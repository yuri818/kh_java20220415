<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 오라클에서 꺼내온(세션에서 가져온) 이름을 모든 페이지에서 공유하고 싶다면 어떡해???
	// 선수학습: 서블릿과 JSP[출력페이지]사이에서 유지하기 - forward - request scope
	String s_name = "이유리";
	int s_age = 25;
	// forward와 상관없이 값을 유지(사용) 가능함
	// forward의 scope: request
	// scope는 4가지 종류가 있다
	// page | request(forward)-sendRedirect는 쓰지말장 | session | application
	// A a = new A(); 는 스코프가 없다 
	// -> 웹서비스가 아니어서 Socket과 ServerSocket을 사용함(서버와 클라이언트 사이의 통신을 위해)
	// sendRedirect이든 forward(req-싱글톤패턴비밀!!원본이다,res) 상관없이 그 시간동안
	// 무조건 유지 된다
	session.setAttribute("s_name", s_name);
	session.setMaxInactiveInterval(3000);
	session.setAttribute("s_age", s_age);
%>
<jsp:useBean id="myName" scope="page" class="java.lang.String"/>
<jsp:useBean id="yourName" scope="request" class="java.lang.String"/>
<jsp:useBean id="herName" scope="session" class="java.lang.String"/>
<jsp:useBean id="himName" scope="application" class="java.lang.String"/>