package com.day17;

import java.util.Scanner;

public class BaseBallGameDemo3 {
	int my[] = new int[3];
	public String account(String input) {
		System.out.println("사용자가 입력한 값 받아오기: " + input);
		//length: 배열의 원소갯수
		//length(): 문자열의 갯수
		if(input.length() != 3) {
			//반복문을 탈출할 떄는 break;
			//조건문을 탈출시는 return
			return "세자리 숫자를 입력하세요.";
		}
		int temp = 0;
		try {
			temp = Integer.parseInt(input);
		} catch (NumberFormatException ex) {
			return "숫자만 입력하세요.";
		}
		my[0] = temp/100; //579/100 = 5.79 => 5-백의자리
		my[1] = (temp%100)/10; //7
		my[2] = temp%10; //57.9 => 9 - 일의자리
		for(int val:my) {
			System.out.println(val);
		}
		return "1스 0볼";
	}
	public static void main(String[] args) {
		BaseBallGameDemo3 bbg = new BaseBallGameDemo3();
		Scanner sc = new Scanner(System.in);
		System.out.println("0부터 9까지 세자리 숫자를 입력하세요.");
		String result = bbg.account(sc.next());
		System.out.println("판정 결과: " + result);
	}
}
