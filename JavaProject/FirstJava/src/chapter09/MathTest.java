package chapter09;

public class MathTest {
	
	public static void main(String[] args) {
		
		
		// PI : fianl(상수)
		System.out.println(Math.PI);
		
		// 임의의 수 생성
		System.out.println(Math.random());
		// 1~45
		int num = (int)(Math.random()*45)+1; // 0~44.99999999...뒷자리 삭제 +1 =45까지
		System.out.println(num);
		
		// 절사
		System.out.println(Math.floor(3.6002)); // 소수점 이하 삭제 -> 실수 계산 가능
		
		// 반올림
		System.out.println(Math.round(3.4002)); // long 타입 반환
		
		System.out.println(Math.max(10, 20)); // 둘 중 큰 값
		System.out.println(Math.min(10, 20)); // 둘 중 작은 값
		
		
	}

}
