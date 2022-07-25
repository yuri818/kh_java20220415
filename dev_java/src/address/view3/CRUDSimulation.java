package address.view3;

import java.util.List;
import java.util.Map;

public class CRUDSimulation {

	public static void main(String[] args) {
		CRUDSimulation 	cs 		= new CRUDSimulation();
		/*
		RetrieveAddrEty raEty 	= new RetrieveAddrEty();
		AddressVO[] 	rvo 	= raEty.retrieve();
		System.out.println(rvo.length);
		for(AddressVO avo: rvo) {
			System.out.println(avo.getAddress()+", "+avo.getBirthday());
		}
		*/
		/*
		 * 트랜잭션 처리 - 묶음배송(둘다 가지 않거나 둘이 같이 간다)
		 * con.setAutocommit(true) - 디폴트라서 커밋을 자동으로 처리함
		 * 2개의 테이블에 데이터를 넣어야 하나의 업무 종결 - false
		 */
		/*
		// 등록하느라 해둔 것
		RegisterAddrEty insEty = new RegisterAddrEty();
		AddressVO pVO = new AddressVO("나신입", "서울시 영등포구 당산동", "010-555-7777"
                                   , "1", "JAVA과정동기", "19900712", "백엔드개발자", "2022-03-25",0);
		insEty.register(pVO);
		if(pVO.getResult() == 1) { // 1이나오면 성공, 0이 나오면 실패
			System.out.println("입력 성공");
		}else {
			System.out.println("입력 실패");			
		}
		*/
		
		// 20220725 테스트
		List<Map<String,Object>> addressList = null;
		RetrieveAddrEty retEty = new RetrieveAddrEty();
		addressList = retEty.myBatisretrieve();	
		System.out.println(addressList);
		
		
	}
}
