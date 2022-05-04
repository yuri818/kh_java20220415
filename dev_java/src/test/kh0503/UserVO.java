package test.kh0503;
//데이터만 담을 수 있는 클래스 설계하기
//접두어에 사용된 VO는 Value Object의 약자이다
//자바의 변수와 오라클의 변수 사이에 매칭해주는 클래스 설계이름이다.
public class UserVO {
	//아이디를 담을 변수 선언
	//전변의 위변조를 막기 위해서 private으로 선언한 뒤
	//값을 꺼낼 때는 getter메소드를 호출하고 
	//값을 담을 때는 setter메소드의 파라미터를 통해서 복사된 값이
	//전역변수인 mem_id에 저장됨.
	private String mem_id;
	//비번을 담을 변수 선언
	private String mem_pw;
	//그 사용자의 생일을 담을 변수 선언
	private String birth;
	//디폴트 생성자 - 파라미터가 하나도 없는 그런 생성자
	//역할 : 니가 있어서 내가 RAM(하드웨어H/W)에 올라탈 수 있어. - 재사용하려고
	//전변을 재사용하기 위해서는 생성자를 반드시 호출 할 것
	//지금까지는 안해도 문제가 없었잖아요.
	//전변의 초기화는 생성자가 대신해주니까 필요x
	public UserVO() {} 
	//세 개의 파라미터를 갖는 생성자를 통해서 전역변수의 초기화가 가능함.
	public UserVO(String mem_id, String mem_pw, String birth) {
		//this가 붙은 mem_id만 전변, this가 없는 변수는 지변(위치: 파라미터)
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
		this.birth = birth;
	}
	public String getMem_id() {
		return mem_id;
	}
	//접근제한자가 public이므로 외부에서 접근 가능하다.
	//파라미터를 통해서 값이 전달되고 전변인 mem_id 
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
}
