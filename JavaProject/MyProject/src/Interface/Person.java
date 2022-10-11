package Interface;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Person {

	// 1. 위 Person 클래스의 equals() 메소드를 오버라이딩해서
	// 주민등록번호가 같으면 인스턴스로 판별하는 프로그램을 만들어봅시다.

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

		boolean result = false;

		if (obj != null && obj instanceof Person) {
			Person person = (Person) obj;
			result = this.personNumber.equals(person.personNumber);
		}
		return result;

	}

	
	public static void main(String[] args) {

		// 1번 문제 출력
		Person p1 = new Person("Kim", "940803-1111111");
		Person p2 = new Person("Lee", "940803-1111111");

		System.out.println("1. p1과 p2의 주민등록번호는 동일한가? ->" + p1.equals(p2));
		System.out.println();
		
		
		// 2. 1~100,000,000까지 더하기하는 연산의
		// 실행 시간을 측정하는 프로그램을 만들어봅시다.

		// 현재 시각-실행된 시점 시각=실행 시간
		// 현재 시각
		long startTime = System.currentTimeMillis();
		System.out.println("연산 시작 시간 : " + startTime);

		// 1~100,000,000까지의 합을 구하는 기능
		int sum = 0;
		for (int i = 1; i <= 100000000; i++) {
			sum += i;
		}

		// 종료 시각
		long endTime = System.currentTimeMillis();
		System.out.println("연산 종료 시간 : " + endTime);

		System.out.println("1~100,000,000까지 모두 더한 값 : " + sum);
		System.out.println("연산 실행 시간 : " + (endTime - startTime));
		
		System.out.println();

		
		
		// 3. 사용자에게 이름을 입력 받아 입력 받은 문자열을 정상적인 문자열의 이름으로 표현하는지 판별하고,
		// 공백으로 입력되었는지도 판별하는 프로그램을 만들어봅시다.

		Scanner scan = new Scanner(System.in);

		System.out.println("이름을 입력하세요. >>");
		String name = scan.nextLine();

		// 만약 입력받은 이름이 정상적인 문자열이면->pass
		// 문자열 외 공백이나 숫자가 섞여 있으면->fail
		if (name.trim().length()==0) {
			System.out.println("공백은 입력할 수 없습니다.");
			scan.close();
			return;
		} else {
			
			if (chkSpell(name)) {
				System.out.println(name);
			} else {
				System.out.println("영문의 소문자, 대문자 이외는 입력할 수 없습니다.");
			}
			
		}
		System.out.println();
		
		
		
		// 4. 자신의 생일을 기준으로 오늘까지 몇 일을 살았는지 출력하는 프로그램을 만들어봅시다.

		// 현재 날짜에서 생일만큼 뺀 값
		LocalDate birthday = LocalDate.of(1994, 4, 22);
		LocalDate curDay = LocalDate.now();

		// 지정한 날짜의 일 차이를 구함
		long myDays = ChronoUnit.DAYS.between(birthday, curDay);

		System.out.println("태어난 이후 일수 : " + myDays);

	}

	static boolean chkSpell(String name) {

		boolean result = true;

		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i); // 입력한 문자 한개씩을 문자열 끝날 때까지 비교
			if (!(c > 'a' && c <= 'z' || c > 'A' && c <= 'Z')) {
				result = false;
				break;
				// 소문자 a~z, 대문자 A~Z가 아닐시 false 반환 이후 반복문 탈출
			}
		}

		return result;
		// 조건 범위에 들어오면 true 최종 반환
	}

}
