<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제1</title>
<script type="text/javascript">
/** 브라우저가 DOM트리 구성할 때 하나이면 그 이름이 그대로 적용되지만
	같은 이름이 여러개이면 자동으로 배열 전환 처리(브라우저가 해줌)
	<페이지 이동하는 코드>
	1. location.href 
	2. response.sendRedirect("a.jsp");
	3. view.forward(request, response);
	4. ajax({
		url:"XXX.jsp" or XXX.pj // ActionSupport
	   })
	5. form 태그 사용
*/
	function test(pcb) { //pcb: 파라미터 체크박스
		// 체크에 대한 부분 선택
		console.log(pcb); // pcb는 checkbox에 대한 index값이다. 그래서 0부터이다(배열이므로)
		for(let i=0;i<document.f_test1.cb.length;i++) {
			if(pcb == i) {// 선택 됐을 때
				document.f_test1.cb[i].checked = 1;	
			} else { // 체크 안됐을 때
				document.f_test1.cb[i].checked = 0;	
			}
		}
	}
// 다음문제로 이동하기 - URL이 바뀜 - 기존의 요청이 끊어진다 - 유지의 문제
// 파라미터가 없어도 되는 이유는 hidden이 있기 때문이다
	function next() {
		// 사용자가 선택한 답안정보를 기억(결정)
		// 현재 페이지에 대한 사용자의 선택을 전송하기
		console.log('next');
		let temp = 1;
		for(let i=0;i<document.f_test1.cb.length;i++) {
			if(document.f_test1.cb[i].checked == 1) {
				document.f_test1.htest1.value = temp; // 1이 저장
			} else {
				temp = temp + 1;
			}
		}//////// end of for
		document.f_test1.submit();
	}
</script>
</head>
<body>
<form name="f_test1" method="get" action="q2.jsp">
<input type="hidden" name="htest1">
문제1. 다음 중 DML구문이 아닌 것을 고르시오.<br>
<input type="checkbox" name="cb" onChange="test(0)">select<br>
<input type="checkbox" name="cb" onChange="test(1)">insert<br>
<input type="checkbox" name="cb" onChange="test(2)">create<br>
<input type="checkbox" name="cb" onChange="test(3)">delete<br>
<br>
<input type="button" value="다음문제" onClick="next()">
</form>
</body>
</html>