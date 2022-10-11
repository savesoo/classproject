package chapter05;

public class StaticMethod {
	
	static int num1 = 10;  // 클래스 변수
	int num2; // 인스턴스 변수
	
	static void StaticMethod() {
		System.out.println("StaticMethod");
		//System.out.println(num2); // 인스턴스 생성 없이 사용 불가
		// 클래스 멤버에 인스턴스 멤버는 사용 불가!!
		StaticMethod sm = new StaticMethod();
		sm.InstanceMethod();
	}
	
	void InstanceMethod() {
		System.out.println("InstaceMethod");
		System.out.println(num1);
		StaticMethod(); 
	}

}
