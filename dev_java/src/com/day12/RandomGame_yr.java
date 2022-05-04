package com.day12;

import java.util.Random;
import java.util.Scanner;

public class RandomGame_yr {
	public void gameStart() {
		//임의의 숫자를 채번하는 메소드를 제공하는 클래스임 - 0.0~1.0
		Random r = new Random();
		int dap = r.nextInt(10); //0이상 10미만 사이의 정수를 리턴해준다.
		//사용자가 (콘솔화면에) 입력한 값을 읽어올 때 -듣기
		Scanner sc = new Scanner(System.in);
		//안내 메시지 - 유효범위는 0~9 사이이다.
		System.out.println("0부터 9까지의 숫자를 입력하시오. ");
		int i = sc.nextInt();
		for(i = 0; i<10;i++) {
			if(i == dap) {
				System.out.println("맞다");
				break;
			} else if(i>dap) {
				System.out.println("낮춰라");
			}else if(i<dap) {
				System.out.println("높여라");
			}
		}
//		while(i != 0) {
//			if(i == dap) {
//				System.out.println("맞다.");
//				break;
//			}
//			else if(i > dap) {
//				System.out.println("낮춰라");
//			}
//			else if(i < dap) {
//				System.out.println("높여라");
//			}
//		}//while ended
	}////////////////////// end of gameStart ///////////////////////////

	public static void main(String[] args) {
		RandomGame_yr rgy = new RandomGame_yr();
		rgy.gameStart();
	}////////////////////// end of main ///////////////////////////

}
