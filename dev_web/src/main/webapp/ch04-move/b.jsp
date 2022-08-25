<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>b.jsp페이지</title>
</head>
<body>
<%!
// 디클러레이션은 있는 기능이지만 쓰지 않는다
	int age = 10; // 전변 설정 -> 의미없는 것이 클래스 이름이 내가 작성한 것과 달라 인스턴스화 할 수 없다.
	public String getName() { // 메소드 선언 가능하지만 쓰지 않는다
		return "강감찬";
	}
	/** 왜 이 declaration은 쓰지 않아?
		MVC패턴을 쓰기 때문! - 관심사 분리(화면, 로직으로 분리, 입력, 출력, 처리)
		a.jsp -(jsp.api) -> a_jsp.java(서블릿) -> a_jsp.class
		브라우저 쓰기 document.write("<b>굵은글씨</b>");
		
	*/
%>
<%
	String r_name = (String)request.getAttribute("r_name");
	out.print(r_name);
	// 스크립틀릿 안에는 메소드 선언 불가함
%>
<br>
1. 이 페이지는 a.jsp페이지 내에 출력됩니다.
<br>
2. 여기는 b.jsp페이지 내용입니다.
</body>
</html>