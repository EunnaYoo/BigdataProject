package view;

import model.domain.Student;

public class EndView {

	public static void printAll(Student[] all) {
		
		for(Student v : all) {
			
			if(v != null) {
				System.out.println(v.toString());
			}
		}
	}

	public static void printOne(Student one) {
		
			if( one != null) {
				System.out.println(one.toString());
		}
	}	
}
