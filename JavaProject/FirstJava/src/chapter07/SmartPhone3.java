package chapter07;

public class SmartPhone3 extends Phone {

	String model;

	SmartPhone3(String phoneNumber, String model) {
		super(phoneNumber);
		this.model = model;
	}
	
	// 오버라이딩
	// 상위 클래스에서 정의한 메소드를 재정의
	// 선언부는 동일하게 정의하고 처리블록 내부의 코드만 재정의
	@Override
	void call() {
		super.call();
		System.out.println("에어팟을 이용해서 통화합니다.");
		System.out.println("현재 사용중인 모델은 : " + model);
		//System.out.println("하위 클래스에서 재정의");
	}
	
	// 새롭게 정의한 메소드
	void playMusic() {
		System.out.println("Compelte가 플레이됩니다.");
	}
	
	
	
	public static void main(String[] args) {
		
		// 다형성
		// 상속관계에 있는 클래스들 간에 인스턴스 생성과 참조변수간의 정의
		// 조상클래스타입의 변수 = new 자손타입의 클래스();
		
		Phone phone = new SmartPhone3("010-7777-4444", "IOS");
		Phone phone2 = new SmartPhone2("010-8888-1111", "android");
		Phone phone3 = new SmartPhone();
		// 조상 타입의 참조변수 선언은 조상타입의 멤버만 사용하겠다를 정의한 것!
		
		System.out.println(phone.phoneNumber);
		phone.call();
		//System.out.println(phone.model);
		//phone.palyMusic();
	}


}
