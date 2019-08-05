package music.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor@AllArgsConstructor
public class SongDTO {
	
	private int id;
	private String name;
	private int singer;
	private String date;
	private int popularity;
	
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("곡 번호 : ");
		builder.append(id);
		builder.append(" , 제목 : ");
		builder.append(name);
		builder.append(" , 가수 : ");
		builder.append(singer);
		builder.append(" , 발매일 : ");
		builder.append(date);
		return builder.toString();
	}
}
