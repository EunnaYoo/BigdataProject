package model.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ramen {
	
	private String name;
	private int price;
	private String time;
	//private String type;
	
	@Override
	public String toString() {
		return name + "\t" + price + "¿ø" + "\t" + time;
	}
}
