package Quiz;
//학생별로 자바, html, 오라클 성적을 나열한것.
//총점과 평균, 석차 구하는 프로그램
public class Quiz4 {

	public static void main(String[] args) {
		int score[][] = {
				 {100,90,80}
				,{85,90,80}
				,{70,70,80}
				,{90,60,65}
				,{65,80,70}
		};
		int sum = 0;
		
		for(int i=0;i<score.length;i++) {
			System.out.println("학생"+ i +": "+ sum);
			sum =0;
			for(int j=0; j<score[i].length;j++) {
				sum += score[i][j];
			}
		}
		
		
	}

}
