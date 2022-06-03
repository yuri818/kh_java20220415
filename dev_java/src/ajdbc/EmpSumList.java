package ajdbc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import address.view2.DBConnectionMgr;

public class EmpSumList extends JFrame implements ActionListener {
	JButton jbtn_select = new JButton("조회");
	String headers[] = {"부서명","CLERK","MANAGER","ETC","DEPT_SAL"}; //오라클에서 컬럼들
	String data[][] = new String[0][5];
	//DefaultTableModel 찾아보고 설명 추가하기
	DefaultTableModel dtm = new DefaultTableModel(data, headers); //실제 화면상에서 데이터 함께 있는 것처럼 해줌
	JTable jtb = new JTable(dtm); 
	JScrollPane jsp = new JScrollPane(jtb);
	//물리적으로 떨어져 있는 오라클 서버에 연결통로 확보
	Connection con = null;
	//개발자가 작성한 select문 전달하고 오라클 서버에 처리 요청
	PreparedStatement pstmt = null;
	//오라클 서버에서 조회한 결과를 반환해 주면 커서를 조작하기
	ResultSet rs = null;
	DBConnectionMgr dbMgr = new DBConnectionMgr();
	
	public EmpSumList() {
		jbtn_select.addActionListener(this);
		initDisplay();
	}
	public List<Map<String,Object>> getEmpSumList(){
		System.out.println("getEmpSumList 호출 성공");
		List<Map<String,Object>> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT                                                          ");
	    sql.append("   decode(b.rno,'1',a.dname, '총계') dname                      ");
	    sql.append("  ,SUM(a.clerk) clerk                                           ");
	    sql.append("  ,SUM(a.manager) manager                                       ");
	    sql.append("  ,SUM(a.etc) etc                                               ");
	    sql.append("  ,SUM(a.dept_sal) dept_sal                                     ");
	    sql.append("  FROM (                                                        ");
	    sql.append("    SELECT dept.dname                                           ");
	    sql.append("          ,SUM(DECODE(job,'CLERK',sal)) clerk                   ");
	    sql.append("          ,SUM(DECODE(job,'MANAGER',sal)) manager               ");
	    sql.append("          ,SUM(DECODE(job,'CLERK',null,'MANAGER',null,sal)) etc ");
	    sql.append("          ,SUM(sal) dept_sal                                    ");
	    sql.append("      FROM emp, dept                                            ");
	    sql.append("     WHERE emp.deptno = dept.deptno                             ");
	    sql.append("    GROUP BY dept.dname                                         ");
	    sql.append("   )a,                                                          ");
	    sql.append("   (                                                            ");
	    sql.append("    SELECT rownum rno FROM dept                                 ");
	    sql.append("     WHERE rownum < 3                                           ");
	    sql.append("   )b                                                           ");
	    sql.append("   GROUP BY decode(b.rno,'1',a.dname, '총계')                   ");
	    sql.append("   ORDER BY dname                                               ");

		try {
			con = dbMgr.getConnection(); //객체 주입
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			Map<String, Object> rmap = null;
			while(rs.next()) {
				rmap = new HashMap<>();
				rmap.put("dname", rs.getString(1));
				rmap.put("clerk", rs.getDouble(2));
				rmap.put("manager", rs.getDouble(3));
				rmap.put("etc", rs.getDouble(4));
				rmap.put("dept_sal", rs.getDouble(5));
				list.add(rmap);
			}
			System.out.println(list);
		} catch (Exception e) {
			System.out.println(e.toString()); //예외 상황 처리
		}
		return list;
	}
	public void initDisplay() {
		System.out.println("initDisplay 호출 성공");
		this.add("North",jbtn_select);
		this.add("Center", jsp);
		this.setSize(500, 400);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new EmpSumList();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//이벤트가 감지된 컴포넌트의 주소번지를 가져온다.
		Object obj = e.getSource();
		if(obj == jbtn_select) {
			System.out.println("조회 버튼 누른거야!");
			getEmpSumList();
		}
	}

}
