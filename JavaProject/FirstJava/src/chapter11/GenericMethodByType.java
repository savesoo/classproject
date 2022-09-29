package chapter11;

import java.util.ArrayList;

//import chapter08.phone.Phone;
//import chapter08.phone.PhoneImpl;

public class GenericMethodByType {
	
	public <T /*extends Phone*/> void hello(T t) {
		System.out.println("안녕하세요. " + t.toString() + "입니다.");
		//t.call();
	}
	
	public static void main(String[] args) {
		
		GenericMethodByType byType = new GenericMethodByType();
		
		byType.<String>hello("류정한"); // 무조건 String 타입만 입력 가능
		byType.hello(10); // 제네릭 타입 생략하고 매개변수만 전달하면 자동으로 타입이 설정된다~ -> int
		
		// byType.<PhoneImpl>hello(new PhoneImpl()); // 쓸 타입과 그 앞으로 지정
		// byType.hello(new PhoneImpl()); // 생략 가능하지만 원하는 타입으로 반영되었는지 주의
		// byType.hello("스마트폰"); // extends Phone 에서 걸려서 작동X
	
	}


}
