package ramen.view;

import controller.UserController;

public class UserStartView {
	
	public static void main(String[] args) {
		
		UserController controller = UserController.getInstance();
		
		controller.ramenListView();
		System.out.println();
		
		controller.toppingListView();
		System.out.println();
		
		System.out.println("라면을 골라주십시오.");
		System.out.println();
		controller.oneRamenView("신라면");
		System.out.println();
		
		System.out.println("토핑을 골라주십시오.");
		System.out.println();
		controller.oneToppingView("떡");
		System.out.println();
		
		controller.Process();
		System.out.println();
		
		controller.addTopping("신라면", "떡");
	}

}
