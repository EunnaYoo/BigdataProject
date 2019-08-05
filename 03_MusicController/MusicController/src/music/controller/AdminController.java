package music.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

import music.model.dto.PrintSongDTO;
import music.model.dto.SingerDTO;
import music.model.dto.SongDTO;
import music.model.dto.UserDTO;
import music.service.Service;
import music.view.EndView;

public class AdminController {

	private static Logger logger = Logger.getLogger(AdminController.class.toString());
	private static AdminController instance = new AdminController();

	private AdminController(){};

	public static AdminController getInstance() {
		return instance;
	}

	private static Service service = Service.getInstance();

	static Scanner sc = new Scanner(System.in);

	// 곡목 검색
	public void printSongList(String name) {
		
		logger.info("admin printSongList");
		
		try {
			ArrayList<PrintSongDTO> songList = service.printSongList(name);
			EndView.showSongList(songList);

			ArrayList<Integer> indexList = new ArrayList<>();
			for (PrintSongDTO eachSong : songList) {
				indexList.add(eachSong.getId());
			}

			EndView.Message("곡 번호를 입력해주세요");
			PrintSongDTO aim = songList.get(indexList.indexOf(sc.nextInt()));

			EndView.Message("1.듣기\t2.삭제\t0.종료");

			int req = sc.nextInt();
			if (req == 1) {
				logger.info("admin listen to song " + aim.getId());
				EndView.watchMovie(aim.getName(), aim.getSinger());
			} else if (req == 2) {
				logger.info("admin delete song " + aim.getId());
				service.deleteSong(aim.getId());
			} else if (req == 0) {
				return;
			} else {
				logger.warn("fail to find song");
				EndView.failView("잘못된 입력값입니다.");
			}

		} catch (Exception e) {
			logger.warn(e);
			e.printStackTrace();
		}
	}

	// 가수검색
	public void getSingerList(String name) {
		
		logger.info("admin getSingerList");
		
		try {
			ArrayList<SingerDTO> singerList = service.getSingerList(name);

			EndView.showSongList(singerList);
			EndView.Message("곡 목록을 보고 싶은 가수의 번호를 선택해 주세요");

			SingerDTO aim = singerList.get(sc.nextInt() - 1);

			logger.info("admin find singer " + aim.getId());

			ArrayList<PrintSongDTO> songList = service.getSongListBySinger(aim.getId());
			EndView.showSongList(songList);

			EndView.Message("곡 번호를 입력해주세요");
			PrintSongDTO aim2 = songList.get(sc.nextInt() - 1);

			logger.info("admin listen to song " + aim2.getId());
			EndView.watchMovie(aim2.getName(), aim2.getSinger());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addSong(SongDTO song) {
		
		logger.info("admin addSong");
		
		try {
			boolean result = service.addSong(song);

			if (result == false) {
				logger.warn("admin fail to add song");
				EndView.failView("저장실패");
			}
		} catch (Exception e) {
			logger.info(e);
			e.printStackTrace();
		}
	}

	public void addSongFromFile(String f) {
		try {
			logger.info("admin add song from file");
			service.addSongsFromFile(f);
		} catch (Exception e) {
			logger.warn(e);
			e.printStackTrace();
		}
	}

	public void addSinger(SingerDTO singer) {
		try {
			boolean result = service.addSinger(singer);
			logger.info("admin add singer");
			if (result == false) {
				EndView.failView("저장실패");
				logger.warn("admin fail to add singer");
			}
		} catch (Exception e) {
			logger.warn(e);
			e.printStackTrace();
		}
	}

	public void addSingersFromFile(String f) {
		try {
			logger.info("admin add singer from file");
			service.addSingersFromFile(f);
		} catch (Exception e) {
			logger.warn(e);
			e.printStackTrace();
		}
	}

	public void addUser(UserDTO user) {

		boolean result;

		try {
			result = service.addUser(user);
			logger.info("admin add user");

			if (result) {
				EndView.successView("등록되었습니다.");
			} else {
				EndView.failView("등록실패");
				logger.warn("admin fail to add user");
			}
		} catch (SQLException e) {
			logger.warn(e);
			e.printStackTrace();
		}
	}

	public void addNewSong(String date) {

		boolean result;

		try {
			result = service.addNewSong(date);

			logger.info("admin update new song chart");

			if (result) {
				EndView.successView("최신차트 갱신 성공");
			} else {
				logger.warn("admin fail to update new song chart");
				EndView.failView("최신차트 갱신 실패");
			}
		} catch (SQLException e) {
			logger.warn(e);
			e.printStackTrace();
		}
	}

	public void updatePopularChart() {

		try {
			boolean result = service.updatePopularChart();
			logger.info("admin update popular chart");

			if (result) {
				EndView.successView("인기차트 갱신");
			} else {
				logger.info("admin fail to update popular chart");
				EndView.failView("인기차트 갱신 실패");
			}
		} catch (SQLException e) {
			logger.warn(e);
			e.printStackTrace();
		}
	}

	public void getNew() {
		try {
			logger.info("admin get new song chart");
			ArrayList<PrintSongDTO> songList = service.getNew();
			EndView.showSongList(songList);

			EndView.Message("곡 번호를 입력해주세요");
			PrintSongDTO aim = songList.get(sc.nextInt() - 1);

			logger.info("admin select song" + aim.getId());

			EndView.Message("1.듣기\t2.삭제\t0.종료");

			int req = sc.nextInt();
			if (req == 1) {
				logger.info("admin listen to song " + aim.getId());
				EndView.watchMovie(aim.getName(), aim.getSinger());
			} else if (req == 2) {
				logger.info("admin delete song " + aim.getId());
				service.deleteSong(aim.getId());
			} else if (req == 0) {
				return;
			} else {
				logger.warn("fail to find song");
				EndView.failView("잘못된 입력값입니다.");
			}

		} catch (Exception e) {
			logger.warn(e);
			e.printStackTrace();
		}
	}

	public void getPopular() {

		try {
			ArrayList<PrintSongDTO> songList = service.getPopular();
			EndView.showSongList(songList);

			EndView.Message("곡 번호를 입력해주세요");
			PrintSongDTO aim = songList.get(sc.nextInt() - 1);

			EndView.Message("1.듣기\t2.삭제\t0.종료");

			int req = sc.nextInt();
			if (req == 1) {
				logger.info("admin listen to song " + aim.getId());
				EndView.watchMovie(aim.getName(), aim.getSinger());
			} else if (req == 2) {
				logger.info("admin delete song " + aim.getId());
				service.deleteSong(aim.getId());
			} else if (req == 0) {
				return;
			} else {
				logger.warn("fail to find song");
				EndView.failView("잘못된 입력값입니다.");
			}

		} catch (Exception e) {
			logger.warn(e);
			e.printStackTrace();
		}
	}
}
