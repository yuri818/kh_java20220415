package com.day9;
//변수가 몇개 필요하니? - 3개
//변수 위치는?
public class Shuffle_4 {
	public boolean methodA(int x, int y) {
		int z; //지역변수는 초기화를 반드시 해야한다 했잖아요
		z = x;
		x = y;
		y = z;
		System.out.println("x: " + x + ", y: " + y);
		return true; //셔플이 성공하면 true, 실패하면 false
	}
	public void methodB() {
		System.out.println("methodB 호출 성공");
	}
	public static void main(String[] args) {
		Shuffle_4 s4 = new Shuffle_4();
		boolean isOk = s4.methodA(3, 6);
		if(isOk) {
			System.out.println("참 잘했어요^^");
		}
		s4.methodB();
	}

}
