package chapter07;

public class SmartPhoneMain {

	public static void main(String[] args) {

		AndroidPhone ap = new AndroidPhone("010-0803-3827");

		Phone phone = (Phone) ap; // 하위타입 -> 상위타입 형변환일 때 형변환 연산은 생략 가능

		ap.call();

		Phone phone2 = new Phone("010-4444-4444");

		// 형변환 연산자 : 확인하고자 하는 참조변수 instanceof 확인할 타입
		System.out.println(phone2 instanceof Iphone);

		if (phone2 instanceof Iphone) {
			Iphone ip = (Iphone) phone2;
			System.out.println("아이폰으로 변경");
		} else {
			System.out.println("아이폰으로 변경 불가");
		}

		Phone phone3 = new Iphone("010-7777-7777");

		if (phone3 instanceof Iphone) {
			Iphone ip = (Iphone) phone3;
			ip.call();
		}

	}

}
