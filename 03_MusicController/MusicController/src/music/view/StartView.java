package music.view;

import java.util.Scanner;

import music.controller.AdminController;
import music.controller.UsersController;
import music.model.dto.SingerDTO;
import music.model.dto.SongDTO;
import music.model.dto.UserDTO;

public class StartView {
	
	public static void main(String[] args) {
		
		boolean req = false;
		
		Scanner sc = new Scanner(System.in);
		EndView.Message("id를 입력해주세요");
		String logInId = sc.next();
		
		if(logInId.equals("admin")) {
			
			AdminController controller = AdminController.getInstance();
			
			while(!req) {
				
				EndView.Message("1. 곡 검색\t2. 가수 검색\t3. 곡 추가\t4. 곡 파일 추가\t"
								+ "5. 가수 추가\n6.가수 파일 추가\t7.유저 추가\t8. 최신차트 갱신\t9. 인기차트 갱신\t0. 종료");
				
				EndView.Message("사용할 기능의 번호를 입력해주세요");
				int reqNumber = sc.nextInt();
				if (reqNumber == 1) {
					EndView.Message("곡 명을 입력해주세요");
					controller.printSongList(sc.next());
					
				} else if(reqNumber == 2) {
					EndView.Message("가수명을 입력해주세요");
					controller.getSingerList(sc.next());
					
				} else if(reqNumber == 3) {
					EndView.Message("곡 번호");
					int id=sc.nextInt();
					EndView.Message("곡명");
					String name=sc.next();
					EndView.Message("가수번호");
					int singer=sc.nextInt();
					EndView.Message("발매일(yyyy.mm)");
					String date=sc.next();
					controller.addSong(new SongDTO(id,name,singer,date,0));
					
				} else if(reqNumber == 4) {
					controller.addSongFromFile("C:\\Git\\MusicController\\songLista.txt");
					
				} else if(reqNumber == 5) {
					EndView.Message("가수 번호");
					int id=sc.nextInt();
					EndView.Message("가수명");
					String name=sc.next();
					controller.addSinger(new SingerDTO(id,name));
					
				} else if(reqNumber == 6) {
					controller.addSingersFromFile("C:\\Git\\MusicController\\singerList.txt");
					
				} else if(reqNumber == 7) {
					EndView.Message("id");
					String id=sc.next();
					EndView.Message("이름");
					String name=sc.next();
					EndView.Message("비밀번호");
					String password=sc.next();
					controller.addUser(new UserDTO(id,name,password));
					
				} else if(reqNumber == 8) {
					EndView.Message("발매일(yyyy.mm)");
					String date=sc.next();
					controller.addNewSong(date);
					controller.getNew();
					
				} else if(reqNumber==9) {
					controller.updatePopularChart();
					controller.getPopular();
					
				} else if(reqNumber==0){
					req=true;
					
				} else {
					EndView.failView("잘못된 요청입니다");
				}
			}
			
		} else {
			
			UsersController controller = UsersController.getInstance();
			
			while(!req) {
				EndView.Message("1. 곡 검색\t2. 가수 검색\t3. 내 목록\t 4. 신곡\t5. 인기차트\n0. 종료");
				int reqNumber=sc.nextInt();
				if(reqNumber == 1) {
					EndView.Message("곡 명을 입력해주세요");
					controller.printSongList(sc.next(),logInId);
					
				} else if(reqNumber == 2) {
					EndView.Message("가수 명을 입력해주세요");
					controller.getSingerList(sc.next());
					
				} else if(reqNumber == 3) {
					controller.getMyList(logInId);
					
				} else if(reqNumber == 4) {
					controller.getNew();
					
				} else if(reqNumber == 5) {
					controller.getNew();
					
				} else if(reqNumber == 0) {
					req=true;
					
				} else {
					EndView.Message("잘못된 요청입니다");
				}
			}
		}
	}
}
