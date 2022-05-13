package Quiz;

import java.util.Scanner;

//1부터 n까지 세면서 3의 배수의 합을 구하는 프로그램을 작성하시오.
//요구사항: n은 내가 입력한 값.
public class Quiz0512_2 {
	Scanner sc = new Scanner(System.in);
	int sum = 0;
	int n = 0;
	Quiz0512_2(){
		System.out.print("1부터 n까지의 범위를 입력하시오. n: ");
		int n = sc.nextInt();
		this.n = n;
	}
	public void hap(){
		for(int i=1 ; i < n;i++) {
			if(i%3 == 0) {
				sum += i;
			}
		}
		System.out.println("1부터 "+ n + "까지 3의 배수의 합: " + sum);
	}

	public static void main(String[] args) {
		Quiz0512_2 q = new Quiz0512_2();
		q.hap();
	}

}
