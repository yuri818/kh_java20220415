package com.mvc.step3;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import com.util.MyBatisCommonFactory;

public class DeptDao {
	Logger logger = Logger.getLogger(DeptDao.class);
	SqlSessionFactory sqlSessionFactory = null;
	static SqlSession sqlSession = null;
	public DeptDao() {
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
	}

	public int deptInsert(Map<String, Object> pMap) {
		logger.info("DeptDao에서의 pMap: "+pMap);
		int result = 0;
		try {
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.update("deptInsert",pMap);
			//sqlSession.commit(); - 로직에서 처리해줘!
			logger.info("result: "+ result);
		} catch (Exception e) {
			logger.info("Exception : " + e.toString());
		} finally {
			sqlSession.close();
		}
		return result;
	}
}
