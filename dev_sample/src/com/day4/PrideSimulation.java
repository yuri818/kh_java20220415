package com.day4;

class Pride{
	int speed = 0;
	String carColor = "red";
	public void stop() {
		speed = speed -1;	//speed--;
	}
}

public class PrideSimulation {

	public static void main(String[] args) {
		Pride herCar = new Pride();
		System.out.println(herCar.carColor);
		//0과 70 두 개의 값을 동시에 또는 둘 다 기억할 수 없다. -변수의 장애
		herCar.speed = 70;
		//메소드 호출
		herCar.stop();
		System.out.println(herCar.speed);
	}

}
