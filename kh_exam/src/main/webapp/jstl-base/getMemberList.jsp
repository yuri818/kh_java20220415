<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, model.vo.MemberVO" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!-- insert here -->
<%-- <jsp:useBean id="moCtrl" type=com.intro.AbstractClass | com.intro.Interface/> --%>
<% 
	//MemoController moCtrl = new MemoController();
 	List<MemberVO> memList = 
		(List<MemberVO>)session.getAttribute("memList");
	int size = 0;
//	if(memList!=null){//ȸ������� �־�?
	if(memList.size()>0){//ȸ������� �־�?
			
	}
		size = memList.size();
%> 
<!-- set�� setAttribute()�� �����Ѵ�. -->
<!-- el_size�� �������� ��ȸ�� ����� ���� row�� �� -->
<c:set var="el_size" value="${memList.size()}"/>
<!-- el_num�� ������ ���� ���� -->
<c:set var="el_num" value="${el_size}"/>
<!-- el_id�� ���� ���̵� ���� ���� -->
<c:set var="el_id" value="<%=s_id %>"/>
<!-- �������� ��ȸ����� ���� ������ �ڷᱸ�� �ּҺ���. -->
<c:set var="el_memList" value="${memList}"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript">
//������ ��� ���̵�
	function memoForm(p_id,p_name){//p_id:�޴»�� ���̵�
		var url = "memoForm.jsp?to_id="+p_id+"&to_name="+p_name;		
		cmm_window_popup(url
                ,500
                ,250
                ,"memoForm");
	}
</script>
</head>  
<body>
<table width="100%" height="100%" border="1" borderColor="green">
<tr valign="top">
	<td>
	<!-- ȸ�� ��� ȭ�� �߰��ϱ� ����-->
	<table align="center" width="500" height="200" border="1" borderColor="blue">
		<thead>
			<tr>
				<td align="center" colspan="4">ȸ�����</td>
			</tr>
		</thead>
		<!-- ���̺� ��� ���� -->
		<tr>
			<td align="center">ȸ����ȣ</td>
			<td align="center">ȸ�����̵�</td>
			<td align="center">ȸ����</td>
			<td align="center">&nbsp;</td>
		</tr>
		<!-- ���̺� ���  �� -->	
	<c:if test="${el_size>0}">
<%
	int num = size;
%>	
	<c:forEach var="member" items="${el_memList}">
		<tr>
			<td align="center"><%=num-- %></td>
			<td align="center">${member.mem_id}</td>
			<td align="center">${member.mem_name}</td>
			<td align="center">
<!-- DB���� ��ȸ�� ���̵�� ���Ǿ��̵� �ٸ���? -->
<c:if test="${member.mem_id ne el_id}">		
			<a href="javascript:memoForm('${member.mem_id}','${member.mem_name}')">����</a>
</c:if>		
<c:if test="${member.mem_id eq el_id}">		
			����
</c:if>	
			</td>
		</tr>
		</c:forEach>
	</c:if>
	<c:if test="${el_size==0}">
		<tr>
			<td align="center" colspan="4">ȸ������� �����ϴ�.</td>
		</tr>
	</c:if>
	</table>		
	<!-- ȸ�� ��� ȭ�� �߰��ϱ� ��  -->
	</td>
</tr>
</table>
</body>
</html>
