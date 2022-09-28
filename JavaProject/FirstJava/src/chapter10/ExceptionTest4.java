package chapter10;

import java.util.Scanner;

public class ExceptionTest4 {

	public static void main(String[] args) {

//		Scanner sc = null;
//
//		try {
//			sc = new Scanner(System.in);
//			// .....
//		} finally {
//			if(sc != null) {
//			sc.close();
//			}
//		}
	
		try(Scanner sc = new Scanner(System.in)) // 선언된 수식이 끝나면 자동으로 close 처리하게 됨
		{
			
		} catch (Exception e) {
			
		}
		
		
		
	}

}
