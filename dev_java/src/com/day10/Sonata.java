package com.day10;

public class Sonata {
	//너는 지금 몇 km로 달리고 있니?
	int speed; //0
	// 자동차마다 대표 색상이 있다.
	String carColor; //null
	//4
	int wheelNum; //0 , if double --> 0.0
	public Sonata() {}
	public Sonata(String carColor) {
		System.out.println(carColor);
		// 변수 이름 앞에 this를 붙이면 자기자신을 가리키는 수정자임
		//그래서 전변이 되는 것임.
		//this가 있을때와 없을 때의 차이를 말할 수 있는 우리가 됩시다.
		this.carColor = "검정색"; //carColor는 지변 //this.carColor는 전역변수를 바꾸는것.
		System.out.println(carColor);
	}
	public Sonata(int speed, String carColor, int wheelNum) {
		this.speed = speed;
		this.carColor = carColor;
		this.wheelNum = wheelNum;
	}
	@Override
	public String toString() { //메소드 오버라이딩
		return "내 자동차는 현재 " + speed + "로 달리고 있고, 바퀴수는 " + wheelNum + "이고, 자동차 색상은 " + carColor + " 입니다.";
	}

}
