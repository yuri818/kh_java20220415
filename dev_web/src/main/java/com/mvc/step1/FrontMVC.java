package com.mvc.step1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
// POJO
// XXX.gym -> 무조건 FrontMVC클래스 인터셉트 하자
public class FrontMVC extends HttpServlet {
	Logger logger = Logger.getLogger(FrontMVC.class);
	// doGet과 doPost로 나누어서 기능 구현하는게 싫대 - 창구를 일원화 한다
	/***********************************************************************
	 *  이런 주석 다는 습관 기르자
	 * @param req
	 * @param res
	 * @throws ServletException
	 * @throws IOException
	 * @ 이유리 - 2021-07-22
	 ************************************************************************/
	public void doService(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException {
		logger.info("doService 호출 성공");
		// 화면 전환 처리
		ActionForward af = null;
		// BoardController는 서블릿으로 설계하지 않았다 - 왜???
		// 앞단에 FrontMVC를 경유하니까..
		// 스프링이 이렇게 하던데.....
		String uri = req.getRequestURI(); // 가져오는 것 : /pay/payList.gym
		logger.info("uri: "+uri);
		String context = req.getContextPath();
		logger.info("context: "+context);
		String command = uri.substring(context.length()+1);
		int end = command.lastIndexOf(".");
		command = command.substring(0,end);
		String upmu[] = null; // upmu[0]=업무이름, upmu[1]=메소드이름과 통일하자
		upmu = command.split("/");
		
		BoardController 	boardController = new BoardController();
//		MemberController 	memberController = new MemberController();
//		PayController 		payController = new PayController();
		// 다 좋은데 BoardController에는 req와 res가 없는데 어떡하지?
		// 메소드의 파라미터 자리는 지변이다.
		// 서블릿 클래스만이 객체주입(게으른...= 필요할때)을 받을 수 있다.
		// 참조에 의한 호출이다 - 전변으로 빼지않고 지변으로 하여 메소드의 파라미터로 넘긴다
		
		// 단위테스트 해보기 - http://localhost:8000/board/boardSelect.gym
		if("board".equals(upmu[0])) {
			req.setAttribute("upmu", upmu);
			af = boardController.execute(req, res);
		}
		
		// 이 부분에 대해 2사람 이상에게 설명해보자
		if(af != null) {
			if(af.isRedirect()) {
				// 상수 싫어요
//				res.sendRedirect("xxx.jsp");
				// 변수 좋아요
				res.sendRedirect(af.getPath()); // 유지가 안됨 - 싱글톤 아님
			} else { // forward - 유지, 주소안변함, 그런데 페이지는 바뀌었다
				// select문이면 무조건 너!
				RequestDispatcher view = req.getRequestDispatcher(af.getPath());
				view.forward(req, res); // 여기서 req는 싱글톤패턴이라 원본임.
			}
		}
	}/////////////end of doService
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException {
		logger.info("doGet 호출 성공");
		doService(req,res);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException {
		logger.info("doPost 호출 성공");
		doService(req,res);
	}
}
