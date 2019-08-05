// 주요 기능 클래스
package model;

import log.check.Log4J;
import model.domain.Student;

public class StudentModel {
	
	// 배열에 저장
	private static Student[] allData = new Student[30];
	private static int index;
	
	// 기존 데이터 넣기
	static {
		
		allData[0] = new Student("김수경", 42, "여", "경영학");
		allData[1] = new Student("유은나", 25, "여", "통계학");
		allData[2] = new Student("이정원", 27, "여", "경제학");
		allData[3] = new Student("김종성", 25, "남", "경영학");
		allData[4] = new Student("최성국", 29, "남", "물리학");
		
		index = 5; 
	}
	
	// 전체 명단 확인(getAll)
	public static Student[] getAll() {
		
		System.out.println("[ 엔코아 데이터 분석 교육 과정 명단 ]"); // 명단 상단 제목
		return allData;
	}
	
	// 한 사람 검색(getOne)
	public static Student getOne(String name) {
		
		Log4J.getInstance();
		Student v = null;;
		
		for(int i = 0; i < allData.length; i++) {
			
			v = allData[i];
			
			if(v != null && v.getName().equals(name)) {
				
				return v;
			}
		}
		
		return v;
	}
	
	// 추가 학생(Insert)
	public static boolean insert(Student v) {
		
		if(index < 30) {
			
			allData[index++] = v;
			System.out.println(v.getName() + "이(가) 등록되었습니다.");
			return true;
		}
		
		return false;
	}
	
	// 정보 변경(Update)
	public static boolean update(String name) {
		
		Student v = null;
		
		for(int i = 0; i < allData.length; i++) {

			v = allData[i];
			
			if(v != null && v.getName().equals(name)) {
				
				v.setAge(v.getAge() - 1);
				System.out.println(name + " 의 정보가 변경되었습니다.");
				return true;
			}	
		}
		
		return false;
	}	
	
	// 중도 포기(Delete)
	public static boolean delete(String name) {
		
		Student v = null;
		
		for(int i = 0; i < allData.length; i++) {
			
			v = allData[i];
			
			if(v != null && v.getName().equals(name)) {
				
				allData[i] = null;
				System.out.println(name + "이(가) 중도 포기하셨습니다.");
				return true;
			}
		}
		
		return false;
	}
}
