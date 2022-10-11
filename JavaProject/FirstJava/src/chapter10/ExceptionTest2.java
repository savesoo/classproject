package chapter10;

import java.util.Scanner;

public class ExceptionTest2 {

	public static void main(String[] args) {

		// 명시적인 예외 발생!
		// throw new Exception("강제적 예외발생");

		// 국어 점수 입력 받기 : 점수 범위 -> 0~100

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("국어 점수를 입력하세요 >> ");
			int score = sc.nextInt();

			try {
				if (!(score >= 0 && score <= 100)) {
					//throw new Exception("입력한 점수는 정상 범위의 점수가 아닙니다."); // 예외 발생할 수 있는 부분 -> try로 감싸기 : 출력문장까지
					throw new BadInputException(score);
				}
				System.out.println("국어 점수는 : " + score + "점 입니다.");
				break; // 예외 발생시 실행 X
			} catch (BadInputException e) {
				System.out.println(e.getMessage());
				System.out.println("다시 입력하세요.");
				System.out.println(e.getScore());
			}

		}
	}

}
