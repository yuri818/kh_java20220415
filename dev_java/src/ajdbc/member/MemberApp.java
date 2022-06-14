package ajdbc.member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class MemberApp extends JFrame implements ActionListener, MouseListener {
	//선언부
	JPanel		jp_center		= new JPanel();
	JLabel 		jlb_id 			= new JLabel("아이디 ");
	JTextField 	jtf_id 			= new JTextField("",20);
	JButton		jbtn_idcheck	= new JButton("아이디 중복체크");
	JScrollPane jsp				= new JScrollPane(jp_center); //속지 //파라미터로 jp_center넘기면 그위에 겹치는 느낌으로
	JPanel		jp_south		= new JPanel();
	JButton		jbtn_signup		= new JButton("회원가입");
	JButton		jbtn_cancel		= new JButton("취소");
	
	//생성자
	public MemberApp() {
		initDisplay();
	}
	//화면 처리부
	public void initDisplay() {
		jp_center.setLayout(null); //null일경우 반영되지 않는다
		jlb_id.setBounds(20, 20, 100, 20); //x,y,width,height
		jtf_id.setBounds(120, 20, 100, 20); //x,y,width,height
		jbtn_idcheck.setBounds(230, 20, 140, 20);
		jp_center.add(jlb_id);
		jp_center.add(jtf_id);
		jp_center.add(jbtn_idcheck);

		jp_south.add(jbtn_signup);
		jp_south.add(jbtn_cancel);
		
		this.add("Center",jsp);
		this.add("South", jp_south);
		this.setTitle("회원가입 하기");
		this.setSize(430,380);
		this.setVisible(true);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new MemberApp();
	}

}
