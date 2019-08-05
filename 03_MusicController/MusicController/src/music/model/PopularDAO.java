package music.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import music.model.dto.PrintSongDTO;
import music.model.util.DBUtil;

public class PopularDAO {
	
	private static PopularDAO instance= new PopularDAO();
	private PopularDAO(){};
	public static PopularDAO getInstance() {
		return instance;
	}

	// add popularity
	public boolean addPopularity(int songId) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement("update song set popularity=popularity+1 where song_id=?");
			pstmt.setInt(1, songId);

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}

		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// getPopular
	public ArrayList<PrintSongDTO> getPopular() throws SQLException {

		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;

		ArrayList<PrintSongDTO> list = null;

		try {
			con = DBUtil.getConnection();
			stmt = con.createStatement();
			rset = stmt.executeQuery("select s.song_id, s.song_name, sg.singer_name, s.release_date "
									+ "from popular_chart pc, song s, singer sg "
									+ "where pc.song_id=s.song_id and s.singer_id=sg.singer_id "
									+ "order by s.popularity desc");

			list = new ArrayList<PrintSongDTO>();

			while (rset.next()) {
				list.add(new PrintSongDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4)));
			}

		} finally {
			DBUtil.close(con, stmt, rset);
		}
		return list;
	}

	public boolean updatePopularChart() throws SQLException {
		
		Connection con = null;
		Statement stmt = null;

		try {
			con = DBUtil.getConnection();
			stmt = con.createStatement();
			stmt.executeQuery("delete from popular_chart");
			
			int result = stmt.executeUpdate("insert into popular_chart "
											+ "select song_id "
											+ "from (select song_id from song order by popularity desc) "
											+ "where rownum <= 50 ");

			if (result >= 1) {
				return true;
			}
			
		} finally {
			DBUtil.close(con, stmt);
		}
		return false;
	}
}
