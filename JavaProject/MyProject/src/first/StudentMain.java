package first;

public class StudentMain {
	
	public static void main(String[] args) {
		
		// Student 타입의 배열 선언, 요소 10개 저장 가능한 배열 인스턴스 생성
		Student[] students = new Student[10];
		
		// 학생 이름, 국어, 영어, 수학 점수, 합, 평균 10개 저장(임의값)
		for(int i=0; i<students.length; i++) {
			students[i] = new Student("학생" + i, (int)(Math.random()*101), (int)(Math.random()*101), (int)(Math.random()*101));
		}
		
		System.out.println("                     성적표");
		System.out.println("---------------------------------------------------");
		System.out.printf("이름\t국어\t영어\t수학\t총합\t평균\n");
		System.out.println("---------------------------------------------------");
	
		// 배열에 저장된 인스턴스 이용, 데이터 출력
		for(Student ss : students ) { 
			ss.printScr();
		}
	}

}
