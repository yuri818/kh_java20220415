package com.day15;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//JVM이 자동으로 검색할 수 있는 패키지는 java.lang뿐입니다.
//이것을 제외한 나머지 패키지에 대해서는 반드시 import해주어야 함 
import javax.swing.JButton;
import javax.swing.JFrame;

public class A_3 extends JFrame{
	B_3 b = new B_3(); 

	public void initDisplay() {
		this.setSize(400, 500);
		this.setVisible(true);
	}
	public static void main(String[] args) {
			A_3 a = new A_3(); //타입만 정해졌다.
			a.initDisplay(); // NullPointerException이 발생하면 그 뒤에 어떤 코드도 실행기회를 갖지 못한다.
	}
}
