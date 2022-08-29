package com.mvc.step3;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class MemberLogic {
	Logger logger = Logger.getLogger(MemberLogic.class);
	MemberDao memberDao = new MemberDao();
	
	public List<Map<String, Object>> memberList(Map<String, Object> pMap) {
		logger.info("memberList 호출 성공");
		List<Map<String,Object>> memberList = null;
		memberList = memberDao.memberList(pMap);
		return memberList;
	}

}
