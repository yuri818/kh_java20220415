package com.mvc.step3;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;

// 생성자는 멤버변수의 초기화 담당
public class MemberDao {
	Logger logger = Logger.getLogger(MemberDao.class);
	// 물리적인 DB서버와 연결
	SqlSessionFactory sqlSessionFactory = null;
	// 쿼리문 요청과 커밋 그리고 롤백 처리
	SqlSession sqlSession = null;

	public MemberDao() {
		// 먼저 초기화 하고 싶을 때
		// 아래 객체(SqlSessionFactory)는 언제 객체주입이 일어날까요? - 생성자에서
		// MemberDao의 메소드를 호출할 때 / MemberLogic에서 호출할때
		// 조회버튼이 눌렸거나 트리에서 회언목록을 선택하면 그때 객체주입이 일어남
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
	}
	
	public List<Map<String,Object>> memberList(Map<String,Object> pMap){
		logger.info("memberList 호출 성공");
		List<Map<String,Object>> memberList = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			memberList = sqlSession.selectList("memberList", pMap);
			logger.info(memberList);
		} catch (Exception e) {
			logger.info("Exception : " + e.toString());
		} finally {
			sqlSession.close();
		}
		return memberList;
	}////////////////////end of memberList
}
