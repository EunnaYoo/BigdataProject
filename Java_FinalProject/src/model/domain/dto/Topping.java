package model.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Topping {
	
	String name;
	int price;
	
	@Override
	public String toString() {
		return name + " " + price + "¿ø";
	}
}
