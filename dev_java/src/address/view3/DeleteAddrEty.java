package address.view3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteAddrEty {
	// DB연동하는 부분
		DBConnectionMgr 	dbMgr 	= new DBConnectionMgr();
		Connection 			con 	= null;
		PreparedStatement 	pstmt 	= null;
		
	public AddressVO delete(AddressVO vo) {
		System.out.println("DeleteAddrEty delete 호출 성공");
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM mkaddrtb WHERE id=?");
		int id = vo.getId();
		int result = 0;
		AddressVO raVO = new AddressVO();
		try {
			con 	= dbMgr.getConnection();
			pstmt 	= con.prepareStatement(sql.toString());
			pstmt.setInt(1, id);
			result = pstmt.executeUpdate();
			raVO.setResult(result);
		} catch (SQLException se) {
			System.out.println("[[query]]" + sql.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbMgr.freeConnection(pstmt, con);
		}
		return raVO;
	}

}
