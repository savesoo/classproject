package chapter07.exam;

import java.time.LocalDate;

public class Person {
	// Person 이라는 클래스를 정의해봅시다.
	// ① 이름을 저장하는 변수, 주민등록번호를 저장하는 변수를 정의해봅시다.
	// ② 인사하는 메소드를 정의해봅시다.
	// “안녕하세요. 저는 OOO입니다. 00살 입니다.”라는 문자열이 출력하도록 정의합시다

	String name;
	String personNumber;

	public Person(String name, String personNumber) {
		this.name = name;
		this.personNumber = personNumber;
	}

	// 나이를 반환하는 메소드, 주민등록번호는 멤버 변수인 personNumber 값을 이용해서 처리
	int getAge() {

		// 반환하는 나이값
		int result = 0;

		// 나이를 계산해서 반환하는 연산
		// 910113=1000000
		// 020422-2000000
		// 0123456789... 문자열의 index -> 문자들의 위치값
		// 태어난 년도 2자리
		String tempYear = personNumber.substring(0, 2); // "00" "99"
		String tempGender = personNumber.substring(7, 8); // 1, 2, 3, 4

		// 891111-2000000
		// 011111-3000000
		// 00 -> 2000년생 이상 -->년도 = "00" -> int + 2000 -> 문자열 int로 받아 2000이나 1900 더해줌
		// 99 -> 1900년생 이상 -->년도 = "99" -> int + 1900
		// 1 || 2 -> 1900 + 89
		// 3 || 4 -> 2000 + 01

		// Interger.parseInt("문자열"); -> int 정수 반환

		// 나이 구하기 : 올해 년도 - 태어난 년도
		// int curYear = Calendar.getInstance().get(Calendar.YEAR);
		// Date -> LocalDate, LocalDateTime, LocalTime 으로 많이 바꿔 사용(1.8 이후~)
		int curYear = LocalDate.now().getYear();

		int birthYear = Integer.parseInt(tempYear);
		int genderVal = Integer.parseInt(tempGender);

		if (genderVal == 1 || genderVal == 2) {
			result = curYear - (1900 + birthYear);
		} else if (genderVal == 3 || genderVal == 4) {
			result = curYear - (2000 + birthYear);
		}

		return result;
	}

	void printInfo() {
		System.out.printf("안녕하세요. 저는 %s입니다. %d살 입니다.", this.name, getAge());
	}

	public static void main(String[] args) {

		LocalDate curDate = LocalDate.now(); // 현재시각 불러오기
		System.out.println(curDate);
		System.out.println(curDate.getYear());

		int curYear = LocalDate.now().getYear(); // 올해 년도

		Person p = new Person("kim", "940422-1000000");
		p.printInfo();
	}

}
