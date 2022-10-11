package chapter06.exam;

public class StudentMain {
	
	public static void main(String[] args) {
		
		// 학생 10명의 정보를 저장하는 배열
		Student[] students = new Student[10];
		
		// 점수 초기화
		for(int i=0; i<students.length; i++) {
			students[i] = new Student(
					"학생"+i, 
					(int)(Math.random()*51)+50, 
					(int)(Math.random()*51)+50, 
					(int)(Math.random()*51)+50
					);
		}
		
		int korTotalScore = 0;
		int engTotalScore = 0;
		int mathTotalScore = 0;
		
		System.out.println("성적표");
		System.out.println("---------------------------------------------------");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println("---------------------------------------------------");
		
		for(Student s : students) {
			s.printData();
			korTotalScore += s.getKorScore();
			engTotalScore += s.getEngScore();
			mathTotalScore += s.getMathScore();
		}
		System.out.println("---------------------------------------------------");
		
		System.out.printf("과목총점\t%d\t%d\t%d  \n", korTotalScore, engTotalScore, mathTotalScore);
		
		System.out.printf("과목평균\t%.1f\t%.1f\t%.1f  \n", korTotalScore/10f, engTotalScore/10f, mathTotalScore/10f);
		System.out.println("---------------------------------------------------");
		
		
	}

}
