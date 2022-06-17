package ajdbc.member3;


public class MemberController {
	public final String _LOGIN 		= "login";
	public final String _SIGNUP		= "membership";
	public final String _IDCHECK	= "idcheck";
	Member3VO			mVO			= null;
	//디폴트 생성자
	public MemberController(){	}
	//생성자를 통해서 기준을 가져온다.
	public MemberController(Member3VO mVO){
		this.mVO = mVO;
	}
	
	public void action() {
		String command = mVO.getCommand();
		//LoginDao 생성하기
		if(_LOGIN.equals(command)) {
			LoginDao loginDao = new LoginDao();
			String mem_name = null;
			mem_name = loginDao.login("사용자가 입력한 아이디","사용자가 입력한 비번"); //이게 mem_name을 반환
		} else if(_SIGNUP.equals(command)) {
			System.out.println("MemberController - 회원가입 호출 성공");
			MemberDao memDao = new MemberDao();
			int result = 0;
			result = memDao.memberInsert(mVO);
		} else if(_IDCHECK.equals(command)) {
			LoginDao loginDao = new LoginDao();
			boolean isOk = loginDao.idCheck("사용자가 입력한 아이디값");
		}
	}
}
