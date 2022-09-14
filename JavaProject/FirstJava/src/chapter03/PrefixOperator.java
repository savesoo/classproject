package chapter03;

public class PrefixOperator {

	public static void main(String[] args) {
		
		
		int num1 = 5;
		
		System.out.println("num1 : " + num1);
		
		int num2 = ++num1; // num1 =num1 + 1 선행 -> num2 = num1; 그 결과값을 대입
		
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		
		System.out.println("num1 : " + ++num1);


	}

}
