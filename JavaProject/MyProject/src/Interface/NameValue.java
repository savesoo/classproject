package Interface;

import java.util.Scanner;

public class NameValue {
	
	public static void main(String[] args) {
		
		// 3. 사용자에게 이름을 입력 받아 입력 받은 문자열을 정상적인 문자열의 이름으로 표현하는지 판별하고,
		// 공백으로 입력되었는지도 판별하는 프로그램을 만들어봅시다.
		Scanner in = new Scanner(System.in);
		
		String name;
		String personNumber;
		
		Person p1 = new Person("류", "8901101111111");
		Person p2 = new Person("문", "8901101111111");
		
	

		System.out.print("이름 >");
		name = in.nextLine();

	}


}
