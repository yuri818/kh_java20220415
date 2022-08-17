package mvc.kh;

import org.apache.log4j.Logger;

// 여러개의 Dao를 호출할 수 있다. - 트랜잭션 처리
// 하나의 테이블에서 조회된 정보를 가지고 A테이블에는 insert를 B테이블에는 update처리한다 - 하나의 업무
// 트랜잭션 처리는 Logic 클래스에서 해야한다
public class LoginService {
	Logger logger = Logger.getLogger(LoginService.class);
	// 이른 인스턴스화 이다(스프링) - 멤버위치
	// 게으른 인스턴스화 이다 - 필요할때 바로 직전에 주입해줌 - 효율성증가 - NullPointerException
	// 로컬의 성격을 갖는다 - 지변
	// 이른 인스턴스화인 이유: LoginService가 인스턴스화 될 때 이 loginDao도 초기화가 같이 되기 때문이다.
	LoginDao loginDao = new LoginDao();
	public String login(String mem_id, String mem_pw) {
		String mem_name = null;
		mem_name = loginDao.login(mem_id, mem_pw);
		return mem_name;
	}
}
