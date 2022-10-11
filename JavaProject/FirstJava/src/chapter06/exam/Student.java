package chapter06.exam;

public class Student {

	private String name;
	private int korScore;
	private int engScore;
	private int mathScore;

	public Student(String name, int korScore, int engScore, int mathScore) {
		this.name = name;
		this.korScore = korScore;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKorScore() {
		return korScore;
	}

	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}

	public int getEngScore() {
		return engScore;
	}

	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	
	// 총점을 구해서 반환하는 메소드
	public int sum() {
		int result = 0;
		result = korScore + engScore + mathScore;
		return result;
	}
	// 평균값을 구해서 반환하는 메소드
	public float avg() {
		return sum()/3f;
	}
	
	// 행 단위 출력
	public void printData() {
		System.out.print(
				this.name + "\t" + 
				this.korScore + "\t" + 
				this.engScore + "\t" + 
				this.mathScore + "\t" +
				sum() + "\t" +
				avg() + "\n"
				);
	}
	
	public static void main(String[] args) {
		Student s = new Student("학생 1", 100, 94, 80);
		
		System.out.println("합 : " + s.sum());
		System.out.println("평균 : " + s.avg());
		
		s.printData();
	}

}