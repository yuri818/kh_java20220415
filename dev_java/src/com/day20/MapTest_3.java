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
public class MapTest_3 {
	// 제네릭
	Map<String, String> map = new HashMap<>();
	public MapTest_3() {
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
		System.out.println(map.size()); //키값에 대한 원소의 수이다. - 3이 출력될 것임 - 키가 3개이니까.
		//22번에서 정의된 클래스를 사용하므로 제네릭 타입이 변하면 아래에서도 동일하게 바꿔야 함
		for(Map.Entry<String, String> et: map.entrySet()) {
			System.out.println("[key]: "+et.getKey()+", [value]: "+et.getValue());
		}
	}

	public static void main(String[] args) {
		new MapTest_3();
	}

}
