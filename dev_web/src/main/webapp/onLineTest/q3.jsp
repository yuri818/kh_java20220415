<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String test2 = request.getParameter("htest2"); // hidden은 get방식이라 getParameter로 가져옴
	out.print("2번문제 답안지: "+test2);
	Cookie ctest2 = new Cookie("test2", test2);
	ctest2.setPath("/onLineTest");
	ctest2.setMaxAge(60*30); // 30분
	response.addCookie(ctest2);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제3</title>
<script type="text/javascript">
	function test(pcb) { //pcb: 파라미터 체크박스
		for(let i=0;i<document.f_test1.cb.length;i++) {
			if(pcb == i) {// 선택 됐을 때
				document.f_test1.cb[i].checked = 1;	
			} else { // 체크 안됐을 때
				document.f_test1.cb[i].checked = 0;	
			}
		}
	}
	function prev() {
		location.href="q2.jsp";
	}
	function next() {
		let temp = 1;
		for(let i=0;i<document.f_test1.cb.length;i++) {
			if(document.f_test1.cb[i].checked == 1) {
				document.f_test1.htest3.value = temp;
			} else {
				temp = temp + 1;
			}
		}//////// end of for
		document.f_test1.submit();
	}
</script>
</head>
<body>
<form name="f_test1" method="get" action="q4.jsp">
<input type="hidden" name="htest3">
문제3. 다음 중 DCL구문으로 맞는 것을 고르시오.<br>
<input type="checkbox" name="cb" onChange="test(0)">grant<br>
<input type="checkbox" name="cb" onChange="test(1)">drop<br>
<input type="checkbox" name="cb" onChange="test(2)">alter<br>
<input type="checkbox" name="cb" onChange="test(3)">delete<br>
<br>
<input type="button" value="이전문제" onClick="prev()">
<input type="button" value="다음문제" onClick="next()">
</form>
</body>
</html>