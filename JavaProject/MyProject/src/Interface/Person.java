package Interface;

import java.util.Scanner;

public class Person {

	// 1. 위 Person 클래스의 equals() 메소드를 오버라이딩해서 주민등록번호가 같으면 인스턴스로 판별하는 프로그램을 만들어봅시다.
	
	// equals() 메소드를 오버라이딩
	// 인스턴스 생성
	// 주민등록번호가 같으면 true, 아니면 false 반환

	private String name;
	private String personNumber;

	public Person(String name, String personNumber) {
		this.name = name;
		this.personNumber = personNumber;
	}

	@Override
	public boolean equals(Object obj) {
		Person p = null;
		if (obj instanceof Person) {
			p = (Person) obj;
		}
		if (p != null || this.personNumber.equals(p.personNumber)) {
			return true;
		}
		return false;

	}


	// 2. 1~100,000,000까지 더하기하는 연산의 실행 시간을 측정하는 프로그램을 만들어봅시다.
	
	

	public static void main(String[] args) {
	
		// 3. 사용자에게 이름을 입력 받아 입력 받은 문자열을 정상적인 문자열의 이름으로 표현하는지 판별하고,
		// 공백으로 입력되었는지도 판별하는 프로그램을 만들어봅시다.
		Scanner in = new Scanner(System.in);
		
		String name;
		String personNumber;
		
		Person p1 = new Person("류", "8901101111111");
		Person p2 = new Person("문", "8901101111111");
		
	

		System.out.print("이름 >");
		name = in.nextLine();
		

	}





	// 4. 자신의 생일을 기준으로 오늘까지 몇 일을 살았는지 출력하는 프로그램을 만들어봅시다.

	
	
}
