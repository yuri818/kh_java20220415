package swing.template;

import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JButton;

//BorderLayoutApp.java소스는 하나인데
//클래스는 두개가 만들어져요.
//BorderLayoutView.class
//BorderLayoutApp.class
class BorderLayoutView {
	//인스턴스화 하기 - syntax -> 타입 인스턴스변수명 = new 생성할 클래스명(); //()를 생성자라고 한다.
	//생긴 모양이 괄호가 있으면 셋 중에 하나이다. - 메소드, 생성자, Casting연산자 -메소드 오버라이딩과 메소드 오버로딩
	JFrame jf = new JFrame();	//전역이다. 얜 heap에 산다.
	//상수로 되어있는 것들을 변수로 바꿔보자.
	String send = "전송";

	JButton jbtn_north = new JButton(send);
	JButton jbtn_south = new JButton("남쪽");
	JButton jbtn_center = new JButton("중앙");
	JButton jbtn_east = new JButton("동쪽");
	JButton jbtn_west = new JButton("서쪽");
	int width = 400;
	int height = 400;
	public void initDisplay() {
		//실행문
		System.out.println("initDisplay 호출 성공");
		jbtn_north.setBackground(Color.red);
		//버튼을 배치할 위치 정보를 담는 변수 선언
		//String north = "North";
	
/*****************내가 한 부분************************/		
		String loc[] = {"North", "South", "Center", "East", "West"};
		JButton jbtns[] = {jbtn_north, jbtn_south, jbtn_center, jbtn_east, jbtn_west};
//		JButton[] jbtns = new JButton[5];
//		jbtns[0] = jbtn_north;
//		jbtns[1] = jbtn_south;
//		jbtns[2] = jbtn_center;
//		jbtns[3] = jbtn_east;
//		jbtns[4] = jbtn_west;
		
		for(int i = 0; i < loc.length; i++) {
			jf.add(loc[i], jbtns[i]);
		}
//		jf.add(north, jbtn_north);
//		jf.add("South", jbtn_south);
//		jf.add("Center",jbtn_center);
//		jf.add("East",jbtn_east);
//		jf.add("West",jbtn_west);
		
		jf.setSize(width, height);
		jf.setVisible(true);
		jf.setTitle("java실습");		
	}
}

public class BorderLayoutApp {

	public static void main(String[] args) {
		//JFrame.setDefaultLookAndFeelDecorated(true);
		BorderLayoutView blv = new BorderLayoutView();
		blv.initDisplay(); //메소드 호출
		
		
//		BorderLayoutApp bla = new BorderLayoutApp();
		 		
	}

}
