package com.mvc.step3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/*
 * <1-3의 다른점!!!!!!!!!>
 * 리턴타입을 String + ModelAndView 추가적으로 지원해 본다
 * CRUD 구현에 필요한 로직을 if문이 아닌 메소드 중심 코딩 전개가 가능하도록 개선해 본다
 * :메소드 안에 req와 res를 지원해야 함 - HttpSession session = req.getSession() : // 세션객체 생성
 * 그러기 위해서는 클래스 설계를 어떻게 가져가야 할까?
 * :board3/boardList.pj와 메소드 이름으로 매칭을 할 수 있어야 한다
 * 
 * 이 클래스는 FrontController이다. - 사용자의 요청을 받아주는 역할
 * request객체와 response객체를 톰캣에서 주입 받는 역할
 * LiveServer 내안에는 servlet-api.jar와 jsp-api.jar가 없다
 * 요청객체로 할 수 있는 것: request.getParameter("name"); //듣기(read)
 * PrintWriter out = req.getWriter(); // document.write("");와 같은 역할임
 * 페이지 처리
 * 페이지 이동
 * response.sendRedirect("");
 * response.setContentType("text/html;utf-8");
 * 브라우저가 보고 처리한다
 * scope의 하나이다. - request.setAttribute("이름",값) - 유지의 문제
 * request.getRequestDispatcher("XXX.jsp").forward(req, res);
 * session.setAttribute("이름",값);
 * HttpSession session = request.getSession(); 세션객체를 생성할 때도 request가 필요하다
 * 
 */
// 서블릿을 상속받음
public class ActionSupport extends HttpServlet {
	Logger logger = Logger.getLogger(ActionSupport.class);
	private void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("doService 호출 성공");
		String requestURI = req.getRequestURI(); //-> /board2/boardApp.kh?crud=select
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length()+1);
		int end = command.lastIndexOf(".");
		command = command.substring(0,end);
		String upmu[] = null;
		upmu = command.split("/"); // 업무폴더이름/업무이름.pj
		logger.info(upmu[0]+","+upmu[1]);
		// 1-2,3과는 다르게 메소드의 파라미터로 upmu 배열을 전달함
		// req.setAttribute("upmu", upmu); // 필요가 없다 - 왜냐면 파라미터로 전달하니까
		// 업무에 대응하는 컨트롤러 클래스에 대한 인스턴스화는 HandlerMapping클래스에서 하니까...
		// 아래 코드 필요없다
		//Board2Controller boardController = new Board2Controller();
		Object obj = null;
		try {
			// 이 요청을 어떤 컨트롤러 클래스가 담당하나요?
			// MemberController or OrderController or PriceController or GoodsController
			// Board3Controller가 서블릿이 아니더라도 req와 res를 사용할 수 있는 것은
			// HandlerMapping클래스에 getController메소드의 파라미터로 전달되기 때문에 가능함
			obj = HandlerMapping.getController(upmu, req, res);
		} catch (Exception e) {
			logger.info("Exception: "+e.toString());
		}
		// 
		if(obj != null) {
			String pageMove[] = null;
			ModelAndView mav = null;
			
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
			// Model과 View의 혼합이 ModelAndView이다(화면과 데이터가 함께이다)
			// Model : 내 안에 List
			else if(obj instanceof ModelAndView) {
				mav = (ModelAndView)obj;
				pageMove = new String[2];
				pageMove[0] = "forward";
				pageMove[1] = mav.getViewName();
				logger.info("pageMove[0]==> "+pageMove[0]+", pageMove[1]==>"+pageMove[1]);
				
			}
			// 이 부분이 재사용성이 떨어져서 개선할 것..
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
	// 403 or 405에러가 있으면 여기를 확인하자!
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
