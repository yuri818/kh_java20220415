package com.day12;

public class ForTest {

	public static void main(String[] args) {
		int hap = 10;
		for(int i = 0; i < 6; i++) {
			if(i%2 == 0) {
				hap = hap + i;
			}
			System.out.println(i);
		}
		System.out.println("1부터 5까지 짝수의 합은: " + hap);
	} 

}
