package com.day12;

import java.util.Random;
import java.util.Scanner;

public class RandomGame_2 {
	public static void gameStart() {
		//임의의 숫자를 채번하는 메소드를 제공하는 클래스임 - 0.0~1.0
		Random r = new Random();
		//게임이 시작되기 전에 0부터 9사이의 임의의수를 채번하기
		//사용자가 값을 입력하는 것보다 먼저 채번해야 된다.
		int dap = r.nextInt(10); //0이상 10미만 사이의 정수를 리턴해준다.
		//사용자가 (콘솔화면에) 입력한 값을 읽어올 때 - 듣기
		Scanner sc = new Scanner(System.in);
		//안내 메시지 - 유효범위는 0~9
		System.out.println("0부터 9까지의 숫자를 입력하시오. ");
		//사용자가 입력한 값을 담을 변수 선언
		String str = null;
		//str = scan.next();
		//사용자가 입력한 값이 null이 아니면 계속 돌아라 - 반복하라 - 몇번인지는 정해지지 않았다. 
		//- 이걸 정하고 싶을 때 for문을 배우자.
		for(;(str=sc.next()) != null;) {
			//너가 입력한 값이 채번한 값과 같니? 네:맞다, 아닌데:else if
			if(Integer.parseInt(str) == dap) {
				System.out.println("맞다.");
				break;
			}
			//if문 조건에 수렴하지 않으면 아래로 온다.
			else if(Integer.parseInt(str) > dap) { //너무 큰 숫자를 적었네요. 낮춰라 - 힌트문 제공한다. 요구사항 정의서 작성.
				System.out.println("낮춰라");
			}
			else if(Integer.parseInt(str) < dap) {
				System.out.println("높여라");
			}
		}//while ended
		System.out.println("for문 탈출하면 여기가 출력된다.");
	}////////////////////// end of gameStart ///////////////////////////

	public static void main(String[] args) {
		//메소드 호출시 구현된 메소드 앞에 static이 있으면 인스턴스화 없이 클래스타입.메소드명() 으로 호출가능하다.
		RandomGame_2.gameStart();
	}////////////////////// end of main ///////////////////////////

}
