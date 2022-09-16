package chapter04.exam;

public class Exam04 {

	public static void main(String[] args) {
		// 문제 4.
		// 다음 식을 만족하는 조합을 찾는 프로그램 작성. 

		// AB + BA = 99 인 숫자의 조합
		// 11A + 11B = 99 -> A+B=9 B=9-A
		// 각 자리의 수 = 0~9
		
		for(int i=0; i<10; i++) {
			System.out.println("A: " + i + "일 때, B: " + (9-i));
		}

	}

}

