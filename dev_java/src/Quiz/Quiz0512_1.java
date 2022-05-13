package Quiz;
//1부터 100까지 세면서 3의 배수의 합을 구하는 프로그램을 작성하시오.
//요구사항: for문을 이용해서 풀어보고 나서 while문으로 바꾸어서도 풀어보는게 좋습니다.
public class Quiz0512_1 {
	int sum = 0;
	int i = 1;
	Quiz0512_1(){}
	public void hap(){
		while(0<i && i<101) {
			if(i%3 == 0) {
				sum += i;
			}
			i++;
		}
		System.out.println("3의 배수의 합: " + sum);
	}

	public static void main(String[] args) {
		Quiz0512_1 q = new Quiz0512_1();
		q.hap();
	}

}
