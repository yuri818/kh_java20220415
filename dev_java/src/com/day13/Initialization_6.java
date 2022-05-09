package com.day13;
//변수의 초기화ㅡㄴㄴ 언제? 어디에?왜?
//문제 : 1부터 5까지의 합을 구하는 프로그램을 작성하시오.
public class Initialization_6 {
	int count;
	int hap = 0;

	public void account() {
		for (count = 1; count < 101; count++) {
			hap += count;
		}
		System.out.println("after count: " + count);
		System.out.println("after hap: " + hap);
		//만일 이어서 1부터 5까지 다시 세면서 홀수의 합을 구하려고 한다면?
		//초기환느 어디에? 그리고 얼마로?
		count = 1;
		hap = 0;
		for (; count < 101; count++) {
			System.out.println("count: " + count +", hap: " + hap);
			if (count % 2 == 1) {
				hap += count;
			}
		}
		System.out.println("홀수의 합은: " + hap);
	}

	public static void main(String[] args) {
		Initialization_6 i3 = new Initialization_6();
		i3.account();

	}
}
