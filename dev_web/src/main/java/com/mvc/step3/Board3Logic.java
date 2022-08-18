package com.mvc.step3;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class Board3Logic {
	Logger logger = Logger.getLogger(Board3Logic.class);
	Board3MDao boardMDao = new Board3MDao();
	Board3SDao boardSDao = new Board3SDao();
	// 상세조회는 따로 처리해주기
	public List<Map<String,Object>> boardDetail(Map<String,Object> pMap){
		logger.info("boardDetail 호출 성공");
		List<Map<String,Object>> boardList = null;
		boardList = boardMDao.boardList(pMap);
		// 상세조회를 한 번 눌러서 조회할 때마다 조회수를 1씩 증가해주세요
		if(boardList!=null && boardList.size()==1) {
			boardMDao.hitCount(pMap);
		}
		return boardList;
	}
	// 전체 조회
	public List<Map<String,Object>> boardList(Map<String,Object> pMap){
		logger.info("boardList 호출 성공");
		List<Map<String,Object>> boardList = null;
		boardList = boardMDao.boardList(pMap);
		return boardList;
	}
	
	public int boardInsert(Map<String, Object> pMap) {
		logger.info("boardInsert 호출 성공");
		int result = 0;
		int b_no = 0;
		int b_group = 0;
		// 글 번호 채번 -> 한번호출
		b_no = boardMDao.getBNo();
		pMap.put("b_no", b_no);
		if(pMap.get("b_group") != null) {
			b_group = Integer.parseInt(pMap.get("b_group").toString());
		}
		//댓글쓰기
		if(b_group > 0) {
			// 아래코드는 내 뒤에 댓글이 있을 때만 처리가 된다
			// 내 뒤에 댓글 있으면 두번째 호출
			boardMDao.bStepUpdate(pMap);
			pMap.put("b_pos", Integer.parseInt(pMap.get("b_pos").toString())+1);
			pMap.put("b_step", Integer.parseInt(pMap.get("b_step").toString())+1);
		}
		//새글쓰기
		else {
			//새글쓰기에서는 댓글쓰기와는 다르게 그룹번호를 새로 채번해야 함
			// 새글일때 그룹번호 호출할 때 세번
			b_group = boardMDao.getBGroup();
			pMap.put("b_group",b_group);
			pMap.put("b_pos", 0);
			pMap.put("b_step", 0);
		}
		result = boardMDao.boardMInsert(pMap); // 새글쓰기와 댓글쓰기를 동시 처리
		// 첨부파일이 있는 경우에만 board_sub_t 추가함
		// 첨부파일이 있는 경우
		if(pMap.get("bs_file")!=null && pMap.get("bs_file").toString().length()>1) {
			pMap.put("b_no", b_no);
			pMap.put("bs_seq", 1);
			int result2 = boardSDao.boardSInsert(pMap);
			logger.info("result2가 1이면 등록 성공====> "+result2);
		}
		return result;
	}

	public int boardUpdate(Map<String, Object> pMap) {
		int result = 0;
		result = boardMDao.boardMUpdate(pMap);
		return result;
	}

	public int boardDelete(Map<String, Object> pMap) {
		int result = 0;
		result = boardMDao.boardMDelete(pMap);
		return result;
	}

}
