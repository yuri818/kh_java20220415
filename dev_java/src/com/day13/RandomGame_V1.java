package com.day13;

import java.util.Random;
import java.util.Scanner;

public class RandomGame_V1 {

	public void gameStart() {
		//게임 유저들에게 회차 정보를 제공하세요 - 요구사항
		//회차를 카운트 해야 하는 경우는 언제일까요?
		//정답을 맞추었을 때 - 종료
		//높여라 라는 힌트를 주거나 낮춰라 라는 힌트를 준다면 기회를 한 번 잃어버린다.
//		int cnt = 5;
		Random r = new Random();
		int dap = r.nextInt(10); 
		Scanner sc = new Scanner(System.in);
		System.out.println("0부터 9까지의 숫자를 입력하시오. ");
		String str = null;
		//만일 i가 6이라면 for문 안에 실행문이 진행될 수 있을까?
		for(int cnt = 5;(str=sc.next()) != null && cnt > 0;) {
			//만약에 i값이 5이면 진행되어야 하는가? - yes
			//만약에 i값이 6이면 어디로 가야하지? - for문 밖
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
			//if if는 매번 조건을 따지지만 else if문을 사용하면 첫번째 조건이 만족되었을경우
			//아래 조건은 따짖이않고 if문 블록 탈출
			if(cnt==0) {
				System.out.println("더이상 기회는 없습니다.");
				break;
			}
			//그렇다면 과연 언제 for문을 탈출할 수 있는가? - 답을 맞추거나 기회가 없을 때
			//5번 기회중에서 3번째 정답을 맞추면 나간다.
			//5번을 초과해서 사용자가 입력을 할 수 있나요? - 아니요
		}
		System.out.println("게임이 종료되었습니다.");
	}////////////////////// end of gameStart ///////////////////////////
	public static void main(String[] args) {
		RandomGame_V1 rv1 = new RandomGame_V1();
		rv1.gameStart();
	}////////////////////// end of main ///////////////////////////
}
