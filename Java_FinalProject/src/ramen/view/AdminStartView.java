package ramen.view;

import controller.AdminController;
import model.domain.dto.Ramen;

public class AdminStartView {

	public static void main(String[] args) {

		AdminController controller = AdminController.getInstance();

		controller.ramenListView();
 
		System.out.println();
		controller.insertRamen(new Ramen("너구리", 3000, "4분"));
		
		System.out.println();
		controller.ramenListView();
		System.out.println();
		controller.oneRamenView("쫄면");
		System.out.println();
		
		controller.updateRamenPrice("불닭볶음면");
		System.out.println();
		controller.ramenListView();
		System.out.println();
		
		controller.deleteRamen("너구리");
		System.out.println();
		controller.ramenListView();
		System.out.println();
		
		System.out.println("라면 데이터 JSON으로 가져오기");
		controller.JsonListView();
	}
}
