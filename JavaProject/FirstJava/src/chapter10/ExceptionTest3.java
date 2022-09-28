package chapter10;

public class ExceptionTest3 {
	
	public static void main(String[] args) { // 큰 흐름을 만들어주는 곳에서 예외 처리를 담당하는 것이 바람직함
		try {
			check1();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
	}
	
	static void check1() throws ClassNotFoundException { // 나도 안할래 다른 쪽에서 처리할 거야
		check2(); // 호출한 쪽에서 예외 처리 해줘.
	}
	
	static void check2() throws ClassNotFoundException { // 네가 예외처리해 -> 안할래!
		
		Class.forName("NULL"); // 이 메소드 호출하면서 이름이 없으므로 예외 발생
		
	}

}
