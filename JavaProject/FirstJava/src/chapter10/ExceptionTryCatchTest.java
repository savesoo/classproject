package chapter10;

import java.util.Scanner;

public class ExceptionTryCatchTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("숫자 1을 입력하세요.>> ");
		int num1 = sc.nextInt();

		System.out.println("숫자 2를 입력하세요.>> ");
		int num2 = sc.nextInt();

		try {
			System.out.println("num1/num2 = " + num1 / num2); // <-예외가 발생할 수 있는 위치
			String str = null;
			// System.out.println(str.length());

		} catch (ArithmeticException e) {
			System.out.println("0으로 나누는 것은 불가합니다.");
			e.printStackTrace(); // 예외 발생 시점의 클래스와 경로, 메소드 호출 이력 알려줌
			System.out.println(e.getMessage()); // 예외에 맞는 메시지(String)를 반환
			return;
		} catch (NullPointerException e) {
			System.out.println("!null!");
		} catch (Exception e) {
			System.out.println("!예외발생!");
		} finally {
			// return
			System.out.println("무조건 실행하는 블록입니다.");
		}

		// try{} finally{} , try{} catch{}, try{} catch{} finally{}
		
		System.out.println("프로그램 처리 완료");
		// 예외가 발생해서 종료된 것이 아니라 예외가 발생하더라도 프로그램의 흐름에 따른 종료임

	}

}
