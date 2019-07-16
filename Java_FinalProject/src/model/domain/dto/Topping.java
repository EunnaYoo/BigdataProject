package model.domain.dto;

import lombok.Data;

@Data
public class Topping {
	
	String name;
	int price;
	
	@Override
	public String toString() {
		return name + " " + price + "¿ø";
	}

	public Topping(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
}
