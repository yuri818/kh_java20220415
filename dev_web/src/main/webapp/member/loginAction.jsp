<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 원래 DB에서 "홍길동" 에 들어가는 값을 받아와야 하는데 지금은 상수로 넣어줄것임
	// 오라클 서버에 아이디와 비번을 넘겨서 모두 만족하면 
	// 아이디와 비번이 일치하면 이름을 가져온다
	// SELECT mem_name FROM 회원 WHERE 아이디=? AND 비번=?
	// 오라클 서버에서 조회된 이름을 세션객체에 담는다
	session.setAttribute("s_name", "홍길동");
%>