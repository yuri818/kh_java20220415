package com.day19;

import java.util.ArrayList;
import java.util.List;
public class ListTest_2 {
	List<String> list = new ArrayList<>();
	
	public void setList() {
		list.add("수박");
		list.add("토마토");
		list.add("사과");
	}
	public void printList() {
		setList();
		//배열처럼 첫번째 인덱스가 0이므로 두번째를 삭제할 경우 1을 준다.
		String ele = list.remove(1);
		boolean isFail = list.remove("사과");
		list.add("바나나");
		boolean isBanana = list.contains("바나나");
//		list.clear(); //이건 전체 요소를 삭제하는 메소드이다.
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		System.out.println("삭제된 요소는: " + ele);
		System.out.println("응답 결과 값 " + isFail);
		System.out.println("바나나가 있어? " + isBanana+", 키위가 있어? "+list.contains("키위"));
		if(isBanana) {
			System.out.println("바나나 있습니다. 드릴까요?");
		}
		list.add(0,"체리");
		System.out.println("0번재 인덱스 값: "+list.get(0));
		boolean check = list.isEmpty();
		System.out.println("비어있니?: " + check);
		list.clear();
		boolean check2 = list.isEmpty();
		System.out.println("비어있니?: " + check2);
	}
	public static void main(String[] args) {
		ListTest_2 lt = new ListTest_2(); //디폴트 생성자 호출
		lt.printList();
	}

}
