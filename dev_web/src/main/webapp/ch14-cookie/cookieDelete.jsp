<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 삭제하기</title>
</head>
<body>
<%
	// 같은 패스에 있는 것만 삭제된다
	// 쿠키가 "age"라면 path가 다르므로 삭제되지 않는다!! 
	Cookie cook = new Cookie("sneakers","");
	cook.setMaxAge(0);
	response.addCookie(cook);
%>
</body>
</html>