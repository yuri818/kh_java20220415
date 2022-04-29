package com.day9;

public class P38 {
	//Casting 연산자
	//자동형전환, 강제형전환
	public static void main(String[] args) {
		int i = 10;
		double d = 3.14;
		String s = null;
		boolean isOk = false;
		//캐스팅 연산자는 받아주는 쪽의 타입으로 쓴다.
		//대신 받아주는 쪽의 데이터 범위만 담을 수 있다.
		i = (int)d;
		d = i;
//		s = (String)d;  --타입이 맞지 않아서 에러
//		isOk = (boolean)i; --boolean은 논리형이므로 에러
		System.out.println(i); //
		System.out.println(d); //10
	}

}
