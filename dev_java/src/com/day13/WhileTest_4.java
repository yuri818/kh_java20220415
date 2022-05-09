package com.day13;

public class WhileTest_4 {
	/********************************************
	 * 합을 구하는 메소드 구현
	 * @param i 카운트하는 변수
	 * @param hap 합을 담을 변수
	 ********************************************/
	public int account(int i, int hap) {
		while(i<6) {
			hap += i;
			System.out.println("i: " + i);
			System.out.println("hap: " + hap);
			i++;
		}
		return hap;
	}
	public static void main(String[] args) {
		WhileTest_4 w = new WhileTest_4();
		int i = 0;
		int hap = 0;
		w.account(i, hap);
		System.out.println("1부터 5까지의 합은 "+ hap);
	}

}
