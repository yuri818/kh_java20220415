package address.view3;

import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
	
	// mybatis로 고쳐보기
	public AddressVO myBatisModify(AddressVO vo) {
		System.out.println("ModifyAddrEty myBatisModify 호출 성공");
		// 수정 하는것 구현해보기
		SqlSessionFactory sqlMapper = null;
		String resource = "address/view3/MapperConfig.xml";
		SqlSession sqlSes = null;
		Reader reader = null;
		int id = vo.getId();
		AddressVO rVO = new AddressVO();
		int result = 0;
		try {
			reader = Resources.getResourceAsReader(resource);
	    	sqlMapper = new SqlSessionFactoryBuilder().build(reader);
	    	sqlSes = sqlMapper.openSession();
	    	result = sqlSes.update("updateAddress", vo);
	    	sqlSes.commit();
	    	reader.close();
			rVO.setResult(result);
		}  catch (Exception e) {
			e.printStackTrace();
		}
		return rVO;
	}////////////////////////end of modify

}
