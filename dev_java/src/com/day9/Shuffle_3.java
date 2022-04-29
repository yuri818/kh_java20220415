package com.day9;
//변수가 몇개 필요하니? - 3개
//변수 위치는?
public class Shuffle_3 {
	static int x = 210;
	static int y = 455;
	static int z = 0;
	
	public static void main(String[] args) {
		z = x;
		x = y;
		y = z;
		System.out.println("x: " + x + ", y: " + y);
	}

}
