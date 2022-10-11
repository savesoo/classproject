package chao10Exc;

public class BadIdInputException extends Exception {
	
	BadIdInputException() {
		
		super("영문이나 숫자만 입력 가능합니다.");
	}

}
