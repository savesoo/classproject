package chapter10;

public class ExceptionClassTest2 {

	// try~catch 구문 합치기
	public static void main(String[] args) {

		int[] arr = new int[3];
		String str = null;
		
		try {
			Class cl = Class.forName("Test");
			
			int num = 10 / 0;
			
			arr[3] = 10;
			
			String[] names = new String[-1];
			
			System.out.println(str.toString());

		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
		} catch (ArithmeticException e) {

		} catch (ArrayIndexOutOfBoundsException e) {

		} catch (NegativeArraySizeException e) {

		} catch (NullPointerException e) {

		}

	}

}
