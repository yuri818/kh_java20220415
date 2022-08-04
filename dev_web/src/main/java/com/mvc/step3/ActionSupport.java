package com.mvc.step3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.mvc.step2.Board2Controller;
import com.mvc.step2.ModelAndView;
/*
 * <1-3의 다른점!!!!!!!!!>
 * 리턴타입을 String + ModelAndView 추가적으로 지원해 본다
 * CRUD 구현에 필요한 로직을 if문이 아닌 메소드 중심 코딩 전개가 가능하도록 개선해 본다
 * :메소드 안에 req와 res를 지원해야 함 - HttpSession session = req.getSession() : // 세션객체 생성
 * 그러기 위해서는 클래스 설계를 어떻게 가져가야 할까?
 * :board3/boardList.pj와 메소드 이름으로 매칭을 할 수 있어야 한다
 */
public class ActionSupport extends HttpServlet {
	Logger logger = Logger.getLogger(ActionSupport.class);
	private void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("doService 호출 성공");
		String requestURI = req.getRequestURI(); 
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length()+1);
		int end = command.lastIndexOf(".");
		command = command.substring(0,end);
		String upmu[] = null;
		upmu = command.split("/");
		logger.info(upmu[0]+","+upmu[1]);
		// 1-2,3과는 다르게 메소드의 파라미터로 upmu 배열을 전달함
		// req.setAttribute("upmu", upmu); // 필요가 없다 - 왜냐면 파라미터로 전달하니까
		// 업무에 대응하는 컨트롤러 클래스에 대한 인스턴스화는 HandlerMapping클래스에서 하니까...
		// 아래 코드 필요없다
		//Board2Controller boardController = new Board2Controller();
		Object obj = null;
		try {
			obj = HandlerMapping.getController(upmu, req, res);
		} catch (Exception e) {
			logger.info("Exception: "+e.toString());
		}
		// 
		if(obj != null) {
			String pageMove[] = null;
			if(obj instanceof String) {
				if(((String)obj).contains(":")) {
					logger.info(":콜론이 포함되어 있어요");
					// pageMove[0] = redirect or forward - redirect유무 담아주세요
					// pageMove[1] = board2/boardList - 페이지 이름을 담아주세요
					pageMove = obj.toString().split(":");
				} else {
					logger.info(":콜론이 포함되어 있지 않아요");
					pageMove = obj.toString().split("/");
				}
				logger.info("pageMove[0]==> "+pageMove[0]+", pageMove[1]==>"+pageMove[1]);
			}/////////////end of String
			else if(obj instanceof ModelAndView) {
				
			}
			if(pageMove != null) {
				String path = pageMove[1];
				if("redirect".equals(pageMove[0])) { // 너 select가 아니야?
					res.sendRedirect(path);
				} 
				else if("forward".equals(pageMove[0])) { // 난 유지하게 해줄래
					RequestDispatcher view = req.getRequestDispatcher("/"+path+".jsp");
					view.forward(req, res);
				} 
				else { // 나머지.. redirect나 forward문자열이 없는 경우라면?
					path = pageMove[0]+"/"+pageMove[1];
					RequestDispatcher view = 
							req.getRequestDispatcher("/WEB-INF/jsp/"+path+".jsp");
					view.forward(req, res);
				}
			}///////////////end of 출력페이지 호출 URL패턴 조립하기
		}///////////////////end of 컨트롤 계층 리턴 결과
	}
	
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
