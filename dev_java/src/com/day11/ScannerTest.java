package com.day11;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열을 입력해주세요: ");
		String str = sc.nextLine();
		System.out.println(str.length() + "글자 입니다.");

		while(!str.equals("exit")) {
			System.out.print("문자열을 입력해주세요:");
			String str1 = sc.nextLine();
			if(str1.equals("exit")) {
				break;
			} else {
				System.out.println(str1.length() + "글자 입니다.");
			}
		}
		System.out.println("프로그램을 종료합니다.");
	}

}
