package chapter09.exam;

public class Person {

	String name;
	String personNumber;
	
	public Person(String name, String personNumber) {
		super();
		this.name = name;
		this.personNumber = personNumber;
	}

	// 주민등록번호가 같으면 같은 인스턴스로 판별하는 프로그램을 만들어봅시다
	// "000000-0000000" 14자리가 들어오는 것으로 가정
	@Override
	public boolean equals(Object obj) {
		boolean result = false; // 반환해야하는 값 미리 생성
		
		// 매개변수로 전달받은 객체와 비교 : 주민등록번호
		if(obj != null && obj instanceof Person) {
			// Object -> Person
			Person person = (Person)obj;
			result = this.personNumber.equals(person.personNumber);
		}
		
		return result; // 여러 개의 return을 만들지 않기 위해
	}
	
	public static void main(String[] args) {
		
		Person p1 = new Person("류","000000-1111111");
		Person p2 = new Person("문", "000000-1111111");
		Person p3 = new Person("류", "111111-7777777");
		
		System.out.println("p1과 p2는 같은 사람인가? -> " + p1.equals(p2)); 
		// 여러 데이터가 있을 때 어떤 걸 비교할지 조건을 위에서 정해둠 -> 따라서 간단히 equals 메소드만 사용해도 결과 도출
		System.out.println("p1과 p3은 같은 사람인가? -> " + p1.equals(p3));
		
	}
	
	
	
	

}
