package com.day13;
////1부터 100까지 세면서 5의 배수이면 fizz라고 출력하고
//7의 배수이면 buzz라고 출력하고
//5 또는 7로 모두 나누어 떨어지면 fizzbuzz를 출력하고
//나머지는 숫자를 그대로 출력하는 프로그램을 작성해보시오. 

public class FizzBuzzGame {
	public void game() {
		for(int i = 1;i < 101;i++) {
			if(i%5==0 && i%7==0) {
				System.out.print(" fizzbuzz ");
			} else if(i%20==0) {
				System.out.print(" fizz " + "\n");
			} else if (i%7 == 0) {
				System.out.print(" buzz ");
			} else if(i%5==0) {
				System.out.print(" fizz ");
			} else {
				System.out.print(" "+i);
			}
		}
	}
	public static void main(String[] args) {
		FizzBuzzGame fbg = new FizzBuzzGame();
		fbg.game();
	}

}