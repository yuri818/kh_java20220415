package com.day4;

public class Variable_1 {
	//선언부 - 전역변수(global variable, member variable)
	int age = 20;	//전역변수 age 선언 및 초기화
	//전역 변수는 인스턴스화가 실행되고 나면 그 다음에 heap 메모리 안에 클래스 안에 초기화가 된다.
	void methodA() {
		//실수를 담을 때는 double 타입으로 선언한다.
		//지역변수는 클래스 외부에서는 사용할 수가 없다.
		//전역변수는 클래스 외부에서도 사용할 수 있다.
		age = 30;	//원본을 30으로 오버라이트 한다.
		Variable_1 v1 = new Variable_1();
		System.out.println("methodA에 v1 인스턴스화 한 뒤 age : "+v1.age);
		System.out.println("metnodA의 age :" + age);
	}
	public static void main(String[] args) { //break point
		//인스턴스화 - 메모리 로딩됨, 상주됨
		//인스턴스화를 하면 변수와 메소드를 누릴 수 있다.
		Variable_1 v1 = new Variable_1();
		//메소드를 호출할 땐 ';'를 붙인다.
		//메소드를 구현할 떈 {} 좌중괄호와 우중괄호 영역 표시
		//그 때 그 안에 선언된 변수를 지역변수 라고 한다.
		System.out.println("before : "+v1.age); 
		v1.methodA();
		System.out.println("after : "+v1.age);	
	} //end of main - 북마크를 한다
}
