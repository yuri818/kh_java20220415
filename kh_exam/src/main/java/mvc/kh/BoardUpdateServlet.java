package mvc.kh;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.vo.Board2;

public class BoardUpdateServlet extends HttpServlet {
	Logger logger = Logger.getLogger(BoardUpdateServlet.class);
	BoardService boardService = new BoardService();
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		String id = req.getParameter("id");
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");
		logger.info(title+","+writer+","+content);
		Board2 board2 = new Board2();
		board2.setTbId(Integer.parseInt(id));
		board2.setTbTitle(title);
		board2.setTbContent(content);
		int result = 0;
		result = boardService.updateBoard(board2);
		logger.info("수정처리 결과 ==> "+result);
		if(result == 1) {
			res.sendRedirect("./detail.bo");
		} else {
			req.setAttribute("msg", "게시글 수정 실패");
			RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp");
			view.forward(req, res);
		}
	}
	// post	방식일때는 꼭 한글처리 해줘야 한다
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		String id = req.getParameter("id");
		String title = HangulConversion.toUTF(req.getParameter("title"));
		String writer = HangulConversion.toUTF(req.getParameter("writer"));
		String content = HangulConversion.toUTF(req.getParameter("content"));
		logger.info(title+","+writer+","+content);
		Board2 board2 = new Board2();
		board2.setTbId(Integer.parseInt(id));
		board2.setTbTitle(title);
		board2.setTbContent(content);
		int result = 0;
		result = boardService.updateBoard(board2);
		logger.info("수정처리 결과 ==> "+result);
		if(result == 1) {
			res.sendRedirect("./detail.bo?id="+id);
		} else {
			req.setAttribute("msg", "게시글 수정 실패");
			RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp");
			view.forward(req, res);
		}
	}	
}
