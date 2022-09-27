package chapter08;

public class OuterClass2 {
	
	private String name;

	// 생성자
	public OuterClass2(String name) {
		super();
		this.name = name;
	}
	
	// 상위 타입으로 변환해줌
	public BasicClass createLocalClassInstance() {
		
		// Local Class : 메소드 내부에 선언되어 사용되는 클래스
		// 외부 클래스에서는 내부 클래스를 참조할 수 없다!
		// 상속의 구조로 다형성 이용해서 외부에서도 사용할 수 있도록 정의
		class LocalClass extends BasicClass {
			void tell() {
				System.out.println("안녕하세요. " + name + "입니다."); // 어노테이션 없어도 오버라이딩 상태
			}
		}
		return new LocalClass();
		
		// 메소드 내부에서 내부 클래스를 이용한 인스턴스 생성은 언제나 가능!
		// new LocalClass().tell();
		
	}
	
	public static void main(String[] args) {
		OuterClass2 o = new OuterClass2("King");
		
		BasicClass localClassInst = o.createLocalClassInstance();
		
		localClassInst.tell();
		
	}

}

abstract class BasicClass{
	
	// 외부에서도 사용 가능하도록 추상 메소드로 만들어줌
	abstract void tell();
	
}
