package login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginView_java extends JFrame implements ActionListener{
	JPanel 		jp_center 	= new JPanel();
	JTextField 	jtf_id		= new JTextField("",10);
	JTextField 	jtf_pw		= new JTextField("",10);
	JPanel 		jp_east 	= new JPanel();
	JButton 	jbtn_login  = new JButton("로그인");
	LoginView_java(){
		jbtn_login.addActionListener(this);
		initDisplay();
	}
	public void initDisplay() {
		jp_center.setBackground(Color.orange);
		jp_center.setLayout(new GridLayout(2,1));
		jp_center.add(jtf_id);
		jp_center.add(jtf_pw);
		jp_east.setBackground(Color.green);
		jp_east.setLayout(new BorderLayout());
		jp_east.add("Center", jbtn_login);
		this.setTitle("토마토톡 로그인");
		this.setSize(250, 100);
		this.add("Center", jp_center);
		this.add("East", jp_east);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new LoginView_java();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == jbtn_login) {
			System.out.println("로그인 호출 성공");
			String user_id = jtf_id.getText();
			String user_pw = jtf_pw.getText();
			String result = "";
			LoginDao_java loginDao = new LoginDao_java();
			result = loginDao.login(user_id, user_pw);
			System.out.println("result : "+result);
		}
	}
}