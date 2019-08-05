package music.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import music.model.dto.PrintSongDTO;
import music.model.util.DBUtil;

public class NewSongDAO {
	
	private static NewSongDAO instance= new NewSongDAO();
	private NewSongDAO(){};
	public static NewSongDAO getInstance() {
		return instance;
	}

	// NewSong Chart
	// addNewSong
	public boolean addNewSong(String date) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from new_song");
			pstmt.execute();
			pstmt.close();

			pstmt = con.prepareStatement("insert into new_song select song_id from song where release_date=?");
			pstmt.setString(1, date);

			int result = pstmt.executeUpdate();

			if (result >= 1) {
				return true;
			}

		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// √÷Ω≈∞Ó ∫∏±‚
	public ArrayList<PrintSongDTO> getNew() throws SQLException {

		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;

		ArrayList<PrintSongDTO> list = null;

		try {
			con = DBUtil.getConnection();
			stmt = con.createStatement();
			rset = stmt.executeQuery("select s.song_id, s.song_name, sg.singer_name, s.release_date "
									+ "from new_song ns inner join song s "
									+ "on ns.song_id = s.song_id "
									+ "inner join singer sg "
									+ "on s.singer_id = sg.singer_id");

			list = new ArrayList<PrintSongDTO>();

			while (rset.next()) {
				list.add(new PrintSongDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4)));
			}

		} finally {
			DBUtil.close(con, stmt, rset);
		}
		return list;
	}
}
