package music.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import music.model.dto.SingerDTO;
import music.model.util.DBUtil;

public class SingerDAO {
	
	private static SingerDAO instance= new SingerDAO();
	private SingerDAO(){};
	public static SingerDAO getInstance() {
		return instance;
	}
	
	//추가
	public boolean addSinger(SingerDTO singer) throws SQLException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into singer values(?, ?)");
			pstmt.setInt(1, singer.getId());
			pstmt.setString(2, singer.getName());
			
			int result = pstmt.executeUpdate();
		
			if(result == 1){
				return true;
			}
			
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	public void addSingersFromFile(String f) throws NumberFormatException, SQLException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			File file = new File(f);
			FileReader filereader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(filereader);
			String line = "";
			
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into singer values(?, ?)");
			
			while((line = bufReader.readLine()) != null) {
				String[] e = line.split("\t");
				pstmt.setInt(1, Integer.parseInt(e[1]));
				pstmt.setString(2, e[0]);
				
				try {
					pstmt.executeUpdate();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
			bufReader.close();
			
		} catch (FileNotFoundException fn) {
			fn.getStackTrace(); // 파일이 없을 경우
		} catch (IOException e) {
			e.getStackTrace();
		}
	}
	
	// 가수 검색
	public ArrayList<SingerDTO> getSingers(String name) throws SQLException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<SingerDTO> list = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * "
										+ "from (select * from singer where singer_name like '"+name+ "%' order by singer_name) "
										+ "where rownum <=20");
			
			rset = pstmt.executeQuery();
			list = new ArrayList<SingerDTO>();
			
			while(rset.next()) {
				list.add(new SingerDTO(rset.getInt(1), rset.getString(2)));
			}
			
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
	//제거
	public boolean deleteSinger(int singerId) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from singer where singer_id=?");
			pstmt.setInt(1, singerId);

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
