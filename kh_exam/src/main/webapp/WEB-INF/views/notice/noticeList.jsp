<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, model.vo.Notice" %>    
<%
	// forward는 시간과는 관계가 없다!!!!!!!!!!!!!!!!!!!!
	// 시간과 관계잇는 것: 쿠키와 세션
	// 쿠키(문자열만, 텍스트만 -> Base64, Base32)
	// 바이너리 코드를 사용해야한다 -> 문자와 숫자가 공존하는 파일이라 첨부파일 처리가 가능하다
	// 바이너리는 get방식으로 전송이 불가함 - 파일의 크기가 커져서 속도가 느리기 때문이다
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
	out.print(list);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeList.jsp</title>
</head>
<body>
공지사항 목록
</body>
</html>