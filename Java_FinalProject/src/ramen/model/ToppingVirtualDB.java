package ramen.model;

import java.util.ArrayList;

import model.domain.dto.Topping;

public class ToppingVirtualDB {
	
	private static ToppingVirtualDB instance = new ToppingVirtualDB();
	private ArrayList<Topping> toppingList = new ArrayList<Topping>();
	
	private ToppingVirtualDB() {
		
		toppingList.add(new Topping("Ä¡Áî", 300));
		toppingList.add(new Topping("ÇÜ", 500));
		toppingList.add(new Topping("°è¶õ", 200));
		toppingList.add(new Topping("¸¸µÎ", 800));
		toppingList.add(new Topping("¶±", 500));
	}
	
	public static ToppingVirtualDB getInstance() {
		return instance;
	}

	public ArrayList<Topping> getToppingList() {
		return toppingList;
	}

	public void insertList(Topping topping) {
		toppingList.add(topping);
	}
}
