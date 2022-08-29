<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="java.util.List, java.util.Map, java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %> 
<%
	List<Map<String,Object>> memberList= null;
	memberList = (List<Map<String,Object>>)request.getAttribute("memberList");
	Gson g = new Gson();
	String imsi = g.toJson(memberList);
	out.print(imsi);
%>