package book.ch1;

public class DeptVO {
	private int	   deptno  =  0;  //부서번호
	private String dname   = ""; //부서명
	private String loc     = ""; //지역
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
}
