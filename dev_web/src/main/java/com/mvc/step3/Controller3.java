package com.mvc.step3;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 인터페이스는 추상 메소드만 갖는다
// 반드시 구현체 클래스가 필요하다
// 단독으로 인스턴스화 할 수 없다
// 메소드 뒤에 좌중과호 우중괄호가 없다 - 세미콜론으로 끝났다 - 추상메소드
// 명세서이다 - 반드시 구현해 주었으면 해
// 같이 사용할 수 있다 - 통일감
public interface Controller3 {
	// 리턴타입이 ModelAndView 이다
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res, Map<String, Object> rMap);
	public String execute(HttpServletRequest req, HttpServletResponse res);
	// 로그인 추상메소드 선언
	public Object login(HttpServletRequest req, HttpServletResponse res);
	// 쿠키 로그인 추상 메소드 선언
	public Object clogin(HttpServletRequest req, HttpServletResponse res);
	// 회원관리 메소드 시작
	public Object memberList(HttpServletRequest req, HttpServletResponse res);
	// 새로고침 - 조회 - 명세서이다
	public Object boardList(HttpServletRequest req, HttpServletResponse res);
	public Object boardDetail(HttpServletRequest req, HttpServletResponse res);
	public Object boardInsert(HttpServletRequest req, HttpServletResponse res);
	public Object boardUpdate(HttpServletRequest req, HttpServletResponse res);
	public Object boardDelete(HttpServletRequest req, HttpServletResponse res);
}
