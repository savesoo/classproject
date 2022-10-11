package chapter04;

public class WhileLoop3 {

	public static void main(String[] args) {
		
		// 1~10까지의 합 -> 55
		
		// 반복 10번 or 체크할 변수가 1~10까지
		
		int num = 1;
		
		int sum = 0;
		
		while(num<=10) {
			
			// 합을 구하는 연산
			sum = sum + num; // ((((0+1)+2)+3)....+10)

		// 참고 : System.out.println(sum + "+" + num + "=" + (sum += num) );
			
			//증가식(탈출하기 위함)
			num++; 
		}
		
		System.out.println("1~10까지의 합 : " + sum);
	}

}
