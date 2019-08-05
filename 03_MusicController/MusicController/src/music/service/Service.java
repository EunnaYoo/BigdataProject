package music.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import music.controller.AdminController;
import music.exception.NotExistException;
import music.model.MappingDAO;
import music.model.NewSongDAO;
import music.model.PopularDAO;
import music.model.SingerDAO;
import music.model.SongDAO;
import music.model.UserDAO;
import music.model.dto.PrintSongDTO;
import music.model.dto.SingerDTO;
import music.model.dto.SongDTO;
import music.model.dto.UserDTO;

public class Service {
	private static Logger logger = Logger.getLogger(Service.class.toString());
	
	private static Service instance = new Service();
	private Service(){};
	public static Service getInstance() {
		return instance;
	}
	
	private SongDAO songDAO = SongDAO.getInstance();
	private SingerDAO singerDAO = SingerDAO.getInstance();
	private UserDAO userDAO = UserDAO.getInstance();
	private MappingDAO mappingDAO = MappingDAO.getInstance();
	private NewSongDAO newsongDAO = NewSongDAO.getInstance();
	private PopularDAO popularDAO = PopularDAO.getInstance();
	
	// Song
	public ArrayList<SongDTO> getSongList(String name) throws SQLException {
		logger.info("getSongList "+name);
		return songDAO.getSongs(name);
	}
	
	public ArrayList<PrintSongDTO> printSongList(String name) throws SQLException, NotExistException {
		logger.info("printSongList " + name);
		return songDAO.printSongs(name);
	}
	
	public boolean addSong(SongDTO song) throws SQLException {
		logger.info("addSong " + song);
		return songDAO.addSong(song);
	}
	
	public void addSongsFromFile(String f) throws Exception {
		logger.info("addSongsFromFile " );
		songDAO.addSongsFromFile(f);
	}
	
	public ArrayList<PrintSongDTO> getSongListBySinger(int id) throws SQLException {
		logger.info("getSongListBySinger "+id);
		return songDAO.getSongsBySinger(id);
	}
	
	public boolean deleteSong(int songId) throws SQLException {
		logger.info("deleteSong "+songId);
		return songDAO.deleteSong(songId);
	}
	
	// Singer
	public boolean addSinger(SingerDTO singer) throws SQLException {
		logger.info("addSinger "+singer);
		return singerDAO.addSinger(singer);
	}
	
	public void addSingersFromFile(String f) throws Exception {
		logger.info("addSingersFromFile ");
		singerDAO.addSingersFromFile(f);
	}
	
	public ArrayList<SingerDTO> getSingerList(String name) throws SQLException {
		logger.info("getSingerList "+name);
		return singerDAO.getSingers(name);
	}
	
	public boolean deleteSinger(int singerId) throws SQLException {
		logger.info("deleteSinger "+singerId);
		return singerDAO.deleteSinger(singerId);
	}
	
	// Users
	public boolean addUser(UserDTO user) throws SQLException {
		logger.info("addUser "+user);
		return userDAO.addUser(user);
	}
	
	public boolean deleteUser(int userId) throws SQLException {
		logger.info("deleteUser "+userId);
		return userDAO.deleteUser(userId);
	}
	
	// Mapping
	public boolean addMyList(int songId, String userId) throws SQLException {
		logger.info("addMyList "+songId+" "+userId);
		return mappingDAO.addMyList(songId, userId);
	}
	public ArrayList<PrintSongDTO> getMyList(String id) throws SQLException{
		logger.info("getMyList "+id);
		return mappingDAO.getMyList(id);
	}
	
	// NewSong
	public ArrayList<PrintSongDTO> getNew() throws SQLException{
		logger.info("getNew ");
		return newsongDAO.getNew();
	}
	public boolean addNewSong(String date) throws SQLException {
		logger.info("getNew "+date);
		return newsongDAO.addNewSong(date);
	}
	
	// PopularChart
	public boolean updatePopularChart() throws SQLException {
		logger.info("updatePopularChart ");
		return popularDAO.updatePopularChart();
	}
	public ArrayList<PrintSongDTO> getPopular() throws SQLException {
		logger.info("getPopular ");
		return popularDAO.getPopular();
	}
	public boolean addPopularity(int songId) throws SQLException {
		logger.info("addPopularity "+songId);
		return popularDAO.addPopularity(songId);
	}
}
