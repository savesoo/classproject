package chapter05;


// 클래스는 인스턴스를 생성하기 위한 설계도 역할을 한다.
// 클래스에서 정의한 변수, 메소드는 바로 사용이 불가하다!!!
// 클래스로 인스턴스를 만들어서 사용한다!!!
// class 정의는 class 키워드를 사용해서 정의한다!
public class SmartPhone {
	
	// 스마트폰 인스턴스를 만들기 위한 설계도 역할
	
	// 클래스는 변수와 메소드로 구성한다.
	// 생성자 : 필수이지만 생략 가능
	
	// 클래스의 멤버 : 변수, 메소드
	// 클래스 내부에 정의된 변수 : 멤버 변수, 인스턴스 변수(인스턴스가 만들어져야 사용가능하므로)
	// 클래스 내부에 정의된 메소드 : 멤버 메소드, 인스턴스 메소드
	
	// 스마트 폰의 속성 : 컬러, 사이즈, 제조사, 볼륨 사이즈
	// 속성 -> 변수
	String color; // 인스턴스 변수, 초기화 생략 가능 -> 인스턴스 생성 시에 초기값으로 할당
	float size; // 0.0
	String company; // null
	int volumeSize; // 0이 초기값
	
	// 전화 걸기
	void call() {
		System.out.println("전화 걸기!");
	}
	
	// 볼륨 키우기
	void volumeUp() {
		System.out.println("볼륨을 키웁니다.");
		volumeSize++;
	}
	
	// 볼륨 줄이기
	void volumeDown() {
		System.out.println("볼륨을 줄입니다.");
		volumeSize--;
	}
	
	void showInfo() {
		System.out.println("폰 정보");
		System.out.println("제조사 : " + company);
		System.out.println("색상 : " + this.color);
		System.out.println("사이즈 : " + size);
		System.out.println("볼륨 크기 : " + volumeSize);
	}

}
