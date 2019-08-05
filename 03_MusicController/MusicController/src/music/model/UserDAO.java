package music.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import music.model.dto.UserDTO;
import music.model.util.DBUtil;

public class UserDAO {
	
	private static UserDAO instance= new UserDAO();
	private UserDAO(){};
	public static UserDAO getInstance() {
		return instance;
	}
	
	//추가
	public boolean addUser(UserDTO user) throws SQLException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into users values(?, ?, ?)");
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPassword());
			
			int result = pstmt.executeUpdate();
		
			if(result == 1) {
				return true;
			}
			
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	// 유저 삭제
	public boolean deleteUser(int userId) throws SQLException {

	      Connection con = null;
	      PreparedStatement pstmt = null;

	      try {
	         con = DBUtil.getConnection();
	         pstmt = con.prepareStatement("delete from users where user_id=?");
	         pstmt.setInt(1, userId);
	         
	         int result = pstmt.executeUpdate();
	         
	         if (result == 1) {
	            return true;
	         }
	      } finally {
	         DBUtil.close(con, pstmt);
	      }
	      return false;
	}
}
