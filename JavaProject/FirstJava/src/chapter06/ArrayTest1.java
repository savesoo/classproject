package chapter06;

public class ArrayTest1 {

	public static void main(String[] args) {

		// 배열 : 많은 수의 변수를 다루어야할 때 사용
		// 일괄 처리!!!
		// 변수 여러 개를 순차적으로 만든 것과 같은 효과
		// 메모리를 옆에 붙여서 생성
		// 배열 변수 -> 타입[] 변수이름
		// 타입 변수이름[]
		// 배열 생성 : 메모리 공간 생성, 변수들을 생성
		// new 타입[개수] -> [] 안에 입력한 숫자만큼의 메모리 공간(변수)을 생성

		// 10명의 국어점수를 저장하는 배열 선언하고 생성
		int[] korScore = new int[10];

		// 배열의 사이즈를 가지고 있는 length
		System.out.println("배열의 요소 개수 : " + korScore.length);
		{

		}

		// 배열의 참조 방법 : 변수이름[index]
		// index 0부터 배열요소개수 -1
		// index -> 0~9
		for (int i = 0; i < korScore.length; i++) {

			int temp = korScore[i];
			System.out.println(i + " : " + temp);

		}
		
		// 배열 요소의 초기화
		korScore[0] = 98;
		korScore[1] = 74;
		korScore[2] = 84;
		korScore[3] = 67;
		korScore[4] = 100;
		korScore[5] = 27;
		korScore[6] = 19;
		korScore[7] = 53;
		korScore[8] = 48;
		korScore[9] = 32;
		
		System.out.println();
		
		int sum = 0;
		
		// for문 모르는 상태라면 sum = korScore[0]+korScore[1]+...+korScore[9] 
		
		for (int i = 0; i < korScore.length; i++) {
			sum += korScore[i];
		}
		
		System.out.println("총점 : " + sum);
		System.out.println("반 평균 : " + (float)sum/korScore.length);
		
	}

}
