package chapter02;

public class VariableTest {

	// 클래스의 시작
	public static void main(String[] args) {
		
		// 자료형 변수이름 = 데이터 ;
		int num = 1000;
		// 숫자 1000을 저장하기 위한 메모리 공간 생성, 저장 공간을 찾아갈 수 있는 주소를 가진 이름
		// 변수 선언과 초기화
		
		// 숫자
		// - 정수 : byte, short, int, long (사이즈,범위)
		// - 실수 : float, double
		// 문자 : char
		// 논리값 : boolean
		// 문자열(참조형) : String
		
		int num1 = 100; // 자료형의 기본값
		byte num2 = 100; 
		short num3 = 100;
		long num4 = 100;
		
		float num5 = 0.5f; // 0.5 -> 리터럴
		double num6 = 0.5;
		
		boolean check = true; // true, false(내부적으로 가진 상수)
	
		String str = null; // 아무 문자열이 없어! 메모리 주소를 가지고 있지 않아.
		str = "String";
		
		
	}
}
