package com.day14;

import java.awt.FlowLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class Dialog_1 extends JDialog {
	// 디폴트 생성자(파라미터 없는거)는 생략가능함 - JVM - 넌 개발자가 아니잖아? 그런데 왜 가능할까? - 자동으로
	// 언제? -인스턴스화를 했을때 - 어디서?(Main_1의 initDisplay메소드의 20번 라인의 인스턴스화에서.) - 
	//Dialog_1 dialog = null; -선언
	//dialog = new Dialog_1(); -생성 - 메모리에 로딩(loading..) - 생성자호출
	//Dialog_1 dialog = new Dialog_1(); -한번에 선언과 초기화와 생성자호출이 일어남. //10번줄과11번줄
	public void initDisplay() { //화면을 그려주는 메소드 구현이다.(서브창이다- 자녀창이다.)
		this.setTitle("메인 서브창");
		this.setSize(300, 400);
		this.setVisible(true);
	}
}