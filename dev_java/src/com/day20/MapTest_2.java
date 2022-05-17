package com.day20;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * 회원가입
 * 아이디 : 입력하세요
 * <input type="text" name="member_id">
 * 비번  : 입력하세요
 * <input type="text" name="member_pw">
 * 이름  : 입력하세요
 * <input type="text" name="member_name">
 * 이메일 : 입력하세요
 * <input type="text" name="member_email">
 * 
 * 
 */
public class MapTest_2 {
	// 제네릭
	Map<String, Object> map = new HashMap<>();
	public MapTest_2() {
		//printMap();
		// Map계열은 값을 담을 때 put 메소드를 사용한다.
		// 파라미터 두개가 필요한데 첫번째는 키값이고 두번째느 값이다.
		map.put("mem_id", "scott"); // 아이디
		map.put("mem_pw", "tiger");//비번
		map.put("mem_name", "나신입");//이름
		//선언이 먼저 호출이 나중
		printMap();// 출력을 담당하는 메소드 호출하기
	}

	public void printMap() {
		for(Map.Entry<String, Object> et: map.entrySet()) {
			System.out.println("[key]: "+et.getKey()+", [value]: "+et.getValue());
		}
	}

	public static void main(String[] args) {
		new MapTest_2();
	}

}
