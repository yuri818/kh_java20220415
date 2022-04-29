package com.day9;

public class Car {
	int wheelNum = 0;
	public void stop() {
		
	}
}

class Sonata extends Car{ //Car를 상속받는다
	@Override //원본은 고치지 않고 재정의할때 사용한다.
	public void stop() {
		
	}
	//메소드 오버로딩 규칙을 준수했으니까 합법.
	public int stop(double i) {
		return 0;
	}
	/*
	 * public double stop(double i) { return 0.0; }
	 */
}