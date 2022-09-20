package com.mvc.step3;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class EmpLogic {
	Logger logger = Logger.getLogger(EmpLogic.class);
	private DeptDao deptDao = new DeptDao();
	private EmpDao empDao = new EmpDao();
	//@Transactional(propagation=Propagation.REQUIRES_NEW, rollbackFor= {DataAccessException.class})
//	public int doEmp() { // do 면한번에 커밋 하시요
	public int cudEmp() { // go 면 건건이 커밋해라
		logger.info("doEmp 호출");
		int empResult = 0;
		int deptResult = 0;
		Map<String,Object> eMap = new HashMap<>();
		eMap.put("empno", 9005);
		eMap.put("ename", "이유리");
		eMap.put("deptno", 89);
		Map<String,Object> dMap = new HashMap<>();
		dMap.put("deptno",89);
		dMap.put("dname", "개발부");
		dMap.put("loc", "부산");
		deptResult = deptDao.deptInsert(dMap);
		empResult = empDao.empInsert(eMap);
		if(deptResult == 1 && empResult == 1) {
			EmpDao.sqlSession.commit();
		} else {
			EmpDao.sqlSession.rollback();
		}
		return 0;
	}

}
