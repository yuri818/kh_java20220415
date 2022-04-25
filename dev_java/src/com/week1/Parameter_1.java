package com.week1;

class Dog{
	int leg = 0; //전역변수 -> 재사용성  (초기화 생략 가능)
}
public class Parameter_1 { //사용자 정의 메소드
	static void methodA(Dog myDog) {
		System.out.println(myDog.leg);
		myDog.leg = 2;  //초기화
	}
	public static void main(String[] args) { //메인 메소드
		Dog myDog = new Dog(); //인스턴스화
		myDog.leg = 4;
		methodA(myDog); //methodA라는 메소드를 경유한다. 값이 다시 초기화된다.
		System.out.println(myDog.leg);
	}

}
