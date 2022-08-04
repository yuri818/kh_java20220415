package com.mvc.step3;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class HandlerMapping {
	static Logger logger = Logger.getLogger(HandlerMapping.class);
	// 왜 Object인가? - 2가지 모드 지원하겠다
	// String : redirect:board2:boardList.jsp
	//  forward: board2/boardList
	//  board2/boardList -> WEB-INF/jsp/path+".jsp"
	//  new ModelAndView();
	/*****************************************************************************
	 * 
	 * @param upmu(upmu[0]=업무폴더이름, upmu[1]=업무기능이름 - 메소드명으로 사용하기!
	 * @param req : 1-2,3에서와는 다르게 Controller 인터페이스를 implements하지 않고 있다
	 * @param res : 그렇다면 req,res를 어디서 전달 받는 걸까?
	 *  HttpServlet을 상속 받아서 톰캣 서버가 제공하는 요청객체와 응답객체를 사용함
	 * @return String or ModelAndView(유지를 위한 req.setAttribute()를 대신하는 클래스)
	 ******************************************************************************/
	public static Object getController(String[] upmu
									   , HttpServletRequest req
									   , HttpServletResponse res) {
		logger.info(upmu[0]+","+upmu[1]);
		Controller3 	 controller 		= null;
		Board3Controller boardController 	= null;
		NoticeController noticeController 	= null; //공지사항 게시판
		Object 			obj 	= null;
		String 			path 	= null;
		ModelAndView 	mav 	= null;
		
		if("board3".equals(upmu[0])) {
			controller = new Board3Controller();
			if("boardList".equals(upmu[1])) {
				// 이걸 메소드 이름으로 쓸거임
				obj = controller.boardList(req, res);
				if(obj instanceof ModelAndView) { // obj가 ModelAndView타입이면 리턴타입 맞추기
					return (ModelAndView)obj;
				} else if(obj instanceof String) { // obj가 String타입이면 리턴타입 맞추기
					return (String)obj;
				}
			}
		}
		return obj;
	}
}
