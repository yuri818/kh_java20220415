package Quiz;
/*
-10에서 10사이의 정수 10개를 랜덤하게 채번하여  음수와 양수의 합계를 구하시오.
[요구사항 : 채번한 숫자는 1차 배열에 담아서 처리해 주세요]
출력)
배열 : 9 -2 -3 8 0 -3 -8 -6 -2 0
음수합 : -24
양수합 : 17
*/
public class Quiz0516_1 {
	//길이가 10인 배열 생성 - 타입은 정수
	int[] arr = new int[10];
	int negsum = 0; //음수의 합
	int possum = 0; //양수의 합
	Quiz0516_1(){ //디폴트생성자로 난수 설정과 출력메세지
		nansu();
		System.out.println();
		print();
	}
	//-10~10 사이의 난수 설정하기
	public void nansu() {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*20)-10;
			System.out.print(arr[i]+" ");
			if(arr[i]<0) { //음수의 합 구하기
				negsum += arr[i];
			} else if(arr[i]>0) { //양수의 합 구하기
				possum += arr[i];
			}
		}
	}
	public void print() {//출력할 문장적기
		System.out.println("음수합: " + negsum);
		System.out.println("양수합: " + possum);
	}

	public static void main(String[] args) {
		Quiz0516_1 q = new Quiz0516_1(); //디폴트 생성자 호출되므로 난수설정, 메세지 출력
	}
}
			
