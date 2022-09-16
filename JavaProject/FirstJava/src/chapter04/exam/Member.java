package chapter04.exam;

import java.util.Calendar;
import java.util.Scanner;

public class Member {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		while (true) {

			System.out.print("출생 년도를 입력해주세요. 종료는(0) >>>");

			int year = in.nextInt();

			if (year == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
				//return; // 메소드의 종료, 반환
				// main 메소드의 종료는 프로그램의 종료
			}

			System.out.println();
			System.out.println("조회 결과");
			System.out.println("------------");
			checkVaccine(year);
			checkMedical(year);
			System.out.println("------------");
			System.out.println();
			
		}
		
		in.close();

	}

	/*
	 * ② 건강검진 대상 여부를 판별하고 어떤 검진이 가능한지 확인하는 메소드를 정의합니다. >> boolean - 매개변수로 태어난 해(년도)를
	 * 전달받습니다. - 대한민국 성인( 20세 )의 경우 - 무료로 2년마다 건강검진을 받을 수 있습니다. - 짝수 해에 태어난 사람은 올해가
	 * 짝수년이라면 검사 대상이 됩니다. : 태어난 해의 %2 결과값과 올해 년도의 %2 값이 일치한다 -> 2022%2 == birth%2 -
	 * 40 이상의 경우는 암 검사도 무료로 검사를 할 수 있습니다. : if 중첩
	 */

	public static void checkMedical(int birthYear) {

		// 올해 년도
		int curYear = Calendar.getInstance().get(Calendar.YEAR);

		// 나이
		int age = curYear - birthYear + 1;

		System.out.println("나이 : " + age);

		if (age >= 20) {

			if (curYear % 2 == birthYear % 2) {
				System.out.println("무료 검진이 가능합니다.");

				if (age >= 40) {
					System.out.println("무료 암 검진이 가능합니다.");
				}
			} else {
				System.out.println("무료 검진 대상이 아닙니다.");
			}

		} else {
			System.out.println("20세 미만은 무료 검진 대상이 아닙니다.");
		}

	}

	/*
	 * ① 독감예방 접종이 가능한지 여부를 확인하는 메소드를 정의합니다. >> boolean - 매개변수로 태어난 해(년도)를 전달받습니다. -
	 * 15세 미만의 경우와 65세 이상의 경우 “무료예방접종이 가능합니다.” 메시지가 콘솔에 출력하도록 합니다. - 위에서 정의한 조건의 범위가
	 * 아닌 나머지의 경우 “무료접종 대상이 아닙니다.”라고 출력하도록 합니다.
	 */

	public static void checkVaccine(int birthYear) {

		// 올해 년도
		int currYear = Calendar.getInstance().get(Calendar.YEAR);

		// 나이 계산
		int age = currYear - birthYear + 1; // 만 나이 아닌 경우 +1 적용

		System.out.println("나이 : " + age);

		if (age < 15 || age >= 65) {
			System.out.println("무료 예방접종이 가능합니다.");
		} else {
			System.out.println("무료 접종 대상이 아닙니다.");
		}

	}

}
