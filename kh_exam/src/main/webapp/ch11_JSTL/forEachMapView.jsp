<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ������ ���</title>
</head>
<body>
<c:forEach var="map" items="${mList}" varStatus="x">
	[${x.index}] : ${mList[x.index]}
	${map.name}, ${map.age}, ${map.address}
	<c:if test="${map.age > 0 }">
		0���� ū ���Դϴ�
	</c:if>
</c:forEach>
</body>
</html>