package com.day19;

import java.util.ArrayList;
import java.util.List;
//생성자도 메소드 오버로딩의 컨벤션을 따른다.
//같은 이름의 생성자를 여러개 가질 수 있다.
//클래스 쪼개기 자유자재로 구성할 수 있다. - 생성자의 역할 필수임
//MVC패턴을 적용한 게시판 구현, 프로젝트 구현시 
public class ListTest_1 {
	//다형성 누릴 수 있다. -List는 인터페이스, ArrayList는 구현체 클래스이다.
	//변수 list는 List타입이구요, 구현체 클래스 이름은 ArrayList입니다.
	List<String> list = new ArrayList<>(); //add()메소드를 사용해 맨 뒤에 붙일 수 있다.
	//현재 사이즈 0개
	//인터페이스 이름은 생성부에 올 수 없다.
	//List<String> list2 = new List<>();
	public ListTest_1() {
		System.out.println("디폴트 생성자 호출");
	}
	//생성자를 경유하는 경우와 아닌 경우는
	public ListTest_1(int i) { //생성자 거치면 사이즈가 3이된다.
		System.out.println("파라미터가 int인 생성자 호출");
		list.add("토마토");
		list.add(1,"딸기");
		list.add("수박");
	}
	public static void main(String[] args) {
		ListTest_1 lt1 = new ListTest_1(); //디폴트 생성자 호출
		//문제제기 - 디폴트 생성자에는 ArrayList에 대한 초기화가 없다.
		//인스턴스화만 되어있는 상태와 원소까지도 추가된 상태인지를 구분해야 한다.
		System.out.println(lt1.list.size());
		lt1 = new ListTest_1(3);
		System.out.println(lt1.list.size());
		boolean isSuccess = lt1.list.remove("딸기");
		if(isSuccess) System.out.println("삭제 되었습니다.");
		System.out.println(lt1.list.size());
		System.out.println(lt1.list.get(1)); //인덱스 1인 요소를 반환한다.
		
	}

}
