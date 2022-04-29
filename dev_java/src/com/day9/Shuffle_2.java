package com.day9;
//변수가 몇개 필요하니? - 3개
//변수 위치는?
public class Shuffle_2 {
	int x = 21;
	int y = 45;
	int z = 0;
	public Shuffle_2() {
		z = x;
		x = y;
		y = z;
		System.out.println("x: " + x + ", y: " + y);
	}
	public static void main(String[] args) {
		Shuffle_2 s2 = new Shuffle_2();
		
	}

}
