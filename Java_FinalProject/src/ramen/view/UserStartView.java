package ramen.view;

import controller.UserController;

public class UserStartView {
	
	public static void main(String[] args) {
		
		UserController controller = UserController.getInstance();
		
		controller.ramenListView();
		System.out.println();
		
		controller.toppingListView();
		System.out.println();
		
		controller.oneRamenView("½Å¶ó¸é");
		System.out.println();
		
		controller.oneToppingView("¶±");
		System.out.println();
		
		controller.totPay("½Å¶ó¸é", "¶±", 1000);
		System.out.println();
		
		controller.process();
		System.out.println();
	}
}
