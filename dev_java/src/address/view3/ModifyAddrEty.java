package address.view3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModifyAddrEty {
	// DB연동하는 부분
	DBConnectionMgr 	dbMgr 	= new DBConnectionMgr();
	Connection 			con 	= null;
	PreparedStatement 	pstmt 	= null;
	
	public AddressVO modify(AddressVO vo) {
		System.out.println("ModifyAddrEty modify 호출 성공");
		// 수정 하는것 구현해보기
		AddressVO rVO = new AddressVO();
		StringBuilder sql = new StringBuilder();                                               
		sql.append(" UPDATE mkaddrtb                                                    ");
		sql.append("    SET name = ?, relationship = ?, telephone =?, gender = ?,       ");
		sql.append("        birthday = ?, comments = ?, registedate =?, address =? 		");
		sql.append("  WHERE id =?                                                       ");
		int id = vo.getId();
		int result = 0;
		try {
			int i = 0;
			con 	= dbMgr.getConnection();
			pstmt 	= con.prepareStatement(sql.toString());
			pstmt.setString(++i, vo.getName());
			pstmt.setString(++i, vo.getRelationship());
			pstmt.setString(++i, vo.getTelephone());
			pstmt.setString(++i, vo.getGender());
			pstmt.setString(++i, vo.getBirthday());
			pstmt.setString(++i, vo.getComments());
			pstmt.setString(++i, vo.getRegistedate());
			pstmt.setString(++i, vo.getAddress());
			pstmt.setInt(++i, vo.getId());
			result = pstmt.executeUpdate();
			rVO.setResult(result);
		} catch (SQLException se) {
			System.out.println("[[query]]" + sql.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbMgr.freeConnection(pstmt, con);
		}
		return rVO;
	}////////////////////////end of modify

}
