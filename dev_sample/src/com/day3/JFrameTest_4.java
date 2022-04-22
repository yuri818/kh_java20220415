package com.day3;

import javax.swing.JFrame;

public class JFrameTest_4 {
	//선언부
	JFrame jf = new JFrame();
	int width = 600; //변수 선언
	int height = 400;
	//타입 변수명(네 마음대로... a,b,c...는 되도록 쓰지말자) = 값;
	String name = "이유리";
	public void initDisplay() {
		
		System.out.println("initDisplay 호출 성공");
		
		jf.setSize(width, height); //변수 사용
		jf.setTitle(name);
		jf.setLayout(null);
		
		jf.setVisible(true);
		
		
	}//end of initDisplay
	public static void main(String[] args) {
		JFrameTest_4 jft = new JFrameTest_4();
		jft.initDisplay();
	}
	
}//end of JFrameTest
