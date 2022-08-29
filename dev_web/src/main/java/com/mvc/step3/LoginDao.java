package com.mvc.step3;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

public class LoginDao {
	Logger logger = Logger.getLogger(AuthDao.class);
	// 물리적인 DB서버와 연결
	SqlSessionFactory sqlSessionFactory = null;
	// 쿼리문 요청과 커밋 그리고 롤백 처리
	SqlSession sqlSession = null;
	
	public String login(Map<String, Object> pMap) {
		logger.info("login 호출 성공: " + pMap);
		String s_name = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			s_name = sqlSession.selectOne("login", pMap);
			logger.info(s_name);
		} catch (Exception e) {
			logger.info("Exception : " + e.toString());
		} finally {
			sqlSession.close();
		}
		return s_name;
	}

}
