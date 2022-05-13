package Quiz;

import java.util.Scanner;

//구구단 중에서 시작단과 끝단을 입력받아서  출력하는 프로그램을 작성하시오.
public class Quiz0513 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		System.out.println("시작단을 입력하세요: " + sc.next());
		int last = sc.nextInt();
		System.out.println("끝단을 입력하세요: " + sc.next());
		
	}

}
