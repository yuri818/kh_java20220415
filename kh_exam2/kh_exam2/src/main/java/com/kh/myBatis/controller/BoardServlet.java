package com.kh.myBatis.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.HashMapBinder;
import com.util.MyBatisCommonFactory;


public class BoardServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(BoardServlet.class);
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		logger.info("doGet 호출 성공");
		SqlSessionFactory sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
		SqlSession sqlSession = null;
		sqlSession = sqlSessionFactory.openSession();
		Map<String,Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.bind(pMap);
		List<Map<String,Object>> boardList = null;
		boardList = sqlSession.selectList("boardList", pMap);
		logger.info(boardList); 
		req.setAttribute("boardList", boardList);
		RequestDispatcher view = req.getRequestDispatcher("/board/boardList.jsp");
		view.forward(req, res);		
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		logger.info("doPost 호출 성공");

	}		

}
