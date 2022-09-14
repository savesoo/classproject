package chapter03;

public class CharTypeOperator {

	public static void main(String[] args) {
		
		char c1 = 'A';
		
		int codeNum = c1 + 0; // char + int -> int + int = int 하위 타입은 int로 바뀜
		
		System.out.println(codeNum);
		
		System.out.println(++c1); // 66 출력 c1 = 66
		System.out.println(c1++); // 66 출력 c1 = 67
		System.out.println(++c1); // 68 출력 c1 = 68

	}

}
