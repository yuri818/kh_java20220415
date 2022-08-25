<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = "홍길동";
	request.setAttribute("r_name", name); // 요청 scope에 값이 담긴다
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>a.jsp</title>
</head>
<body>
1. a.jsp를 요청합니다
<br>
2. a.jsp페이지 내용이 출력 됩니다.
<br>
<hr>
<jsp:include page="b.jsp" flush="false"/>
<hr>
3. b.jsp를 경유한 후 출력 부분입니다.
</body>
</html>