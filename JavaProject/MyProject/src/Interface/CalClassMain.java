package Interface;

import java.util.Scanner;

public class CalClassMain {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int n1 = 0;
		int n2 = 0;
		
		System.out.print("첫 번째 숫자를 입력하세요. >>>");
		n1 = s.nextInt();
		System.out.print("두 번째 숫자를 입력하세요. >>>");
		n2 = s.nextInt();
		
		Calculator calcls = new CalClass();
		
		System.out.println(n1 + " + " + n2 + " = " + calcls.add(n1, n2));
		System.out.println(n1 + " - " + n2 + " = " + calcls.substract(n1, n2));
		System.out.println(n1 + " X " + n2 + " = " + calcls.multiply(n1, n2));
		System.out.println(n1 + " / " + n2 + " = " + calcls.divide(n1, n2));	
		
	}	

	
}
