package chapter02;

public class VariableRealNumber {
	
	public static void main(String[] args) {
		
		// 실수 타입 : double,  float
		// 			 8byte	  4byte
		// int 4byte, long 8byte
		// byte는 크지만 long이 float보다 크다고 보지 않음: float이 더 많은 수를 표현할 수 있기 때문
		// 표현 범위의 차이
		
		// double 타입
		double num1 = 0.3d; // num1 = double 타입의 데이터
		double num3 = 1.1234567891023456789;
		
		System.out.println(num1);
		System.out.println(num3);
		
		// float 타입
		float num2 = 0.3f; // num2 = double 타입의 데이터
		float num4 = 1.1234567891023456789f;
		
		System.out.println(num2);
		System.out.println(num4);
		
		double num5 = 1.1;
		double num6 = 1.3;
		
		double result = num5 + num6;
				
		System.out.println(result);
		
	}

}
