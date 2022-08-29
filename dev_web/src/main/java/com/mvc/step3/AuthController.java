package com.mvc.step3;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.util.HashMapBinder;
// 메소드가 좌중괄호와 우중괄호로 묶여있는 것만으로도 구현한 것과 동일함
public class AuthController implements Controller3 {
	Logger logger = Logger.getLogger(AuthController.class);
	AuthLogic authLogic = new AuthLogic();
	
	@Override
	public Object clogin(HttpServletRequest req, HttpServletResponse res) {
		logger.info("clogin호출 성공");
		Map<String,Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.bind(pMap);
		String s_name = null;
//		HttpSession session = req.getSession();
		s_name = authLogic.login(pMap);
		Cookie c = new Cookie("c_name",s_name);
		c.setPath("/");
		c.setMaxAge(60*3); //3분
		res.addCookie(c);
		String path = "redirect:index.jsp";
		return path;
	}
	
	// upmu[0]=auth, upmu[1]=login
	//http://localhost:8000/auth/login.pj?mem_id=tomato&mem_pw=123
	@Override
	public Object login(HttpServletRequest req, HttpServletResponse res) {
		logger.info("login호출 성공");
		Map<String,Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.bind(pMap);
		String s_name = null;
		HttpSession session = req.getSession();
		s_name = authLogic.login(pMap);
		session.setAttribute("s_name", s_name);
		String path = "redirect:index.jsp";
		return path;
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

	@Override
	public Object boardList(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object boardDetail(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object boardInsert(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object boardUpdate(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object boardDelete(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object memberList(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}


}
