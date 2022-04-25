package com.day4;

public class Variable_3 {
	int age = 20;
	//메소드의 파라미터 자리도 지역변수 자리이다.
	//값은 호출할 때 결정됨
	void methodA(int age) {
		//methodA를 벗어나면 자동 소멸됨
		System.out.println("지역변수 ===> " + age); //50 - automatic  자동 소멸(언제?-methodA를 벗어나면
		age = 30;
		System.out.println("methodA : "+ this.age); ///20 
	}
	public static void main(String[] args) {
		Variable_3 v1 = new Variable_3();
		System.out.println("before : "+v1.age);
		v1.methodA(50);
		System.out.println("after : "+v1.age);		
	}
}
