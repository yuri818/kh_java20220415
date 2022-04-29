package com.day8;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JButtonView {
	//선언부
	JFrame jf = new JFrame();
	JButton jbtn_north = new JButton("조회"); //전역변수 jbtn_north는 다른 클래스에서도 사용할 수 있다.
	//생성자 파라미터에 this는 자기자신을 가리키는 예약어이다.
	//this는 JButtonView 클래스를 가리킨다.
	//그런데 아래 코드에서 컴파일 에러가 발생하는 이유는 파라미터가 JButtonView
	//타입인 생성자가 선언되어 있지 않아서 발생한 오류이다.
	JButtonEventHandler event = new JButtonEventHandler(this); //주소번지를 넘길 수 있다.
	public void initDisplay() {
		System.out.println("initDisplay 호출 성공");
		//이 코드가 있어야 콜백메소드가 호출됨
		//언제? 버튼이 눌려졌을때 - 누르는건 내가
		jbtn_north.addActionListener(event); 
		jf.add("Nouth", jbtn_north); //North 위치에 jbtn_north를 만든다. "South"면 남쪽에 간다.
		jf.setSize(400, 300);
		jf.setVisible(true);
		
	}
	public static void main(String[] args) {
		JButtonView jbt = new JButtonView();
		jbt.initDisplay();
	}

}
