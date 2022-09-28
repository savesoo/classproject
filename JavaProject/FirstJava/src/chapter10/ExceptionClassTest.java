package chapter10;

public class ExceptionClassTest {

	public static void main(String[] args) {

		try {
			Class cl = Class.forName("Test");
		} catch (ClassNotFoundException e) {

			// e.printStackTrace();
		}

		try {
			int num = 10 / 0;
		} catch (ArithmeticException e) {

		}

		int[] arr = new int[3];
		try {
			arr[3] = 10;
		} catch (ArrayIndexOutOfBoundsException e) {

		}

		try {
			String[] names = new String[-1]; // checked Exception이 아닌 경우
		} catch (NegativeArraySizeException e) {

		}
		
		String str = null; // 매개변수로 참조값을 전달받을 때 아무것도 받지 못한 경우가 존재
		try {
			System.out.println(str.toString()); // null이어서 toString 사용불가
		} catch (NullPointerException e) {
			
		}
		

	}

}
