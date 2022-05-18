package com.day20;

public class StringTest {

	public static void main(String[] args) {
		String s = "이순신";
		s = "Hello World";
		System.out.println(s.length()); //문자열의 길이를 출력한다.
		System.out.println(s.toUpperCase());
		System.out.println(s.toLowerCase());
		System.out.println(s.substring(0, 3));
		System.out.println(s.substring(7, 9));
		s = "java";
		//스트링은 원본이 절대 바뀌지 않아서 s.replace()한다고 해서 바뀌지 않고 
		//대입연산자로 넣어줘야한다. -비효율적이다.
		//StringBuffer, StringBuilder를 권장함.
		s = s.replace('j', 'h'); 
		System.out.println(s); //java or hava
	}

}
