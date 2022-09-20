package com.mvc.step3;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
// POJO프레임워크가 갖고있는 복잡도에 대해 생각해 보세요
// 새로운 업무가 추가되는 경우 유연하게 조립이 가능한지에 대해 이야기 해보세요
// 뭔가 수정되어지는 부분들이 복잡도가 증가되고 있나? 아니면 코드양만 늘고 있나?
// ActionSupport 클래스와 의존관계가 있나? - 수정해야할 부분이 있나??
// Controller3 인터페이스와 의존관계가 있나? - 불편한점 있나|없나? 어떤 점이 불편한가?
// HandlerMapping클래스와 의존관계가 있나? - 수정해야할 부분이 있나|없나?

import com.util.HashMapBinder;

public class DeptController implements Controller3 {
	Logger logger = Logger.getLogger(DeptController.class);
	private DeptLogic deptLogic = new DeptLogic();
	//@Requestparam은 스프링이 사용자가 입력한 값을 주입해주는 역할을 함
	// 현재는 POJO이므로 사용불가함
	public String deptInsert(HttpServletRequest req, HttpServletResponse res) {
		logger.info("DeptContorller의 deptInsert호출 성공");
		int result = 0; //성공했는지 여부 받아와서 처리
		Map<String,Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.bind(pMap);
		result = deptLogic.deptInsert(pMap);
		return "redirect:deptList.sp";
	}

	// 다 오버라이딩 해주어야하는 불편함 발생
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
	public Object login(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object clogin(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object memberList(HttpServletRequest req, HttpServletResponse res) {
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
	public Object doEmp(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}
}
