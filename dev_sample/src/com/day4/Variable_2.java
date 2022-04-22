package com.day4;

public class Variable_2 {
	int age = 20;
	//메소드 파라미터로 50이 복사되어 저장됨
	void methodA(int age) {  //50복사됨 - 메소드 파라미터 자리에 선언된 변수도 지역변수이다.
		age = 30;
	}
	public static void main(String[] args) {
		Variable_2 v1 = new Variable_2();
		System.out.println("before : "+v1.age);
		v1.methodA(50); //메소드가 호출할때 값이 결정됨
		System.out.println("after : "+v1.age);		
	}
}
