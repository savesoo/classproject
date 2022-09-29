package chapter10.exam;

import java.util.regex.Pattern;

// 정규식 살짝!
public class Exam1Main {
	
	// 1. 콘솔에서 사용자 아이디를 입력 받아 
	//	  정상적인 영문자와 숫자로만 이루어진 값을 입력했는지 확인하는 프로그램을 만들어봅시다.
	// ① 사용자 예외 클래스를 정의해서 예외를 발생 시켜 봅시다.
	// ② 예외 클래스 이름은 BadIdInputException이라고 정의합시다.
	
	public static void main(String[] args) {
		
        // 정상적인 영문자와 숫자로만 이루어진 값을 입력했는지 확인하는 프로그램을 만들어봅시다.
		// 'a' <= c <= 'z' || 'A' <= c <='Z' || '0' <= c <= '9'
		
		String str = "rtk12RTK";
		boolean chk1 = Pattern.matches("^[a-z0-9A-Z]*$", str); // 영문자와 숫자 조합인 패턴
		System.out.println(chk1);
		
		try {
		if(!chk1) {
			throw new Exception();
			}
		} catch(Exception e) {
			System.out.println("소문자, 대문자, 숫자만 입력 가능합니다.");
		}
		
		
		// Pattern.matches(패턴, 확인할 문자열); 
		// ^ 패턴의 시작, $ 패턴 종료, [] 특정 데이터의 집합, - 부터 까지
		// * 앞에 문자 유무 확인, + 앞의 패턴이 반드시 하나 이상, \ 문자 하나만 추가
		// ? 앞에 문자가 하나이거나 없음
		// | or
		// . 임의의 하나의 문자, \.은 '.'이라는 문자를 입력해주는 것이라 다름
		// \w 알파벳 + 숫자
		// \d [0-9] \d{} {}개의 숫자
		// \n \t
		
		// 숫자만 : ^[0-9]*$
		// 영문자만 : ^[a-zA-Z]*$
		// 한글만 : ^[가-힣]*$
		// 영어+숫자 : ^[a-z0-9A-Z]*$
		// 이메일 : ^[a-zA-Z0-9]+@+[a-zA-Z0-9]\.+[a-zA-z]+$   qqq@naver.com
		// 핸드폰 번호 : ^\\d{3}-\\d{4}-\\d{4}+$
		
		System.out.println(Pattern.matches("^\\d{3}-\\d{4}-\\d{4}+$", "010-9999-9999"));
	}


}
