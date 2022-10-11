package chao10Exc;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {

		// 1. 콘솔에서 사용자 아이디를 입력 받아
		// 정상적인 영문자와 숫자로만 이루어진 값을 입력했는지 확인하는 프로그램을 만들어봅시다.
		// ① 사용자 예외 클래스를 정의해서 예외를 발생 시켜 봅시다.
		// ② 예외 클래스 이름은 BadIdInputException이라고 정의합시다.

		Scanner scan = new Scanner(System.in);

		int birthYear = 0;
		String userID;

		System.out.print("ID > ");
		try {
			userID = scan.nextLine();
			System.out.println();

			for (int i = 0; i < userID.length(); i++) {

				char c = userID.charAt(i);

				if (!(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9')) {
					throw new BadIdInputException();
				}
			}
			System.out.println(userID);

		} catch (BadIdInputException e) {
			System.out.println("Exception!!" + e.getMessage());
		}

		// 2. Scanner 클래스로 태어난 년도를 입력 받을 때 int 타입으로 받도록 합시다.
		// 이때 nextInt() 메소드를 사용하게 되는데 이때 발생하는 예외처리를 하도록 합시다

		System.out.print("태어난 년도 4자리를 입력하세요. >");

		try {

			birthYear = scan.nextInt();
			System.out.println("태어난 년도 : " + birthYear);

		} catch (InputMismatchException e) {

			System.out.println("Error!");
			System.out.println("숫자만 입력 가능합니다.");

		}
		
		scan.close();
		
	}

}
