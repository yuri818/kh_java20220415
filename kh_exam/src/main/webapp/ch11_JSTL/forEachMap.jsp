<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>    
<%
	List<HashMap> mList = new ArrayList<HashMap>();
	HashMap<String,Object> member = 
			new HashMap<String,Object>();
	member.put("name","�̼���");
	member.put("age",26);
	member.put("address","����� �������� ��������");
	mList.add(member);
	member = new HashMap<String,Object>();
	member.put("name","�̼���");
	member.put("age",28);
	member.put("address","����� ���α� ������");
	mList.add(member);
	member = new HashMap<String,Object>();
	member.put("name","��Ȳ");
	member.put("age",29);
	member.put("address","����� ������ ������");
	mList.add(member);
	request.setAttribute("mList",mList);
%>
<jsp:forward page="forEachMapView2.jsp"/>