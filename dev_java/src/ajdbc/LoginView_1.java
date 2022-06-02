package ajdbc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginView_1 extends JFrame {
	JPanel 		jp_center	 = new JPanel();
	JTextField  jtf_id		 = new JTextField("",10);
	JTextField  jtf_pw		 = new JTextField("",10);
	JPanel 		jp_east		 = new JPanel();
	JButton 	jbtn_login   = new JButton("로그인");
	
	LoginView_1(){
		initDisplay();
	}
	public void initDisplay() {
		jp_center.setBackground(Color.orange);
		jp_center.setLayout(new GridLayout(2,1));
		jp_center.add(jtf_id);
		jp_center.add(jtf_pw);
		jp_east.setBackground(Color.green);
		jp_east.setLayout(new BorderLayout());
		jp_east.add("Center",jbtn_login);
		this.setTitle("유리톡 로그인");
		this.setSize(250,100);
		this.add("Center",jp_center);
		this.add("East",jp_east);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new LoginView_1();
		
	}

}
