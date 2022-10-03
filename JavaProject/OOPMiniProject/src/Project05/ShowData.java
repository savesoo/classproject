package Project05;

public interface ShowData {
	
	// 프로젝트-3 에서 구현한 상속 구조를 기초로 Contact 클래스를 추상클래스로 만들어봅시다.

	// 1. ShowData인터페이스에 추상 메소드 void showData() 정의되어 있는 구조
	// 2. Contact클래스가 ShowData인터페이스를 상속하면서 추상 메소드를 보유하는 관계로 생성
	// 3. Contact클래스는 추상 메소드를 가지고 있어 추상클래스가 되는 형태로 정의
	// 4. SmartPhone클래스에 있는 배열의 타입이 추상클래스로 되어도 문제가 없는 것을 확인
	
	// 추상 메소드 정의
	
	
	void showData();

}
