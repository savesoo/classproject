package chapter08;

public class OuterClass extends Object {
	
	private String name;
	private int num;
	
	public OuterClass(String name) {
		super();
		this.name = name;
		this.num = 0;
	}
	
	public void tellYourName() {
		System.out.println("OuterClass Name : " + this.name + " - " + num++);
	}


	// 내부 클래스 : 클래스 내부에 다른 클래스를 정의
	// 캡슐화가 목적 : 클래스를 외부에 노출하지 않아야 할 때 사용
	// 이벤트 클래스들이 주로 내부클래스로 구성됨
	class InnerClass{
		
		// 아웃클래스의 메소드와 변수를 자신의 멤버로 취급
		InnerClass() {
			tellYourName(); // 이미 메모리에 메소드가 올라가 있는 상태->호출O
		}
		
	}
	
	public static void main(String[] args) {
		
		// 내부클래스의 인스턴스 생성은 외부 클래스의 인스턴스 생성 후 생성이 가능
		OuterClass out1 = new OuterClass("King");
		OuterClass out2 = new OuterClass("Scott");
		
		//out1.tellYourName();
		//out2.tellYourName();
		
		// 내부 클래스 변수 선언과 인스턴스 생성
		OuterClass.InnerClass in1 = out1.new InnerClass();
		OuterClass.InnerClass in2 = out2.new InnerClass();
		
		OuterClass.InnerClass in3 = out1.new InnerClass();
		OuterClass.InnerClass in4 = out2.new InnerClass();
		
		OuterClass.InnerClass in5 = out1.new InnerClass();
		
	}

}

class NewCLass2 {
	
	
}
