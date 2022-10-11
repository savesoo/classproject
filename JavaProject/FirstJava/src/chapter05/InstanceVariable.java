package chapter05;

public class InstanceVariable {
	
	// 인스턴스 변수는 인스턴스 생성시에 생성해서 인스턴스 소멸할 때까지의 생명주기
	// 인스턴스 변수 클래스 멤버가 참조 가능!
	// 클래스 멤버 : 변수, 메소드
	int iv; // 인스턴스 변수는 자동 초기화
	int iv2 = iv; // 인스턴스가 생성되어야 만들어짐
	
	void InstanceMethod(int num) {
		System.out.println(iv);
		// 참조변수.변수
		
	}
	void InstanceMethod2(int num) {
		System.out.println(iv);
		// 참조변수.변수
		
	}
	
	public static void main(String[] args) {
		InstanceVariable iv = new InstanceVariable();
		System.out.println(iv.iv);
		
		//iv = null; 
		
		System.out.println(iv.iv);
	}

}
