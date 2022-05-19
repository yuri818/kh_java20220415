package com.day21;
//자바+스프링(객체주입, 의존성 주입, 제어역전)
import com.day16.MallardDuck;

public class DuckTest {
	MallardDuck myDuck = null;
	//메소드를 통해서 객체를 주입 받을 수 있다.
	MallardDuck getInstance() {
		//중급으로 가는 길 - 싱글톤 패턴 검색 - 공유 - 복제본을 만들지 않고 원본만 공유하고 싶을때 사용 
		if(myDuck == null) {
			myDuck = new MallardDuck();
		}
		return myDuck;
	}
	void test() {
		getInstance().display(); //11번을 경유하지않아 NullPointerException발생함.
	}
	public static void main(String[] args) {
		//insert here
		DuckTest dt = new DuckTest();
		dt.test();
		
	}

}
