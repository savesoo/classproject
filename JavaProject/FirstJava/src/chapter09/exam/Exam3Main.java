package chapter09.exam;

import java.util.Scanner;

public class Exam3Main {

	// 3. 사용자에게 이름을 입력 받아 입력 받은 문자열을 정상적인 문자열의 이름으로 표현하는지 판별하고,
	// 공백으로 입력되었는지도 판별하는 프로그램을 만들어봅시다.

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("이름을 입력하세요 > ");
		String name = sc.nextLine();

		// if (name.trim().length()==0) {  공백이 0이니?
		if (name.trim().isEmpty()) {   // 공백을 제거하면 비어있니?
			System.out.println("공백은 허용하지 않습니다.");
		} else {

			if (checkName(name)) {
				System.out.println(name);
			} else {
				System.out.println("이름은 영문의 대소문자만 입력이 가능합니다.");
			}
		}

		// System.out.println(name); // 문자열을 하나하나 체크할 수 있다!
	}

	static boolean checkName(String name) {

		boolean result = true;

		// t e 1 s t
		// 문자열의 각 문자를 비교해서 원하는 문자 타입이 아닐 때 탈출하고 결과값은 false
		// charAt(i)
		for (int i = 0; i < name.length(); i++) {

			char c = name.charAt(i);
			// 영문자 : 대문자 소문자
			if (!(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z')) { // 소문자 대문자가 아닌 경우 반복문을 빠져나감
				result = false;
				break;
			}

		}

		return result;
	}

}
