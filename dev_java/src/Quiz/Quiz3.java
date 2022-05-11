package Quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class Quiz3 {	
	int sum;
	int i;
	double avg;
	int max;
	int jumsu[] = new int[5];
	//총점구하기
	public int getSum() {
		for(i = 0; i<jumsu.length; i++) {
			sum += jumsu[i];
		}
		return this.sum = sum;
	}
	//평균구하기
	public double getAvg() {
		avg = (double)sum/5.0;
		return this.avg = avg;
	}
	//최대값 구하기
	public int getMax() {
		max = jumsu[0];
		for(i = 0; i < jumsu.length; i++) {
			if(max < jumsu[i]) {
				max = jumsu[0];
			}
		}
		return this.max = max;
	}
	
	public static void main(String[] args) {
		Quiz3 q = new Quiz3();
		Random r = new Random();
		//난수 설정
		for(q.i = 0; q.i < q.jumsu.length; q.i++) {
			q.jumsu[q.i] = r.nextInt(101);
		}
		q.getSum();
		q.getAvg();
		q.getMax();
		//석차 구하기
		Arrays.sort(q.jumsu);
		//출력값들
		System.out.println("총점: "+ q.sum + ", 평균: " + q.avg + ", 최대값: " + q.max + ", 석차: " + Arrays.toString(q.jumsu));
	}
}
