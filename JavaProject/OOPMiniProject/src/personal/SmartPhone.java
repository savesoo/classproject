package personal;

import java.util.Scanner;

public class SmartPhone {

	// 변수 선언
	private Contact[] contacts;
	private int countNum; // 현재 위치. 0부터 시작->배열요소 0일 때 1 = index
	Scanner scan;

	// 생성자를 통해 초기화
	private SmartPhone(int size) {
		contacts = new Contact[size];
		countNum = 0;
		scan = new Scanner(System.in);
	}

	// 싱글톤->외부 인스턴스 생성을 방지하는 동시에 외부에서 사용 가능한 인스턴스 생성 및 참조값 반환
	private static SmartPhone sph = new SmartPhone(10);

	public static SmartPhone getInstance() {
		if (sph == null) {
			sph = new SmartPhone(10);
		}
		return sph;
	}

	// 인스턴스 저장, 수정, 삭제, 리스트 출력 메소드 정의

	// 배열에 인스턴스를 저장
	void inputContact() {

		if (countNum == contacts.length) { // 현재 위치 = 최대 개수
			System.out.println("저장 개수는 최대 " + contacts.length + "개를 초과할 수 없습니다.");
			return;
		}

		String name = null;
		String phoneNum = null;
		String email = null;
		String address = null;
		int birthD = 0;
		String group = null;

		System.out.println("정보를 입력해주세요.");

		System.out.print("이름 >");
		name = scan.nextLine();

		System.out.print("전화번호 >");
		phoneNum = scan.nextLine();

		System.out.print("이메일 >");
		email = scan.nextLine();

		System.out.print("주소 >");
		address = scan.nextLine();

		System.out.print("생일(8자리) >");
		birthD = scan.nextInt();
		scan.nextLine();

		System.out.print("그룹 >");
		group = scan.nextLine();

		Contact contact = new Contact(name, phoneNum, email, address, birthD, group);

		contacts[countNum++] = contact; // 변수에 현재 위치를 넣어서 각 데이터를 순차적으로 처리해줌

	}

	// 수정
	void editContact() {
		
		if(countNum==0) {
			System.out.println("현재 정보가 없습니다.");
			return;
		}
		
		String name = null;

		System.out.println("수정을 시작합니다.");
		System.out.print("수정할 이름을 입력해주세요.");
		name = scan.nextLine();

		int index = -1;

		for (int i = 0; i < countNum; i++) {
			if (contacts[i].getName().equals(name)) {
				index = i;
				break;
			}
		}
		
		if(index==-1) {
			System.out.println("해당하는 정보가 없습니다.");
			return;
		} 
		
		String phoneNum = null;
		String email = null;
		String address = null;
		int birthD = 0;
		String group = null;

		System.out.println("수정할 정보를 입력해주세요.");

		System.out.print("전화번호 > (현 정보:"+ contacts[index].getPhoneNum() + " )");
		phoneNum = scan.nextLine();

		System.out.print("이메일 > (현 정보:" + contacts[index].getEmail() + " )");
		email = scan.nextLine();

		System.out.print("주소 > (현 정보:" + contacts[index].getAddress() + " )");
		address = scan.nextLine();

		System.out.print("생일 (8자리) > (현 정보:" + contacts[index].getBirthday() + " )");
		birthD = scan.nextInt();
		scan.nextLine();

		System.out.print("그룹 > (현 정보:" + contacts[index].getGroup() + " )");
		group = scan.nextLine();

		Contact contact = new Contact(name, phoneNum, email, address, birthD, group);

		contacts[index] = contact;
		
		System.out.println("정보 수정을 완료하였습니다.");
		System.out.println();
	}

	// 삭제
	void delContact() {
		
		if(countNum==0) {
			System.out.println("현재 정보가 없습니다.");
			return;
		}
		
		System.out.println("정보를 삭제합니다.");
		System.out.print("삭제를 원하는 정보의 이름 항목을 입력해주세요.");
		String name = scan.nextLine();
				
		for(int i=0; i<countNum; i++) {
			if(contacts[i].getName().equals(name)) {
				//contacts[i] = contacts[--countNum];
				//contacts[countNum] = null;
				
				contacts[i]=contacts[countNum-1];
				contacts[countNum-1]=null;
				countNum--; 
				System.out.println("삭제를 완료하였습니다.");
				return;
			}
		}
		
		System.out.println("해당하는 정보가 없습니다.");

	}

	// 검색하여 정보 출력
	void searchContract() {
		
		if(countNum==0) {
			System.out.println("현재 정보가 없습니다.");
			return;
		}

		String name = null;

		System.out.println("검색을 시작합니다.");
		System.out.print("검색할 이름을 입력해주세요.");
		name = scan.nextLine();

		for (int i = 0; i < countNum; i++) {
			if (contacts[i].getName().equals(name)) {
				contacts[i].chkContact();
				return;
			}
		}
		System.out.println("해당하는 정보가 없습니다.");
	}

	// 입력한 정보 출력
	void printAllData() {

		System.out.println("모든 정보를 불러옵니다.");

		if (countNum == 0) {
			System.out.println("현재 입력된 정보가 없습니다.");
			return;
		}

		for (int i = 0; i < countNum; i++) { // countNum 최댓값이 10이므로 i가 최대 9까지인 데이터를 모두 출력
			contacts[i].chkContact(); // 인스턴스화된 클래스 안에 정의된 메소드
		}
	}

}
