<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../common/easyui_common.jsp" %>
</head>
<body>
<script type="text/javascript">
	$(document).ready(function(){
		$( ".member li" ).click(function(e) {
			alert( "call: "+e.target.textContent );
			});
	});
</script>
	<ul class="member">
		<li>
		회원목록
		</li>
		<li>
			<span>회원등록</span>
		</li>
		<li>
			<span>회원삭제</span>
		</li>
	</ul>
</body>
</html>