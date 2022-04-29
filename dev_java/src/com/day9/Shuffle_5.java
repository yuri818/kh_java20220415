package com.day9;
//변수가 몇개 필요하니? - 3개
//변수 위치는?
public class Shuffle_5 {
	int x=3;
	int y=6;
	public boolean methodA() {
		boolean isOk = false;
//		int z; //지역변수는 초기화를 반드시 해야한다 했잖아요
//		z = x;
		x = y;
		y = x;
		System.out.println("x: " + x + ", y: " + y);
		if(x != 3 && y != 6) {
			isOk = true;
		}
		return isOk; //셔플이 성공하면 true, 실패하면 false
	}
	public void methodB() {}
	public static void main(String[] args) {
		Shuffle_5 s5 = new Shuffle_5();
		boolean isOk = s5.methodA();
		if(isOk) {
			System.out.println("참 잘했어요^^");
		} else {
			System.out.println("다시 한 번 생각해보세요.");
		}
		s5.methodB();
		
	}

}
