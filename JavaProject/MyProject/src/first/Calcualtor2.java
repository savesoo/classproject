package first;

import java.util.Scanner;

public class Calcualtor2 {

	public static void main(String[] args) {
		
		// ⑦ main() 메소드를 정의하고 각각의 메소드를 호출해서 결과를 콘솔에 출력해봅시다.
		// ⑧ 콘솔에서 사용자에게 데이터를 받아 메소드를 호출할 때 사용자에게 받은 데이터를 메소드의 매개변수의 인자로 전달하는 코드를 main() 메소드
		
		int num1 = 422;
		int num2 = 113;
		
		add(num1,num2);
		sub(num1,num2);
		mul(num1,num2);
		div(num1,num2);
		
		System.out.println("원의 둘레 : " + cir(5));
		System.out.println("원의 넓이 : " + area(8));
		
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("아이디를 입력하세요. >> ");
		String id = in.nextLine();
		System.out.println("아이디 : " + id);
		
		System.out.print("비밀번호를 입력하세요. >> ");
		String pw = in.nextLine();
		System.out.println("비밀번호 : " + pw);
		
		in.close();
		
	}
	
	// ① 정수 두 개를 매개변수의 인자로 전달받아 더하기연산 후 출력하는 메소드를 정의
	public static void add(int num1, int num2) {
		System.out.println(num1 + num2);
	}
	
	// ② 정수 두 개를 매개변수의 인자로 전달받아 빼기연산 후 출력하는 메소드를 정의
	public static void sub(int num1, int num2) {
		System.out.println(num1 - num2);
	}
	
	// ③ 정수 두 개를 매개변수의 인자로 전달받아 곱하기연산 후 출력하는 메소드를 정의
	public static void mul(int num1, int num2) {
		System.out.println(num1 * num2);
	}
	
	// ④ 정수 두 개를 매개변수의 인자로 전달받아 나누기연산 후 출력하는 메소드를 정의
	public static void div(double num1, double num2) {
		System.out.println(num1 / num2);
	}
	

	// ⑤ 실수 반지름 하나를 매개변수의 인자로 전달받아 원의 둘레를 구해 반환하는 메소드를 정의
	public static double cir(double r) {
		return 2*r*3.14;
	}
	
	// ⑥ 실수 반지름 하나를 매개변수의 인자로 전달받아 원의 넓이를 구해 반환하는 메소드를 정의
	//   원의 둘레 : 2 x π x r , 월의 넓이 : π x r x r
	public static double area(double r) {
		return r*r*3.14;
	}

}
