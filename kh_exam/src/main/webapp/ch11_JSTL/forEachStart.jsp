<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>    
<%
	List<String> myNames = new ArrayList<String>();
	myNames.add(0,"�̼���");
	myNames.add(1,"������");
	myNames.add(2,"������");
	request.setAttribute("myNames", myNames);
%>
<jsp:forward page="forEachStartNames.jsp"/>