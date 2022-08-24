<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시험 결과 확인</title>
</head>
<body>
판정페이지 입니다.
<br>
<div style="color: violet;">
<%
	// 이 코드가 먼저 결정이 된다
	String isPass = request.getParameter("isPass");
	boolean bpass = Boolean.parseBoolean(isPass);
	if(bpass){
%>
	합격을 축하드립니다.✨
<%
	} else {
%>
	불합격입니다. 다시 도전해보세요😥
<%
	}
%>
</div>
</body>
</html>