<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.google.gson.*" %>    
<%
	// 얘가 하는 역할은 데이터셋 - 문자열
	String mem_tel = request.getParameter("mem_tel"); // 듣기 - 기억해줘
	//out.print("주문자 전화번호: "+mem_tel);
	List<Map<String,String>> cusList = new ArrayList<>();
    Map<String,String> rMap = new HashMap<>();
    rMap.put("mem_name","김유신");
    rMap.put("mem_addr","서울시 마포구 공덕동");
    rMap.put("mem_tel","0255556666");
    cusList.add(rMap);
    rMap = new HashMap<>();
    rMap.put("mem_name","김춘추");
    rMap.put("mem_addr","서울시 금천구 가산동");
    rMap.put("mem_tel","0277776666");
    cusList.add(rMap);
    rMap = new HashMap<>();
    rMap.put("mem_name","이성계");
    rMap.put("mem_addr","서울시 영등포구 당산동");
    rMap.put("mem_tel","0277778888");
    cusList.add(rMap);
    rMap = new HashMap<>();
    rMap.put("mem_name","이유리");
    rMap.put("mem_addr","서울시 송파구 잠실동");
    rMap.put("mem_tel","01012341234");
    cusList.add(rMap);
    String address = "";
    for(int i=0;i<cusList.size();i++){
    	Map<String,String> rmap = cusList.get(i);
    	// mem_tel을 equal로 비교하려고 -주소번지가 가리키는 값(참조형)
    	if(rmap.get("mem_tel").equals(mem_tel)){
    		address = rmap.get("mem_addr");
    	}
    }
    // 이것이 출력하는 값은 문자열 타입이다
    // 확장자가 jsp - 처리주체가 서버(톰캣)이다
    // jsp안에서는 자바문법을 쓸 수 있다 - 검색은 알고리즘이라 모델계층 - html 태그들 필요없다
    // mime타입 : 메인타입/서브타입
    out.print(address);
    
    //Gson g = new Gson();
    //String result = g.toJson(cusList);
    //out.clear();
    //out.print(result);
%>