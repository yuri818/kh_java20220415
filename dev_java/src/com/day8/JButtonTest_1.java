package com.day8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
/*
 * 이벤트 처리 순서
 * 1. 해당 콤퍼넌트(독립적인 역할 수행하는 클래스)가 지원하는 이벤트 리스너 선정하기 - ActionListener - 인터페이스 - 추상메소드 - 메소드 오버라이딩
 * 2. 이벤트 소스와 이벤트 처리 핸들러 클래스를 매핑한다.
 * 3. 이벤트 처리를 담당하는 메소드 구현하기
 */
//ActionListener를 implements하는 클래스를 이벤트 처리를 담당하는 이벤트 핸들러 클래스라고 부른다.
//JButtonTest_1은 ActionListener의 구현체 클래스 이다.
//인터페이스는 단독으로 인스턴스화 할 수 없다.
//인터페이스를 메모리에 로딩할 때는 선언부와 생성부의 이름이 다르다.
//자바에서는 같은 이름의 메소드를 중복 선언할 수 있다.
//이것을 가능하게 하는 컨벤션이 메소드 오버라이딩과 메소드 오버로딩이 있다.
public class JButtonTest_1 implements ActionListener{
	//선언부
	JFrame jf = new JFrame();
	JButton jbtn_north = new JButton("조회");
	//생성자
	//생성자에는 리턴타입을 쓰면 안됨
	//생성자 선언할 때 리턴타입을 사용하면 메소드가 된다.
	//생성자가 있어서 전역변수는 초기화를 생략할 수 있는 것이다. - 지역변수는 초기화가 필수
	//생성자도 호출이 되는 건가요?
	public JButtonTest_1() {
		System.out.println("JButtonTest_1 생성자 호출 성공");
	}
	//화면처리부 - 사용자 정의 메소드
	//사용자 정의메소드는 자동으로 실행되지 않는다.
	//콜백메소드 - 시스템에서 자동으로 호출함 - main()
	//static이 붙은 변수는 클래스 급이다. - 클래스처럼 사용된다(주소번지를 의미함)
	
	public void initDisplay() {
		System.out.println("initDisplay 호출 성공");
		//이 코드가 있어야 콜백메소드가 호출됨
		//언제? 버튼이 눌려졌을때 - 누르는건 내가
		jbtn_north.addActionListener(this); //나 자신안에 있는거라서 this. 
		jf.add("North", jbtn_north); //add의 의미는 더하다가 아니고 프레임 위에 버튼을 붙이는 거라고 생각하자.
		jf.setSize(400, 300);
		jf.setVisible(true);
		
	}
	//메인메소드 - exe파일로 만들때만 필요하다
	public static void main(String[] args) {
		//생성부의 이름으로 객체가 만들어진다.
		//메모리에 로딩이 일어난다.
		//인스턴스화를 하면 메소드와 변수를 호출할(부를) 수 있다.
		//변수를 호출하면 값이 나온다. - 원시형 타입
		//변수를 호출하면 주소번지가 나온다. - 참조형 타입
		//인스턴스화에서 생성부는 생성자를 호출해주는 코드이다.
		JButtonTest_1 jbt = new JButtonTest_1();
		jbt.initDisplay();   //메소드 호출
		
	}

	@Override  //얘도 콜백메소드이다. 컴퓨터가 이벤트가 감지되었을 때 호출하는 메소드.
	public void actionPerformed(ActionEvent e) { //이벤트 구현하는 메소드
		//getSource()호출하면 어떤 컴포넌트에 감지가 되었는지 알 수 있다.
		//println메소드는 메소드 오버로딩의 대표적인 예이다.
		//System.out.println(e.getSource());
		Object obj = e.getSource();
		if(obj == jbtn_north) {
			System.out.println("조회 버튼 클릭 성공");
		}
	}

}
