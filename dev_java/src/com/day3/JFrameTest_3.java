package com.day3;

import javax.swing.JFrame;

public class JFrameTest_3 {
	//선언부
	JFrame jf = new JFrame();
	int width = 400; //변수 선언
	int height = 300;
	public void initDisplay() {
		System.out.println("initDisplay 호출 성공");
		jf.setSize(width, height); //변수 사용
		jf.setLayout(null);
		jf.setVisible(true);
		jf.setTitle("이유리");
		
	}//end of initDisplay
	public static void main(String[] args) {
		JFrameTest_3 jft = new JFrameTest_3();
		jft.initDisplay();
	}
	
}//end of JFrameTest
