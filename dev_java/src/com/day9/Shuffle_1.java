package com.day9;
//변수가 몇개 필요하니? - 3개
//변수 위치는?
public class Shuffle_1 {
	int x = 2;
	int y = 4;
	int z = 0;
	
	public static void main(String[] args) {
		Shuffle_1 s1 = new Shuffle_1();
		s1.z = s1.x;
		s1.x = s1.y;
		s1.y = s1.z;
		System.out.println("x: " + s1.x + ", y: " + s1.y);
	}

}
