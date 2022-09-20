package com.util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class MyBatisCommonFactory {
	static Logger logger = Logger.getLogger(MyBatisCommonFactory.class);
	public static SqlSessionFactory sqlSessionFactory = null;
	//SqlSessionFactory객체를 생성해 주는 메소드 입니다.- 싱글톤 패턴 적용
	//메소드를 통한 객체 주입 코드(디자인패턴적용, 싱글톤, 의존성주입, 제어역행, 개발방법론(MVC, MVP, MVVM)
	//인스턴스화 5가지 유형
	public static void init() {
		try {
			String resource = "com/mybatis/mybatis-config.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			logger.info("before sqlSessionFactory : "+sqlSessionFactory);
			if(sqlSessionFactory == null) {// 널이 아닐때만 객체 주입을 새로 받는다
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader,"development");
			}
			logger.info("after sqlSessionFactory : "+sqlSessionFactory);
		} catch (Exception e) {
			logger.info("[[ Exception ]] "+e.toString());
		}
	}// end of init
	//getter 
	public static SqlSessionFactory getSqlSessionFactory() {
		init();
		return sqlSessionFactory;
	}

}
