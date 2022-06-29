<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 이걸 스크립틀릿이라 함
	// 스크립틀릿에는 자바코드를 쓸 수 있다
	// 확장자는 jsp이지만 브라우저는 html이다. - 왜? mime type을 보고서...
	// 사용자가 입력한 아이디를 읽어오고 싶다. 어떡하지?
	//<input type="text" name="mem_id" id="mem_id">
	String mem_id = request.getParameter("mem_id");
	// 파라미터 자리는 id가 아닌 name 값을 적는다 반드시...
	out.print(mem_id); //tomato or apple or kiwi 등등 동적인 정보를 얻을 수 있다.
%>