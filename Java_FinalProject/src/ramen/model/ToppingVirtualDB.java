package ramen.model;

import java.util.ArrayList;

import model.domain.dto.Topping;

public class ToppingVirtualDB {
	
	private static ToppingVirtualDB instance = new ToppingVirtualDB();
	private ArrayList<Topping> toppingList = new ArrayList<Topping>();
	
	private ToppingVirtualDB() {
		
		toppingList.add(new Topping("치즈", 300));
		toppingList.add(new Topping("햄", 500));
		toppingList.add(new Topping("계란", 200));
		toppingList.add(new Topping("만두", 800));
		toppingList.add(new Topping("떡", 500));
		toppingList.add(new Topping("토핑없음", 0));
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
