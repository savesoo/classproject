package first;

import java.util.Calendar;

public class Person {
	
	private String name;
	private int birth;
	
	void printHello() {
		System.out.println("안녕하세요. 저는 " + name + "입니다." + (Calendar.getInstance().get(Calendar.YEAR)-birth/10000+1) +"살 입니다.");
	}

	public Person(String name, int birth) {
		this.name = name;
		this.birth = birth;
	}

}
