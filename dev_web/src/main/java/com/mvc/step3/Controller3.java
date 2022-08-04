package com.mvc.step3;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 인터페이스는 추상 메소드만 갖는다
// 반드시 구현체 클래스가 필요하다
// 단독으로 인스턴스화 할 수 없다
public interface Controller3 {
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res, Map<String, Object> rMap);
	public String execute(HttpServletRequest req, HttpServletResponse res);
	public Object boardList(HttpServletRequest req, HttpServletResponse res);
}
