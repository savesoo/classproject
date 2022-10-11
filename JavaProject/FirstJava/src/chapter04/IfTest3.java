package chapter04;

public class IfTest3 {

	public static void main(String[] args) {
		
		// 점수에 따라서 학점 표기를 합시다
		// 100~97 : A+
		// 94~96 : A
		// 90~93 : A-
		// 80점 대는 B, B+, B-
		// 70점 대는 C, C+, C-
		// 나머지는 F
		// 조건문의 중첩
		
		int score = 80;
		String result = "F";
		
		if(score>=90) {
			// A, A+, A-
			result = "A";
			
			// 100~97 : A+
			if(score>=97) {
				// result = result + "+";
				result += "+";
			}
			// 90~93 : A-
			if(score<=93) {
				result += "-";
			}
			
		} else if(score>=80) {
			// B, B+, B-
			result = "B";
			
			// +
			if(score>=87) {
				result += "+";
			} else if(score<=83) { // 80~86
				result += "-";
			} 
			
			
		} else if(score>=70) {
			// C, C+, C-
			result = "C";
			
			if(score>=77) {
				result += "+";
			} else if(score<=73) {
				result += "-";
			}
		} /* 
		else {result = "F"; } 
			*/
		
		System.out.println("학점 : " + result);
	}
}
