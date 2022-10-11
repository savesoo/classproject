package methodStudy;

import java.util.Scanner;

public class CheckAge {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int age;
		
		System.out.print("나이를 입력하세요.>>> ");
		age = in.nextInt();
		System.out.println();
		
		checkAge(age);
		
		in.close();

	}
	public static void checkAge(int curAge) {

		if(curAge<=5) {
			System.out.println("유아입니다.");
		} else if(curAge>=6 && curAge<13) {
			System.out.println("어린이입니다.");
		} else if(curAge>=13 && curAge<18) {
			System.out.println("청소년입니다.");
		} else {
			System.out.println("성인입니다.");
		}
	}

}
