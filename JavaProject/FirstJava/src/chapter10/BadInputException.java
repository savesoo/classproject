package chapter10;

public class BadInputException extends Exception {
	
	int score;
	
	// 사용자 정의 예외 클래스
	public BadInputException(int score) {
		super("입력하신 점수 " + score + "은(는) 범위를 벗어납니다.");
		this.score = score;
	}

	public int getScore() { // 입력한 점수를 따로 받을 수 있게 해줌. 새로 입력받지 않으므로 set은 안함
		return score;
	}

}
