package model.domain;

public class Student {
	
	String name, gender, major;
	int age;
	
	// »ý¼ºÀÚ
	public Student() {}

	public Student(String name, int age, String gender, String major) {
		this.name = name;
		this.gender = gender;
		this.major = major;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return name + " " + age + " " + gender + " " + major ;
	}

}
