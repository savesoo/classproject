package first;

public class Student {

	// 변수는 캡슐화
	private String name; // 학생 이름
	private int korScr; // 국어 점수
	private int engScr; // 영어 점수
	private int mthScr; // 수학 점수

	// 메소드 정의
	public Student(String name, int korScr, int engScr, int mthScr) {
		this.name = name;
		this.korScr = korScr;
		this.engScr = engScr;
		this.mthScr = mthScr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKorScr() {
		return korScr;
	}

	public void setKorScr(int korScr) {
		this.korScr = korScr;
	}

	public int getEngScr() {
		return engScr;
	}

	public void setEngScr(int engScr) {
		this.engScr = engScr;
	}

	public int getMthScr() {
		return mthScr;
	}

	public void setMthScr(int mthScr) {
		this.mthScr = mthScr;
	}

	// 총점을 구해 결과 반환 메소드
	public int sum() {
		int totalScr = 0;
		totalScr = korScr + engScr + mthScr;
		return totalScr;
	}

	// 평균을 구해 결과 반환 메소드
	public float avrg() {
		return sum() / 3f;
	}

	// 출력 메소드 설정하고 인스턴스화
	public void printScr() {
		System.out.print(this.name + "\t" + this.korScr + "\t" + this.engScr + "\t" + this.mthScr + "\t" + sum() + "\t"
				+ avrg() + "\n");
	}

}
