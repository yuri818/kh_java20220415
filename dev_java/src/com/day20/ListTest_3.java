package com.day20;

import java.util.ArrayList;
import java.util.List;

public class ListTest_3 {

	public static void main(String[] args) {
		List nameList = new ArrayList();
		nameList.add("나신입");
		System.out.println(nameList.size()); // 0->1
		String name = (String) nameList.get(0);
		System.out.println(name); //나신입
		//제네릭을 추가한 인스턴스화의 경우 타입체크 필요없음
		List<String> nameList2 = new ArrayList<>();
		nameList2.add("나초보");
		//제네릭에서 String타입을 명시하였으므로 캐스팅 연산자가 필요없다.
//		String name2 = nameList2.get(0);
		//insert here
		nameList2.add("이유리");
		System.out.println(nameList2.size()); //0->2
		String name2 = nameList2.get(1);
		System.out.println(name2);
		
		
	}

}
