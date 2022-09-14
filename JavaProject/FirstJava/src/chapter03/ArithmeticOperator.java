package chapter03;

public class ArithmeticOperator {

	public static void main(String[] args) {
		
		int num1 = 15;
		int num2 = 4;
		float num3 = 2.0f;
		
		System.out.println(num1 + num2);
		System.out.println(num1 - num2);
		System.out.println(num1 * num2);
		System.out.println(num1 / num2); // int + int -> int 실수 표현X, 정수값 도출 
		System.out.println(num1 / num3); // int + float -> float+float 변환
		System.out.println(num1 % num2);
		System.out.println(num1 % num3);
		
		int result = num1 / 0;

	}

}

