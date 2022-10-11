package chapter07;

public class SmartPhone extends Phone {

	// 하위 클래스 : 상위 클래스 멤버 + 새로운 멤버 정의
	String model;

	SmartPhone() {
		super("010-7777-4444"); // 상위 클래스의 생성자를 호출하는 키워드 -> 생성자는 상속의 대상이 아니기 때문
		this.model = "IOS";
	}

	// 전화번호만 초기화
	SmartPhone(String phoneNumber, String model) {
		super(phoneNumber);
		this.model = "android";
	}

	void paly() {
		System.out.println("app을 실행합니다.");
	}

	public static void main(String[] args) {

		// SmartPhone sp = new SmartPhone("010-0313-0422"); // 이렇게 출력하면 String이 하나인 생성자가
		// 없으므로 오류
		SmartPhone sp = new SmartPhone(); // 전화번호, 모델 모두 초기값으로 출력
		// SmartPhone sp = new SmartPhone("010-7777-4444", "Google"); // 전화번호, 모델의 데이터를
		// 다 넣어주는 경우

		System.out.println(sp.phoneNumber);
		sp.call();
		System.out.println(sp.model);
		sp.paly();

	}

}
