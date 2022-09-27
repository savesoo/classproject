package chapter09;

public class StringTest {

	public static void main(String[] args) {

		// 문자열을 다루는 String
		String str1 = "String"; // 변하지 않는 문자열
		String str2 = "String"; // 기존 저장되어 있던 문자열과 참조값을 비교해서 같다면 1을 반환해줌
		String str3 = new String("String"); // ()안의 문자를 먼저 스트링으로 보내고 하나하나 비교함 새로운 메모리 공간에 인스턴스 생성

		System.out.println("str1 == str2 ->" + (str1 == str2)); // 새로운 값 저장이 아님.
		System.out.println("str1 == str3 ->" + (str1 == str3));

		System.out.println(str1.equals(str3));

		// 특정 타입의 데이터 -> 문자열 String 타입으로 변경
		String str4 = "" + 1; // 문자열이 되긴 하나 여러 번 써야 해서 좋은 방법은 아님
		String str5 = String.valueOf(false); // 하나의 데이터를 문자로 전환, 가장 많이 사용
		String str6 = new String();
		System.out.println(str5);

		////////////////////////////
		System.out.println("------------------------------------------\n");

		String str = "Hello~";
		System.out.println(str.toString());

		System.out.println(str.charAt(0));
		System.out.println(str.charAt(5));

		// 문자열을 역순으로 출력해보자
		System.out.println("문자열 출력 --------");
		for (int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i));
		}

		System.out.println();
		System.out.println("역순 출력 --------");
		for (int i = str.length() - 1; i >= 0; i--) {
			System.out.print(str.charAt(i));
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println(str.compareTo("Hello~")); // 같다의 판단을 하지 X 
		System.out.println(str.compareTo("Hello~~")); //문자열의 길이를 보고 유니코드로 연산
		System.out.println(str.compareTo("Hello"));
		System.out.println();
		
		System.out.println();
		// 문자열의 합
		System.out.println(str.concat(str1)); // "Hello~" + "String" 문자열 뒤에 붙이는 것

		System.out.println();
		// 포함 확인 (문자열을 가지고 있는지 여부)
		System.out.println(str.contains("~"));
		System.out.println(str.contains("bye"));

		System.out.println();
		System.out.println(str.startsWith("He")); 
		// http:// https:// cafe/himedia 해당 문자열의 시작 위치 찾기-몇번째부터 시작하는지
		System.err.println(str.endsWith(".pdf"));
		// 확장자 찾기 : *.jpg
		
		System.out.println();
		System.out.println(str.equals("top"));
		System.out.println(str.equals("Hello~"));
		
		System.out.println();
		System.out.println(str.indexOf("1")); // 입력된 문자열이 든 위치 앞에서부터 한 개를 찾음
		System.out.println(str.lastIndexOf("1")); // 뒤에서부터 찾음
		// 문서.ver01.20220927.xls
		// Hello~
		System.out.println(str.indexOf("o~"));
		
		System.out.println();
		System.out.println(str.isEmpty());
		System.out.println("".isEmpty());
		System.out.println(" ".isEmpty()); // 공백문자열도 취급. 문자열의 개수
		System.out.println(" ".trim().isEmpty()); // 좌우 공백 지워줌
		
		System.out.println(str.length());
		System.out.println(str.length()==0);
		
		System.out.println();
		// 문자열 치환
		System.out.println(str.replace("~", "!!!!"));
		
	}

}
