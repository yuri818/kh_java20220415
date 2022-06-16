package ajdbc.member;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import address.view2.DBConnectionMgr;

//JFrame jf = new JFrame();
//jf.setTitle("자바실습");
//위에 두줄을 밑에 한줄로 줄일 수 있다 - 생성자를 활용하자.
//JFrame jf = new Jframe("자바실습");

public class MemberApp extends JFrame implements ActionListener, MouseListener {
	String 				cols[]		= {"번호","아이디","이름","주소"};
	//[0][4]는 값이 들어갈 공간을 정해두는 것 - [3][4]로 확인해보기
	String 				data[][]	= new String[0][4]; //바디부분에 들어올 2차 배열을 정의함
	DefaultTableModel 	dtm 		= new DefaultTableModel(data,cols);
	JTable				jtb			= new JTable(dtm);
	Font				font		= new Font("돋움체",Font.BOLD,18);
	JScrollPane			jsp			= new JScrollPane(jtb); //내용이 길어지면 스크롤을 생성해주는것.
	//JPanel을 북쪽 위치에 만들어주어 거기에 "조회","입력","수정","삭제" 버튼을 추가한다. - 속지추가
	JPanel				jp_north	= new JPanel();
	//JButton으로 하나씩 버튼을 만들어 준다.
	JButton 			jbtn_sel 	= new JButton("조회");
	JButton 			jbtn_ins 	= new JButton("입력");
	JButton 			jbtn_upd 	= new JButton("수정");
	JButton 			jbtn_del 	= new JButton("삭제");
	//DB연동하는 부분
	Connection 			con 		= null;
	PreparedStatement 	pstmt 		= null;
	ResultSet 			rs 			= null;
	DBConnectionMgr		dbMgr		= new DBConnectionMgr();
	//입력버튼 눌렀을 때 회원가입창 가져오려고 하는 인스턴스화
//	MemberShip 			ms 			= new MemberShip();
	MemberShip 			ms 			= new MemberShip(this);
	//생성자
	public MemberApp() {
		//이벤트 소스와 이벤트 처리 클래스를 매핑
		//조회,입력,수정,삭제 버튼 눌렀을때 반응하기
		jbtn_sel.addActionListener(this);
		jbtn_ins.addActionListener(this);
		jbtn_upd.addActionListener(this);
		jbtn_del.addActionListener(this);
		initDisplay();
//		refreshData();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		//조회 버튼 누를거니?
		if(obj == jbtn_sel) {
			refreshData();
		}
		//입력버튼을 눌렀을 때 회원가입하는 창이 떴으면 좋겠어~
		else if(obj == jbtn_ins) {
			ms.initDisplay();
		}
		
	}
	//조회하는 버튼 눌렀을 때 나오는 메소드
	public void refreshData() {
		//리스트는 순서가 있다 - 속도느림 / 맵은 순서가 없다 - 속도 빠르다
		List<Map<String,Object>> memList = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT mem_no, mem_id, mem_pw              ");
		sql.append("	  ,mem_name, mem_zipcode, mem_address  ");
		sql.append("  FROM member                              ");
	    sql.append("ORDER BY mem_no desc                       ");
	    
	    try {
			con 	= dbMgr.getConnection();
			pstmt 	= con.prepareStatement(sql.toString());
			rs 		= pstmt.executeQuery();
			Map<String,Object> rmap = null;
			while(rs.next()) {
				rmap = new HashMap<>();
				rmap.put("mem_no"		, rs.getInt("mem_no"));
				rmap.put("mem_id"		, rs.getString("mem_id"));
				rmap.put("mem_name"		, rs.getString("mem_name"));
				rmap.put("mem_address"	, rs.getString("mem_address"));
				memList.add(rmap);
			}
//			System.out.println(memList);
			//기존에 조회된 결과 즉, 목록 삭제하기
			//데이터를 가지는것이 dtm이므로 dtm에서 처리한다.
			///////이건 조회 눌렀을 때 새로고침이 아니라 밑으로 계속 연결 방지코드////////////
			while(dtm.getRowCount() > 0) { //로우가 하나라도 남아있을 경우 계속 실행
				//파라미터에 0을 주어서 테이블의 인덱스가 바뀌는 문제를 해결함
				dtm.removeRow(0); //0번째 로우를 없앤다 = 로우 하나씩 없앤다.
			}
			////////////////////////////////////////////////////////////
			//iterator라는 인터페이스를 메모리에 로딩
			//Iterator는 자료구조가 갖고있는 정보의 유무를 체크하는데 필요한 메소드를 제공하고 있다.
			Iterator<Map<String,Object>> iter = memList.iterator();
			Object keys[] = null;
			//iterator는 hasNext()메소드로 더 많은 요소가 있는지 확인
			while(iter.hasNext()) {
				Map<String,Object> data = iter.next();
				keys 					= data.keySet().toArray();
				//벡터에 꺼낸 로우의 값들을 담는다
				Vector<Object> oneRow 	= new Vector<>();
				//map의 경우 순서가 없으므로 출력을 해서 확인 후 값을 꺼낸다.
				oneRow.add(data.get(keys[2]));
				oneRow.add(data.get(keys[1]));
				oneRow.add(data.get(keys[0]));
				oneRow.add(data.get(keys[3]));
				//데이터셋인 DefaultTableModel에 조회 결과 담기 - 반복처리함
				dtm.addRow(oneRow);
			}
		} catch (SQLException se){
			System.out.println("[[query]]"+sql.toString());
			System.out.println(se.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//사용한 자원 반납은 생성된 역순으로 한다.
			DBConnectionMgr.freeConnection(rs, pstmt, con);
		}
	}
	
	//화면 그리기
	public void initDisplay() {
		//처음 화면 그릴때 적었던 것들 - 기본 틀
		this.add("Center",jsp); 
		this.setTitle("회원관리시스템 Ver1.0");
		this.setSize(600,400);
		this.setVisible(true);
		//jp_north속지를 북쪽에 추가해주기
		this.add("North",jp_north);
		//jp_north는 FlowLayout이 기본값 - 왼쪽으로 넣어주겠다.
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		//위에 조회/입력/수정/삭제 버튼을 추가해보기
		jp_north.add(jbtn_sel); //조회
		jp_north.add(jbtn_ins); //입력
		jp_north.add(jbtn_upd); //수정
		jp_north.add(jbtn_del); //삭제
		//버튼의 배경색을 바꿔주었다 - setBackground
		//버튼의 글자색을 바꿔주었다 - setForeground
		jbtn_sel.setBackground(new Color(176,196,222));
		jbtn_sel.setForeground(new Color(212,212,212));
		jbtn_ins.setBackground(new Color(135,206,250));
		jbtn_ins.setForeground(new Color(212,212,212));
		jbtn_upd.setBackground(new Color(64,224,208));
		jbtn_upd.setForeground(new Color(212,212,212));
		jbtn_del.setBackground(new Color(32,178,170));
		jbtn_del.setForeground(new Color(212,212,212));
		
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


	public static void main(String[] args) {
		new MemberApp();
	}

}
