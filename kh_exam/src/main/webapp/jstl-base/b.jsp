<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List" %>    
<%@ page import="model.vo.MemberVO" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>request�� session�� ����� ����</title>
</head>
<body>
<%
	List<MemberVO> rmemList = 
			(List<MemberVO>)request.getAttribute("rmemList");
	out.print("rmemberList:"+rmemList);
	out.print("<br>");
	List<MemberVO> smemList2 = 
			(List<MemberVO>)session.getAttribute("smemList");
	for(int i=0;i<smemList2.size();i++){
		out.print("id : "+smemList2.get(i).getMem_id()
				 +", name : "+smemList2.get(i).getMem_name());
	}
%>
<hr>
jstl ����Ͽ� ����ϱ�.
<c:forEach var="smem" items="${smemList}">
	���̵� : ${smem.mem_id} 
	��  �� : ${smem.mem_name}
</c:forEach>
<hr>
���ǿ��� �о�� �̸� : ${sname}
<!-- 
���
jstl�� ����ؼ� ���� �о�� ������ 
���� getAttribute�޼ҵ� ȣ�� ���̵� ���� ���ǰ���
����� �� �ִ�.

 -->
</body>
</html>







