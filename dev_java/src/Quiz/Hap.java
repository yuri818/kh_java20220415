package Quiz;

public class Hap {
	Hap(){}
	public void sethap(int sum) {
		for(int i=1 ; i<100;i++) {
			if(i%3 == 0) {
				sum += i;
			}
		}
		System.out.println("3의 배수의 합: " + sum);
	}
}

