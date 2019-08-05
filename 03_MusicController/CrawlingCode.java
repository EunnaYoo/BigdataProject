package step01.jsoup;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Karaoke2 {
	public static void main(String[] args) {
	Document doc = null;
	
	String address = "http://www.ikaraoke.kr/isong/search_index.asp?page=";
	String address2 = "&SelType=2&s_value=%A4%A1&keyIdx=2";
	int index = 1;
	
	for (int i=1; i<211; i++) {
		try {
			doc = Jsoup.connect(address+i+address2).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		System.out.println(doc.title());
		Elements newsHeadlines = doc.select("#contentcolumn > form > div.tbl_board > table > tbody > tr");
		for (Element headline : newsHeadlines) {
			if(!headline.select("td.pl8 > a").attr("title").equals("")) {
//				System.out.println((index+1)+". " +headline.select("td.pl8 > a").attr("title")
//						+" "+ headline.select("td.tit.pl8").text());
				try {
					BufferedWriter fw = new BufferedWriter(new FileWriter("songList.txt", true));
					fw.write(headline.select("td.ac").get(1).text()+"\t"+headline.select("td.pl8 > a").attr("title").replace("'/", "")
							+"\t"+ headline.select("td.tit.pl8").text().replace("'/", "")
							+"\t"+ headline.select("td.ac").get(2).text() 
							);
//					fw.write("insert into song values("+index+",\'"+headline.select("td.pl8 > a").attr("title").replace("'/", "")
//							+"\',\'"+ headline.select("td.tit.pl8").text().replace("'/", "")
//							+"\',"+"\'"+ headline.select("td.ac").get(2).text() +"\'"
//							+",\'aaaaaaaaaa\');\n");
//					System.out.println(headline.select("td.ac").get(2).text());
					fw.flush();
					fw.close();
					index++;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		index+=1; 
//		System.out.println(index);
	}
	
	}
}
