package com.day19;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
//Map에서 키는 순서가 없다 - 그래서 빠르다.
public class MapTest_1 { //<키,value>
	//<>를 제네릭이라 한다.
	Map<String,Object> map = new HashMap<>();
	public MapTest_1() { 
		//Map계열은 값을 담을 때 put 메소드를 사용한다.
		//파라미터 두개가 필요한데 첫번째는 키값이고 두번째느 값이다.
		map.put("mem_id", "scott"); //데이터를 담을 때는 put을 쓴다.
		map.put("mem_pw", "tiger");
		map.put("mem_name", "이유리");
		printMap();//출력을 담당하는 메소드 호출하기
	}
	public void printMap() {
		//키값만을 추출할 때 사용한다.
		Set<String> set = map.keySet();
		//키값이 세가지(mem_id, mem_pw, mem_name) 이니까 배열에 담을 수 있다
		//프론트엔드 개발자 - 배열 집중 --3차배열은 제외, 다차원 배열 제외
		Object obj[] = set.toArray(); //obj배열에는 키값이 들어있다.
		for(int i=0; i<obj.length;i++) {
			//캐스팅연산자 사용할 때는 받아주는 쪽의 타입을 적는 것이다.
			String key = (String)obj[i]; //타입을 맞추자
			System.out.println(key+", "+map.get(key));
		}
	}
	public static void main(String[] args) {
		new MapTest_1(); //변수선언 없어도 괜찮다 - 재사용할게 아니라면...
		
	}

}
