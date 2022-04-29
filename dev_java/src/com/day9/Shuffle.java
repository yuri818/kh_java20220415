package com.day9;
//변수가 몇개 필요하니? - 3개
//변수 위치는?
public class Shuffle {
	//int i;
	//i = 3;        ---->선언부에서는 선언과 초기화를 나누어 작성할 수 없다. 한줄에 해야함
	//int i = 3;  ------>이건 가능함.
	static int x,y,z;
	public static void main(String[] args) {
//		int x = 3;
//		int y = 6;
//		int z = 0;
		x = 3;
		y = 6;
		z = x;
		x = y;
		y = z;
		System.out.println("x: " + x + ", y: " + y);
	}

}
