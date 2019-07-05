package view;

import controller.StudentController;

public class StartView {

	public static void main(String[] args) {
		
		StudentController.request(1);
		System.out.println();
		System.out.println(" -- 학생 검색 -- ");
		StudentController.request(2);
		System.out.println();
		System.out.println(" -- 신규 등록생 -- ");
		StudentController.request(3);
		System.out.println();
		System.out.println(" -- 학생 명단에서 제거 -- ");
		StudentController.request(4);
		System.out.println();
		System.out.println(" -- 학생 명단 수정 -- ");
		StudentController.request(5);
		System.out.println();
		System.out.println(" -- 명단 다시 확인 -- ");
		StudentController.request(1);
		
	}
}
