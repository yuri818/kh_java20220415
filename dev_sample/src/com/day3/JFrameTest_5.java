package com.day3;

import javax.swing.JFrame;

public class JFrameTest_5 {
	//선언부
	JFrame jf = new JFrame();
	int width = 600; //변수 선언
	int height = 400;
	String name = "이유리";
	public void initDisplay() {
		System.out.println("initDisplay 호출 성공");
		jf.setSize(width, height); //변수 사용
		jf.setTitle(name); //이유리 출력
		jf.setVisible(true);
		
	}//end of initDisplay
	//javac JFrameTest_5.java -> 컴파일- Ctrl+s
	//java JFrameTest_5 "홍길동" "강감찬" "이순신"  //을 치면 배열에 다 담을 수 있다.
	public static void main(String[] args) {
		JFrameTest_5 jft = new JFrameTest_5();
		jft.initDisplay();
		for(int i = 0; i < 3; i = i + 1) { //i=0, i=1, i=2
			System.out.println(args[i]);
		}
	}
	
}//end of JFrameTest

/*	변수의 단점(장애):
	-한 번에 하나만 담을 수 있다.
	-같은 타입만 담을 수 있다.
	-타입이 갖고 있는 크기만큼만 담을 수 있다.
	
	-배열을 사용하면 한 번에 여러개를 담을 수 있다.
	
	변수 - 배열 - 객체 배열 - List or Map 자료구조(시간을 지배할 수 없다) - 쿠키와 세션(시간까지 제어)
	
	
*/










