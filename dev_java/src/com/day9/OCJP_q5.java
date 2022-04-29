package com.day9;

class Super {
	public int i = 0;

	public Super(String text) {
		i = 1;
	}
}

public class OCJP_q5 extends Super {

	public OCJP_q5(String text) {
		i = 2;
	}

	public static void main(String args[]) {
		OCJP_q5 q5 = new OCJP_q5("Hello");
		System.out.println(q5.i);
	}
}
