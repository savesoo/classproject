package first;

public class Member3 {
	
	// Member 클래스에는 아래 요구사항에 맞는 변수와 메소드를 정의하고
	// main()메소드 에 해당 메소드를 호출해서 결과를 확인해보세요.
	// 단 인스턴스의 생성은 생성자를 이용해서 초기화하는 코드를 작성해 봅시다.
	// ① 아래의 데이터를 저장 이름, 전화번호, 전공, 학년, email, 생일, 주소
	// ② 위에서 정의한 정보를 출력하는 메소드 정의
	// ③ 모든 정보를 저장하도록 하는 생성자와 생일과 주소는 저장하지 않을 수 있는 생성자를 정의
	// ④ main() 메소드에서 두 가지 생성자를 이용해서 인스턴스 생성하고 출력 메소드를 통해 저장된 데이터 출력
		
	String name;
	String phoneNum;
	String major;
	int grade;
	String eMail;
	String birthD;
	String adress;
	
	Member3() {
		
	}
	
	
	Member3(String name, String phoneNum, String major, int grade, String eMail, String birthD, String adress) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.major = major;
		this.grade = grade;
		this.eMail = eMail;
		this.birthD = birthD;
		this.adress = adress;
	}
	
	Member3(String name, String phoneNum, String major, int grade, String eMail) {
		this(name, phoneNum, major, grade, eMail, "생일 비공개", "주소 비공개");
	}
	
	
	public void printInfo() {
		System.out.println("개인 정보");
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phoneNum);
		System.out.println("전공 : " + major);
		System.out.println("학년 : " + grade + " 학년");
		System.out.println("e-mail : " + eMail);
		System.out.println("생일(년/월/일) : " + birthD);
		System.out.println("주소 : " + adress);
	}

}
