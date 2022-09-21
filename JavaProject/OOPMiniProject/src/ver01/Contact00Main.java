package ver01;

import java.util.Scanner;

public class Contact00Main {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		
		// Contact00 인스턴스 생성 : 생성자를 이용한 데이터 초기화
//		Contact00 c01 = new Contact00("미나", "010-4003-1415", "mina@gmail.com", "런던", "1999-10-31", "친구");
//		System.out.println("이름 : " + c01.getName());
//		System.out.println("전화번호 : " + c01.getPhoneNumber());
//		System.out.println("이메일 : " + c01.getEmail());
//		System.out.println("주소 : " + c01.getAddress());
//		System.out.println("생일 : " + c01.getBirthday());
//		System.out.println("그룹 : " + c01.getGroup());

//		System.out.println();
//		c01.printInfo();

		// 인스턴스의 각 변수에 값을 바꾸는 메소드를 이용해서 데이터를 수정합니다.
//		c01.setName("리아");
//		c01.setPhoneNumber("010-0000-2222");

//		System.out.println();
//		c01.printInfo();

		////////////////////////////
		while (true) {
			System.out.println();
			System.out.println();
			System.out.println("1. 입력 시작 | 0. 종료");
			String select = in.nextLine();

			// 사용자 요청에 따라 프로그램 종료/진행 -> 분기 처리
			if (select.equals("0")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else if (!select.equals("1")) {
				System.out.println("올바른 요청이 아닙니다.");
				continue;
			}

			System.out.println("데이터 입력을 시작합니다.");

			System.out.print("이름 >>> ");
			String name = in.nextLine();

			System.out.print("전화번호 >>> ");
			String phoneNumber = in.nextLine();

			System.out.print("이메일 >>> ");
			String email = in.nextLine();

			System.out.print("주소 >>> ");
			String address = in.nextLine();

			System.out.print("생일 >>> ");
			String birthday = in.nextLine();

			System.out.print("그룹 >>> ");
			String group = in.nextLine();

			Contact00 c = new Contact00(name, phoneNumber, email, address, birthday, group); // 생성자 만들 때 정의한 매개변수 이름을
																								// 적용해준 것

			c.printInfo();

		}

		in.close();

	}
}
