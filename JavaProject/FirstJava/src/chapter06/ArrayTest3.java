package chapter06;

public class ArrayTest3 {

	public static void main(String[] args) {

		// 10명의 국어점수를 저장하는 배열 선언하고 생성
		int[] korScore = new int[10];

		// 배열의 사이즈를 가지고 있는 length
		System.out.println("배열의 요소 개수 : " + korScore.length);
		{

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
		sum(korScore);

	}

	public static void sum(int[] arr) {

		// arr -> korScores의 배열 인스턴스 주소

		int sum = 0;

		// sum = korScore[0]+korScore[1]+...+korScore[9]

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		System.out.println("총점 : " + sum);
		System.out.println("반 평균 : " + (float) sum / arr.length);

	}

}
