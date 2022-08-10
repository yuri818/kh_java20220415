package com.mvc.step3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.HashMapBinder;
// 컨트롤 계층을 담당하는 클래스는 서블릿이 아니어도 된다
// 혼자서는 아무것도 완성할 수 없는 나 - 전체적인 틀, 와꾸, 패턴, 기준
// Board3Controller는 Controller3인터페이스의 구현체 클래스이다 - 메소드를 누릴 수 있다
// 서블릿은 아니지만 req, res는 필요함
// req,res는 어디서 가져오지??
// ActionSupport에서 톰캣이 doService()호출할 때 주입 받고
// HandlerMapping 클래스의 메소드 호출할 때 파라미터를 통해 원본을 가져올 수 있다
public class Board3Controller implements Controller3 {
	Logger logger = Logger.getLogger(Board3Controller.class);
	Board3Logic boardLogic = new Board3Logic();
	@Override
	public Object boardUpdate(HttpServletRequest req, HttpServletResponse res) {
		logger.info("boardUpdate 호출 성공");
		// 사용자가 입력한 값을 담기 - Map에 담기 - req.getParameter("name")을 대신해준다
		Map<String,Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.bind(pMap);
		int result = 0;
		result = boardLogic.boardUpdate(pMap); 
		// jsp -> action(update) -> action(select) ---유지(forward)---> boardList.jsp
		// 밑에 방법은 redirect이므로 유지가 되지 않는다
		String path = "redirect:boardList.pj"; // 페이지를 리턴해야함
		// forward로 전송해야 할 때 쓰는 방법!!
		
		return path;
	}
	@Override
	public ModelAndView boardList(HttpServletRequest req, HttpServletResponse res) {
		logger.info("boardList 호출 성공");
		// ModelAndView 객체를 설계함에 따라서 req가 없어도 조회결과를 담을 수 있게 되었다 - 의미
		Map<String,Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.bind(pMap);
		// 생성자 파라미터로 req넘겨주지 않으면 NullPointerException 발생
		ModelAndView mav = new ModelAndView(req);
		List<Map<String,Object>> boardList = null;
		boardList = boardLogic.boardList(pMap);
		mav.addObject("boardList",boardList);
		// req.setAttribute를 대신해서 써줄 수 있다
		mav.setViewName("board3/boardList");
		return mav;
	}
	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res, Map<String, Object> rMap) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}
	// boardList.jsp -> 모달 -> 입력 -> insert처리 -> 목록으로 돌아가기(board3/boardList.pj)
	@Override
	public Object boardInsert(HttpServletRequest req, HttpServletResponse res) {
		logger.info("boardInsert 호출 성공");
		Map<String,Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		// HashMapBinder에서 다 담아주니까
		hmb.bind(pMap);
		int result = 0;
		result = boardLogic.boardInsert(pMap); 
		String path = "redirect:boardList.pj"; // 페이지를 리턴해야함
		return path;
	}
	
	@Override
	public Object boardDetail(HttpServletRequest req, HttpServletResponse res) {
		logger.info("boardDetail 호출 성공");
		Map<String,Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.bind(pMap);
		// ModelAndView 객체를 설계함에 따라서 req가 없어도 조회결과를 담을 수 있게 되었다 - 의미
		ModelAndView mav = new ModelAndView(req);
		List<Map<String,Object>> boardList = null;
		boardList = boardLogic.boardList(pMap);
		mav.addObject("boardList",boardList);
		mav.setViewName("board3/read");
		return mav;
	}
	


}
