package Quiz;

import javax.swing.JOptionPane;

//달에서 몸무게 구하기 프로그램

public class Quiz1 {

	public static void main(String[] args) {
		//당신의 몸무게를 알고 싶다.
		String userWeight = null;
		userWeight = JOptionPane.showInputDialog("당신의 몸무게는 달에서 얼마입니까?");
		
		//달의 몸무게를 담을 변수 선언
		double moon_weight = 0.0; //값을 입력하기때문에 초기화가 의미없다. 얘가 10.0이라도 내가 입력한 값이 처리됨
		//메소드의 파라미터에 String을 주면 double로 형전환을 해주는 메소드
		double earth_weight = Double.parseDouble(userWeight);
		//사용자의 몸무게*(17/100)
		System.out.println(earth_weight*(17/100.0));
		moon_weight = earth_weight*(17/100);
		System.out.println(moon_weight);
	}

}