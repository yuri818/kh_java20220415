package com.day11;

import java.util.Scanner;

public class Test {
	
	public void count() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("문자열을 입력:" );
		String str = sc.nextLine();
		System.out.println(str.length() + "글자이다");
		do {System.out.println("문자열을 입력:");
			String str1 = sc.nextLine();
			if(str1.equals("exit")) {
				break;
			} else {
				System.out.println(str1.length() + "글자이다");
			}
		}
		while(!str.equals("exit"));
			
			
		
		System.out.println("프로그램 종료");
		
	}
}
