package music.view;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import music.controller.UsersController;

public class EndView {
	
	public static void watchMovie (String song, String singer) {
		
		Document doc = null;
		String address="https://www.youtube.com/results?search_query=";
		
		try {
			doc = Jsoup.connect(address+song+"+"+singer+"노래방").get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String finalAddress = doc.select("h3 > a").get(0).attr("href").replace("watch", "watch_popup");
		
		try {
			Runtime.getRuntime().exec(new String[]{"cmd", "/c","start chrome https://www.youtube.com"+finalAddress});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	public static void showSongList(ArrayList songList) {

		int length = songList.size();

		if (length != 0) {
			for (int index = 0; index < length; index++) {
				System.out.println("목록 " + (index + 1) + " - " + songList.get(index));
			}
		} else {
			System.out.println("해당되는 곡이 존재하지 않습니다.");
		}
	}

	public static void failView(String s) {
		System.out.println(s);
	}

	public static void successView(String s) {
		System.out.println(s);
	}

	public static void Message(String m) {
		System.out.println(m);
	}
}
