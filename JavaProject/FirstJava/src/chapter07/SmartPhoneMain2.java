package chapter07;

public class SmartPhoneMain2 {

	public static void main(String[] args) {
		AndroidPhone androidPhone = new AndroidPhone("010-1111-1111");
		Iphone iPhone = new Iphone("010-2222-2222");
		GooglePhone googlePhone = new GooglePhone("010-3333-3333");

		callByPhone(androidPhone);
		callByPhone(iPhone);
		callByPhone(googlePhone);
		
	}
	
	static void callByPhone(Phone phone) {
		// 메소드의 매개변수
		// Phone phone = androidPhone;
		phone.call();
	}

	// 안드로이드 폰
//	static void callByPhone(AndroidPhone phone) {
//		phone.call();
//	}

	// 아이폰
//	static void callByPhone(Iphone phone) {
//		phone.call();
//	}

	// 구글폰
//	static void callByPhone(GooglePhone phone) {
//		phone.call();
//	}
	
}
