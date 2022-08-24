<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String test5 = request.getParameter("htest5"); // hidden은 get방식이라 getParameter로 가져옴
	out.print("3번문제 답안지: "+test5);
	Cookie ctest5 = new Cookie("test5", test5);
	ctest5.setPath("/onLineTest");
	ctest5.setMaxAge(60*30); // 30분
	response.addCookie(ctest5);
	
	response.sendRedirect("score.jsp");
%>