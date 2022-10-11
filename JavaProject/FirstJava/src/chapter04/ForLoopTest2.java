package chapter04;

public class ForLoopTest2 {
	
	public static void main(String[] args) {
		
		// 2단
		// 2 X 1 = 2
		// 2 X 2 = 4
		// ......
		// 2 X 9 = 18  <- 패턴이 보임(순차적이다!) 2 X i + 2*i
		// 3 X 1 = 3
		// 3 X 2 = 6
		// ......
		// 3 X 9 = 27
		// ......
		// 9 X 1 = 9
		// ......
		// 9 X 9 = 81 

		// 단의 반복 : 2~9
		for(int i=2; i<=9; i++) {
			System.out.println(i+ "단");
			System.out.println("----------");
			for(int j=1; j<=9; j++) {
				System.out.println(i + " X " + j + " = " + i*j);
			}
			
			System.out.println("----------");
			
			
			
			
//		 2단~
//		for(int i=1; i<=9; i++) {
//			System.out.println("2 X " + i + " = " + 2*i);	
//		}

		}
	}

}
