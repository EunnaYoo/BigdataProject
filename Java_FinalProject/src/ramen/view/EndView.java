package ramen.view;

import java.util.ArrayList;

import model.domain.dto.Ramen;
import model.domain.dto.Topping;
import net.sf.json.JSONArray;

public class EndView {
	
	public static void ramenListView(ArrayList<Ramen> ramenList) {
		
		System.out.println("[ 라면 목록 ]");
		System.out.println("라면이름" + " " + "가격" + " " + "조리시간");
		
		for (Ramen v : ramenList) {
			if (v != null) {
				System.out.println(v.toString());
			}
		}
	}
	
	public static void toppingListView(ArrayList<Topping> toppingList) {

		System.out.println("[ 토핑 목록 ]");
		System.out.println("이름" + " " + "가격");

		for (Topping v : toppingList) {
			if (v != null) {
				System.out.println(v.toString());
			}
		}
	}
	
	public static void messageView(String message) {
		System.out.println(message);
	}

	public static void ramenView(Ramen ramen) {
		
		System.out.println("[ 선택하신 라면 ]");
		System.out.println(ramen);
	}
	
	public static void toppingView(Topping topping) {
		System.out.println("[ 선택하신 토핑 ]");
		System.out.println(topping);
	}

	public static void Processmessage(String string) {
		System.out.println(string);
	}

	public static void addPirceMessage(int ramenTopping) {
		System.out.println("지불해야 될 남은 금액은 " + ramenTopping + "원 입니다.");
	}

	public static void changePriceMessage(int change) {
		System.out.println("받으실 금액은 " + change + "원 입니다.");
	}
	
	public static void ramenJsonView(JSONArray ramenList) {
		System.out.println(ramenList);
	}
}
