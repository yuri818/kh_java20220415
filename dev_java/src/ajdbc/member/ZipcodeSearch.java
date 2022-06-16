package ajdbc.member;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import address.view2.DBConnectionMgr;

public class ZipcodeSearch extends JFrame
implements FocusListener, ActionListener, MouseListener {
	//선언부
	String 				cols[]		= {"우편번호","주소"};
	String 				data[][]	= new String[0][2]; 
	DefaultTableModel 	dtm 		= new DefaultTableModel(data,cols);
	JTable				jtb			= new JTable(dtm);
	Font				font		= new Font("돋움체",Font.BOLD,18);
	JScrollPane			jsp			= new JScrollPane(jtb);
	 //속지 추가
	JPanel				jp_north	= new JPanel();
	 //동 이름 입력해달라는 문구 북쪽에 추가
	JTextField			jtf_dong	= new JTextField("동이름을 입력하세요",20);
	 //동쪽에 붙일 찾기버튼
	JButton				jbtn_search	= new JButton("찾기");
	 //시도 를 나타낼 공간 추가
	String 				zdos[]		= {"전체","서울","경기"};
	JComboBox			jcb			= new JComboBox(zdos);
	 //DB연동하는 부분
	Connection 			con 		= null;
	PreparedStatement 	pstmt 		= null;
	ResultSet 			rs 			= null;
	DBConnectionMgr		dbMgr		= new DBConnectionMgr();
	
	MemberShip			ms			= null;
	
	//생성자
	public ZipcodeSearch() {}
	public ZipcodeSearch(MemberShip ms) {
		this.ms = ms;
	}
	//화면처리부
	public void initDisplay() {
		this.add("Center",jsp); 
		this.setTitle("우편번호 검색기");
		this.setSize(430,400);
		this.setVisible(true);
		//버튼들+속지추가
		this.add("North",jp_north);
		jp_north.setLayout(new BorderLayout());
		jp_north.add("Center",jtf_dong);
		jp_north.add("East",jbtn_search);
		//나는 foucusListener의 이벤트 처리도 담당하는 클래스입니다 - this
		jtf_dong.addFocusListener(this);
		//콤보박스 추가하기
		jp_north.add("West",jcb);
		//동 버튼 눌렀을때 액션
		jtf_dong.addFocusListener(this);
		jtf_dong.addActionListener(this);
		//마우스 클릭했을때
		jtb.addMouseListener(this);
	}
	//동 찾는 메소드
	public void refreshData(String dong) {
		StringBuilder sql = new StringBuilder();
		List<Map<String,Object>> zipList = new ArrayList<>();
		sql.append("SELECT                            ");
		sql.append("	   zipcode, address           ");
		sql.append("  FROM zipcode_t                  ");
	    sql.append(" WHERE dong LIKE '%'||?||'%'  	  ");
		
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dong);
			rs = pstmt.executeQuery();
			Map<String,Object> rmap = null;
			while(rs.next()) {
				rmap = new HashMap<>();
				rmap.put("zipcode", rs.getString("zipcode"));
				rmap.put("address", rs.getString("address"));
				zipList.add(rmap);
			}
			//조회된 결과를 DefaultTableModel에 매핑하기
			for(int i=0;i<zipList.size();i++) {
				Map<String,Object> 	map 	= zipList.get(i);
				Vector<Object> 		oneRow	= new Vector<>();
				oneRow.add(0,map.get("zipcode"));
				oneRow.add(1,map.get("address"));
				dtm.addRow(oneRow);
			}
			
			
		} catch(SQLException se) {
			System.out.println(se.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnectionMgr.freeConnection(rs, pstmt, con);
		}
	}
	//메인메소드
	public static void main(String[] args) {
		ZipcodeSearch zc = new ZipcodeSearch();
		zc.initDisplay();
	}
	
	//FocusListener의 추상메소드 구현
	@Override
	public void focusGained(FocusEvent e) {
		if(e.getSource() == jtf_dong) {
			jtf_dong.setText("");
		}
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	//ActionListener의 추상메소드 구현
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == jtf_dong || obj == jbtn_search) {
			//사용자가 입력한 값을 textfield에서 받아옴
			String user = jtf_dong.getText();
			refreshData(user);
		}
	}
	//MouseListener의 추상메소드 구현
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getClickCount() == 2) { //더블 클릭 했을 때
			System.out.println("더블 클릭 한거야?");
			//선택했을때
			int index[] = jtb.getSelectedRows();
			if(index.length == 0) { //선택 안했을 때
				JOptionPane.showMessageDialog(this, "조회할 데이터를 선택하시오.");
				return; //이벤트 처리 탈출 (if문 탈출)
			} else {
				//사용자가 더블 클릭한 로우의 우편번호 가져오기  - getValueAt(로우, 컬럼)
				String 	zipcode = (String)dtm.getValueAt(index[0], 0); 
				//사용자가 더블 클릭한 로우의 주소 가져오기
				String 	address = (String)dtm.getValueAt(index[0], 1);
//				System.out.println(zipcode+", "+address);
				//더블클릭했을 때 이 값들을 회원가입하기창의 우편번호와 주소 창으로 넘기기
				ms.jtf_zipcode.setText(zipcode);
				ms.jtf_address.setText(address);
			}
		}
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

}
