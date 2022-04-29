package com.day8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonEventHandler implements ActionListener {
	//선언부 - 여기에 선언시 전역변수의 성격
	JButtonView jButtonView = null;
	public JButtonEventHandler(JButtonView jButtonView) { //변수이름은 전체 클래스 이름과 동일하지만 변수이므로 앞글자만 소문자
		this.jButtonView = jButtonView; //이 줄이 없으면 null이고 얘가 있어야 원본을 가리킴
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource(); //코드의 직관성과 재사용성을 위해
		
		if(obj == jButtonView.jbtn_north) {
			System.out.println("조회 버튼 클릭 성공");
		}
	}
}
