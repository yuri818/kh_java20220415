<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.util.PageBar" %>    
<%
// jsp에서 자바코드(스크립틀릿)와 html코드의 작성위치는 문제가 되지 않는다.
// 왜냐하면 어차피 jsp는 서버에서 실행되고 그 결과가 text로 출력되는 것이므로
// html과 처리 시점이 완전 다르니까...
	boolean isOk = false;
	if(request.getParameter("isOk")!=null){
		isOk = Boolean.parseBoolean(request.getParameter("isOk"));
	}
	// 유지 -> DB 경유 -> 서블릿
	List<Map<String,Object>> boardList = 
			(List<Map<String,Object>>)request.getAttribute("boardList");
	int size = 0;
	if(boardList!=null){
		size = boardList.size();
	}
	// 한 페이지에 출력될 로우의 수를 담는다
	int numPerPage = 3;
	// 현재 내가 바라보는 페이지 번호 담는 변수
	int nowPage = 0;
	if(request.getParameter("nowPage") != null){
		nowPage = Integer.parseInt(request.getParameter("nowPage"));
	}
%>    
<!DOCTYPE html>
<html>
<head>
<!-- <meta charset="UTF-8"> 이것때문에 한글깨짐.-->
<title>MVC기반의 계층형 게시판 구현하기</title>
<%@ include file="../common/easyui_common.jsp" %>
<script type="text/javascript">
	var g_no=0;//그리드에서 선택이 바뀔때 마다 변경된 값이 저장됨.
	var tb_value;
	let isOk = false;
	function dlgIns_save(){
		//폼 전송 처리함.
	}
	function dlgIns_close(){
		$("#dlg_boardIns").dialog('close');
	}
	function getBoardList(){
		//alert("getBoardList호출");   
		$("dg_board").datagrid({
			url:"jsonBoardList.kh"
		});
	}	
	function boardDetail(bm_no){
	}
    function fileDown(fname){
		//alert(fname);
    }	
</script>
</head>
<body>
<script type="text/javascript">
	var user_combo="bm_title";//제목|내용|작성자
	var v_date;//사용자가 선택한 날짜 정보 담기
//기본 날짜포맷을 재정의
	$.fn.datebox.defaults.formatter = function(date){
		var y = date.getFullYear();
		var m = date.getMonth()+1;
		var d = date.getDate();
		return y+'-'+(m<10? "0"+m:m)+'-'+(d<10? "0"+d:d);
	}
//날짜 포맷을 적용	
	$.fn.datebox.defaults.parser = function(s){
		var t = Date.parse(s);
		if (!isNaN(t)){
			return new Date(t);
		} else {
			return new Date();
		}
	}	
	$(document).ready(function(){//DOM구성이 완료된 시점-자바스크립트로 태그접근,설정변경,이미지
		$("#dg_board").datagrid({

		});
	
		//등록 날짜 정보를 선택했을 때
		$('#db_date').datebox({

		});
		
		//검색 조건 콤보에 변경이 일어났을 때
		$('#cb_search').combobox({

		});

		$('#tb_search').textbox({
			icons: [{
				iconCls:'icon-search',
				handler: function(e){
					alert("검색");
					//$(e.data.target).textbox('setValue', 'Something added!');
					$("#dg_board").datagrid({

					});
				}
			}]
		});

	    $('#linkBtnSearch').bind('click', function(){
	        //alert('easyui');
	        getBoardList();
	    });
	    /*===================== CRUD버튼 시작 ====================*/	    
		//조회버튼 클릭했을 때
	    $('#crudBtnSel').bind('click', function(){
	    	getBoardList();
	    });
		$('#crudBtnIns').bind('click', function(){
	        //alert('입력 버튼');
	        $("#dlg_boardIns").dialog('open');
	    });	
		$('#crudBtnUpd').bind('click', function(){
	        alert('수정 버튼');
	    });	
		$('#crudBtnDel').bind('click', function(){
	        alert('삭제 버튼');
	    });			
	    /*===================== CRUD버튼 끝 ====================*/	    

	});///////////////// end of ready
</script>
<center>
    <table id="dg_board" class="easyui-datagrid" title="계층형 게시판 목록" style="width:800px;height:550px"
            data-options="rownumbers:true,singleSelect:true,toolbar:'#tb',footer:'#pn_board'">
        <thead>
            <tr>
                <th data-options="field:'B_NO',width:60, align:'center', hidden:'true'">글번호</th>
                <th data-options="field:'B_TITLE',width:350">제목</th>
                <th data-options="field:'B_WRITER',width:80,align:'center'">작성자</th>
                <th data-options="field:'B_DATE',width:100,align:'center'">작성일</th>
                <th data-options="field:'BS_FILE',width:170">첨부파일</th>
                <th data-options="field:'B_HIT',width:60,align:'center'">조회수</th>
            </tr>
        </thead>
        <tbody>
<%
	if(size==0){
		if(isOk){	
%> 	
<script>
	$.messager.alert('Info','조회결과가 없습니다.');
</script>
<%
		}
	}
	else if(size>0){
		//for(int i=0;i<size;i++){
		for(int i=nowPage*numPerPage;i<(nowPage*numPerPage)+numPerPage;i++){
			if(size == i) break;
			Map<String,Object> rMap = boardList.get(i);
%>	      
        	<tr>
        		<td><%=rMap.get("B_NO")%></td>
        		<td>
<!-- 너 댓글이니? -->        		
<a href="javascript:boardDetail('<%=rMap.get("B_NO")%>')" style="text-decoration:none;color:#000000">        		
        		<%=rMap.get("B_TITLE")%>
</a>        		
        		</td>
        		<td><%=rMap.get("B_WRITER")%></td>
        		<td><%=rMap.get("B_DATE")%></td>
        		<td>
        		<a href="javascript:fileDown('<%=rMap.get("BS_FILE") %>')">
        		<%=rMap.get("BS_FILE")%>
        		</a>
        		</td>
        		<td><%=rMap.get("B_HIT")%></td>
        	</tr>
<%
		}// end of for
	}// end of else if
%>        	
        </tbody>
    </table>
<!-- 툴바 추가 중 조건검색 화면 시작 -->    
    <div id="tb" style="padding:2px 5px;">
                                    <!-- 
                                    req.getParameter("cb_search"):String
                                    SELECT * FROM board_master_t
                                    WHERE ?(컬럼) LIKE %||?||%
                                     -->
        <select class="easyui-combobox" id="cb_search" name="cb_search" panelHeight="auto" style="width:100px">
            <option selected>선택</option>
            <option value="bm_title">제목</option>
            <option value="bm_content">내용</option>
            <option value="bm_writer">작성자</option>
        </select>
        <input id="tb_search" name="tb_search" class="easyui-textbox" style="width:320px">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                작성일: <input id="db_date" class="easyui-datebox" name="bm_date" style="width:110px">
<!-- 태그내에서 속성(width, align, href)이나  -->   
        <a id="linkBtnSearch" class="easyui-linkbutton" iconCls="icon-search">Search</a>
<!--    <a id="linkBtnSearch" href="javascript:btnSearch()" class="easyui-linkbutton" iconCls="icon-search">Search</a> -->
	<!-- 버튼 추가 화면 시작 --> 
	    <div id="ft" style="padding:2px 5px;">
	        <a id="crudBtnSel" href="javascript:getBoardList()" class="easyui-linkbutton" iconCls="icon-search" plain="true">조회</a>
	        <a id="crudBtnIns" href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true">입력</a>
	        <a id="crudBtnUpd" href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true">수정</a>
	        <a id="crudBtnDel" href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true">삭제</a>
	    </div>
	<!-- 버튼 추가 화면 끝 -->     
    </div>
<!-- 툴바 추가 중 조건검색 화면 끝 -->
   
<!-- 페이지 네이션 추가 시작 -->
	<div style="display:table-cell;vertical-align:middle; width:800px; background:#efefef; height:30; border:1px solid #ccc;">
<%
	String pagePath = "boardList.pj";
	PageBar pb = new PageBar(numPerPage, size, nowPage, pagePath);
	out.print(pb.getPageBar());
%>		
	</div>
	
<!-- 
<script type="text/javascript">
	$('#pn_board').pagination({
		pageList: [5,10,15,20]
	   ,pageSize:5
	   ,layout:['list','sep','first','prev','links','next','last','sep']
	   ,onSelectPage:function(pageNumber, pageSize){
			//alert('pageNumber:'+pageNumber+',pageSize:'+pageSize);
		   pageMove(pageNumber, pageSize);
		}
	});///////////////end of pagination	
</script>	
 -->
<!-- 페이지 네이션 추가   끝  -->
<%
	String gubun = request.getParameter("gubun");
	if("list".equals(gubun)){
%>	
<script type="text/javascript">
		getBoardList();
</script>	
<%		
	}
%>
<!-- 글입력 화면 추가 시작 -->
    <div id="dlg_boardIns" footer="#tb_boardIns" class="easyui-dialog" title="글쓰기" data-options="modal:true,closed:true" style="width:600px;height:400px;padding:10px">
        <form id="f_boardIns" method="post" enctype="multipart/form-data" action="./boardInsert.do">
        <!--<form id="f_boardIns" method="get" action="./boardInsert.do">-->
	    <input type="hidden" id="bm_no" name="bm_no" value="0">
	    <input type="hidden" id="bm_group" name="bm_group" value="0">
	    <input type="hidden" id="bm_pos" name="bm_pos" value="0">
	    <input type="hidden" id="bm_step" name="bm_step" value="0">
        	<table>
        		<tr>
        			<td width="100px">제&nbsp;&nbsp;&nbsp;목</td>
        			<td width="500px"><input id="bm_title" name="bm_title" class="easyui-textbox" data-options="width:'250px'" required></td>
        		</tr>
        		<tr>
        			<td width="100px">작&nbsp;성&nbsp;자</td>
        			<td width="500px"><input id="bm_writer" name="bm_writer" class="easyui-textbox" data-options="width:'150px'" required></td>
        		</tr>
        		<tr>
        			<td width="100px">이&nbsp;메&nbsp;일</td>
        			<td width="500px"><input id="bm_email" name="bm_email" class="easyui-textbox" data-options="width:'150px'" required></td>
        		</tr>
        		<tr>
        			<td width="100px">내&nbsp;&nbsp;&nbsp;용</td>
        			<td width="500px"><input id="bm_content" name="bm_content" class="easyui-textbox" data-options="multiline:'true',width:'350px', height:'90px'" required></td>
        		</tr>
        		<tr>
        			<td width="100px">비&nbsp;&nbsp;&nbsp;번</td>
        			<td width="500px"><input id="bm_pw" name="bm_pw" class="easyui-textbox" data-options="width:'100px'" required></td>
        		</tr>
        		<tr>
        			<td width="100px">첨부파일</td>
        			<td width="500px"><input id="bs_file" name="bs_file" class="easyui-filebox" data-options="width:'350px'"></td>
        		</tr>
        	</table>
        </form>
    </div>
    <!-- 다이얼로그 화면 버튼 추가 시작 -->
	<div id="tb_boardIns">
	<a href="javascript:dlgIns_save()" class="easyui-linkbutton">저장</a>
	<a href="javascript:dlgIns_close()" class="easyui-linkbutton">닫기</a>
	</div>    
    <!-- 다이얼로그 화면 버튼 추가  끝   -->
<!-- 글입력 화면 추가  끝   -->
</center>
</body>
</html>