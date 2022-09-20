package com.mvc.step3;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;

// POJO에서는 AOP의 지원이 없으므로 정규식을 이용해서 코드 삽입이 불가하다
// 관여하기도 불가한 상태
public class EmpDao {
	Logger logger = Logger.getLogger(EmpDao.class);
	SqlSessionFactory sqlSessionFactory = null;
	static SqlSession sqlSession = null;
	public EmpDao() {
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
	}
	// 스프링에서 제공하는 SQLException대신 사용하는 클래스
	public int empInsert(Map<String, Object> eMap) {
		logger.info("EmpDao에서의 eMap: "+eMap);
		int result = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.update("empInsert",eMap);
			logger.info("result: "+ result);
		} catch (Exception e) {
			logger.info("Exception : " + e.toString());
		} 
		return result;
	}

}
