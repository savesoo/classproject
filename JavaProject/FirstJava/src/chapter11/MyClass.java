package chapter11;

public class MyClass<T> { // 제네릭 클래스 정의
	
	T val;
	
	T getVal() {
		return val;
	}
	
	void setVal(T val) {
		this.val = val;
	}

	public static void main(String[] args) {
		
		// 제네릭 클래스는 인스턴스 생성시에 타입을 결정한다!
		MyClass<String> myClass = new MyClass<String>();
		String str = myClass.getVal(); // T라고 정의했지만 인스턴스 생성하며 String으로 정의해줬기 때문에 타입 변경
		//Person str = myClass.getVal(); 
		
		myClass.setVal("KING");
		System.out.println(myClass.getVal()); // 객체를 저장한다~
		
	}
}
