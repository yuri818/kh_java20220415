package com.day13;

import java.util.Random;
import java.util.Scanner;

public class RandomGame_V2 {
	//컴터가 채번하는 일을 전담하는 메소드 구현
	public void randomNumber() {
		Random r = new Random();
		int dap = r.nextInt(10);
	}
	//사용자가 입력하는 값을 받아서 판정하는 메소드에 전달하기 구현
	public void userInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("0부터 9까지의 숫자를 입력하시오. " + sc.next());		
	}
	public void gameStart() {
//		str = sc.next();
		for(int cnt = 5;cnt > 0;) {
			if(Integer.parseInt(str) == dap) {
				System.out.println("맞다.");
				break;
			}
			else if(Integer.parseInt(str) > dap) { 
				System.out.println("낮춰라");
				cnt--;
				System.out.println("남은 기회는: " + cnt);
			}
			else if(Integer.parseInt(str) < dap) {
				System.out.println("높여라");
				cnt--;
				System.out.println("남은 기회는: " + cnt);
			}
			if(cnt==0) {
				System.out.println("더이상 기회는 없습니다.");
				break;
			}
		}
		System.out.println("게임이 종료되었습니다.");
	}
	public static void main(String[] args) {
		RandomGame_V2 rv2 = new RandomGame_V2();
		rv2.gameStart();
	}
}
