package first;

public class Score {
	
	public static void main(String[] args) {

		// 1. 국어, 영어, 수학 점수 10개씩을 저장하는 배열을 정의하고
		// 점수를 모두 출력하고,
		// 평균 점수를 출력하는 프로그램을 작성해봅시다.

		int[][] scores = new int[10][3];

		for (int i =0; i < scores.length; i++) {
			for(int j=0; j<scores[i].length; j++) {
				int scr = (int)(Math.random()*101);
				scores[i][j] = scr;
			}
		}
		System.out.println("                성적표");
		System.out.println("---------------------------------------");
		System.out.printf("국어\t영어\t수학\t총합\t평균\n");
		System.out.println("---------------------------------------");
	
		int korScr = 0;
		int engScr = 0;
		int MthScr = 0;
		
		for(int i=0; i<scores.length; i++) {
			for(int j=0; j<scores[i].length; j++) {
				System.out.print(scores[i][j] + "\t");
			}
			System.out.println();
		}
	
	
	
	
	}
		


}
