package methodStudy;

import java.util.Scanner;


public class CalculateCircle {

	public static void main(String[] args) {
				
		Scanner in = new Scanner(System.in);
		
		double rad;
		
		System.out.print("반지름 : ");
		rad = in.nextDouble();
		System.out.println();
		
		System.out.println("원의 둘레 : " + circum(rad));
		System.out.println("원의 넓이 : " + cirArea(rad));
		System.out.println();
		
		int numA;
		int numB;
		
		System.out.print("숫자 A : ");
		numA = in.nextInt();
		System.out.print("숫자 b : ");
		numB = in.nextInt();
		System.out.println();
	
		System.out.println("A + B = " + add(numA, numB));
		System.out.println("A - B = " + sub(numA, numB));
		System.out.println("A X B = " + mul(numA, numB));
		System.out.println("A / B = " + div(numA, numB));
		
		in.close();

	}
	public static double circum(double r) {
		return 2 * 3.14 * r;
	}
	public static double cirArea(double r) {
		return 3.14 * r * r;
	}
	

	public static long add(long num1, long num2) {
		return num1 + num2;
	}
	public static long sub(long num1, long num2) {
		return num1 - num2;
	}
	public static long mul(long num1, long num2) {
		return num1 * num2;
	}
	public static double div(double num1, double num2) {
		return num1 / num2;
	}

}
