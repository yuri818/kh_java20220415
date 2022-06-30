<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection, java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet, com.util.DBConnectionMgr" %>
<%@ page import="java.util.List, java.util.Map, java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.google.gson.Gson" %>
<%
	String dong = null;
	if( request.getParameter("dong") == null) {
		dong = "역삼";
	} else {
		dong = request.getParameter("dong");
	}
	//스크립틀릿
	DBConnectionMgr 	dbMgr 	= new DBConnectionMgr();
	Connection		 	con 	= null;
	PreparedStatement	pstmt	= null;
	ResultSet 			rs 		= null;
	List<Map<String,Object>> zipList = null;
	

	StringBuilder sql = new StringBuilder();
	sql.append("SELECT address, zipcode           ");
	sql.append("  FROM zipcode_t                  ");
	sql.append(" WHERE dong LIKE '%'|| ? ||'%'    ");
	try {
		con = dbMgr.getConnection();
		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1, dong);
		rs = pstmt.executeQuery();
		zipList = new ArrayList<>();
		Map<String,Object> rmap = null;
		while(rs.next()) {
			rmap = new HashMap<>();
			rmap.put("address", rs.getString("address"));
			rmap.put("zipcode", rs.getString("zipcode"));
			zipList.add(rmap);
		}
		Gson g = new Gson();
		String imsi = g.toJson(zipList);
		out.print(imsi);
	} catch (Exception e) {
		System.out.println("Exception: " + e.toString());
	}
	
	
%>