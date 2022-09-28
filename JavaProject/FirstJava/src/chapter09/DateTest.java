package chapter09;

import java.util.Date;

public class DateTest {
	
	public static void main(String[] args) {
		
		Date now = new Date(); // import 할 때 다른 패키지에 속한 같은 이름의 클래스가 나오면 띄워줌
		
		System.out.println("현재 시간 : " + now);
		
		System.out.println(now.getTime());
		
		// long 타입의 데이터로 Date 인스턴스 생성
		Date day = new Date(1664327144062L); // 리터럴이니까 L 넣어주기. 계산돼있는 밀리초이므로 그것을 계산한 데이터를 가지고 있음.
		System.out.println("day : " + day);
		
		System.out.println(now.toString()); // 현재 시간
		System.out.println(day.toString()); // 특정 시간
		
	}

}
