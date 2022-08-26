<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>인증처리 - 쿠키와 세션</title>
    <%@ include file="../common/easyui_common.jsp" %>
    <script type="text/javascript">
    	function login() {
    		const tb_id = $("#tb_id").val();
    		const tb_pw = $("#tb_pw").val();
    		location.href = "./login.pj?mem_id="+tb_id+"&mem_pw="+tb_pw;
    	}
    	function logout() {
    		location.href="./logout.jsp";
    	}
    </script>
</head>
<body>
<script>
	// DOM트리가 다 그려졌다면 -> function을 실행해주세요
	// 만약에 ready를 쓰지 않겠다면 input태그의 id="tb"뒤에 스크립트 적어주면 위치문제 해결
	$(document).ready(function(){
		$('#tb_id').textbox({
		    iconCls:'icon-man',
		    iconAlign:'right'
		});
		$('#tb_pw').passwordbox({
	        prompt: 'Password',
	        showEye: true
	    });
	});
</script>
    <h2>인증처리</h2>
    <p>쿠키 혹은 세션을 이용하여 유지하기</p>
    <div style="margin:20px 0;"></div>
    <div class="easyui-layout" style="width:1000px;height:500px;">
        <div data-options="region:'north'" style="height:50px"></div>
        <div data-options="region:'south',split:true" style="height:50px;"></div>
        <div data-options="region:'west',split:true" title="KH정보교육원" style="width:200px;">
<!-- 로그인을 했을 경우 -->
<%
	String s_name = (String)session.getAttribute("s_name");
	//s_name = "이유리";
	if(s_name != null) {
%>        	
<%= s_name %>님 환영합니다.
<a id="btn" href="javascript:logout()" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">로그아웃</a>
<!-- 로그인을 하지 않았을 경우 -->
<%
	} else {
%>        	
			<table>
				<tr>
					<td>
						<!-- 여기 id가 진짜 id가 아님! 개발자도구에서 확인해보자 -->
			        	<input id="tb_id" type="text" style="width:60%">
					</td>
					<td rowspan="2">
<a id="btn" href="javascript:login()" class="easyui-linkbutton" style="width:60px; height:60px">로그인</a>
					</td>
				</tr>
				<tr>
					<td>
		    	    	<input id="tb_pw" type="text" style="width:60%">
					</td>
				</tr>
			</table>
<%
	}//////////end of else
%>
        </div>
        <div data-options="region:'center',title:'Main Title',iconCls:'icon-ok'">
            <table class="easyui-datagrid"
                    data-options="url:'datagrid_data1.json',method:'get',border:false,singleSelect:true,fit:true,fitColumns:true">
                <thead>
                    <tr>
                        <th data-options="field:'itemid'" width="80">Item ID</th>
                        <th data-options="field:'productid'" width="100">Product ID</th>
                        <th data-options="field:'listprice',align:'right'" width="80">List Price</th>
                        <th data-options="field:'unitcost',align:'right'" width="80">Unit Cost</th>
                        <th data-options="field:'attr1'" width="150">Attribute</th>
                        <th data-options="field:'status',align:'center'" width="60">Status</th>
                    </tr>
                </thead>
            </table>
        </div>
    </div>
 
</body>
</html>