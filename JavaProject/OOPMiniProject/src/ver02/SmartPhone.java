package ver02;

import java.util.Scanner;

public class SmartPhone {

	// 기능 클래스 : 속성을 가지지 않고 메소드들로만 정의된 클래스
	// 여러 개의 인스턴스가 생성될 필요 없다! -> 싱글톤 패턴
	// 1. private 생성자
	// 2. 클래스 내부에서 인스턴스를 생성 static(인스턴스 생성 가능하게끔) private
	// 3. 내부에서 생성한 참조값을 반환해주는 메소드 static public(다른 패키지에서도 사용)

	// 요구사항
	// 이 클래스는 연락처 정보를 관리하는 클래스입니다.
	// ① Contact 클래스의 인스턴스 10개를 저장 할 수 있는 배열을 정의합시다.
	// 	-> 10개 정보를 저장할 수 있다. -> 배열 인스턴스를 생성 Contact[]
	// 	   Contact 클래스 기반의 인스턴스를 최대 10개까지 만들어서 배열에 참조값을 저장

	private Contact00[] contacts;     // null. 가능하면 생성자를 통해 초기화하는 것을 권장
	private int numOfContact;         // 입력된 정보의 개수, 배열의 index 값으로 사용
	Scanner sc;

	private SmartPhone(int size) {
		contacts = new Contact00[size];
		numOfContact = 0;
		sc = new Scanner(System.in);
	}

	private static SmartPhone sp = new SmartPhone(10);

	public static SmartPhone getInstance() {
		if (sp == null) {
			sp = new SmartPhone(10);
		}
		return sp;
	}

	// ② 기능
	// 배열에 인스턴스를 저장하고, 
	// 				수정하고, (이름으로 검색)
	//				삭제, (이름으로 검색)
	// 				검색 후 결과 출력, (이름으로 검색, 중복 없음을 가정)
	// 				저장된 데이터의 리스트를 출력하는 메소드를 정의합니다.
	
	
	
	
	
	// 이름 검색 후 데이터 수정
	void editContact() {
		// 검색어 받기
				System.out.println("데이터를 수정합니다.");
				System.out.println("수정할 이름을 입력해주세요 >");
				String name = sc.nextLine();
				
				// 삭제하고자 하는 index 찾기 -> shift
				int searchIndex = -1; // 현재 검색의 결과는 없다! 그러니까 이제부터 찾을 거야~
				
				// 데이터 찾기
				for(int i=0; i<numOfContact; i++) {
					if(contacts[i].getName().equals(name)) {
						searchIndex = i;
						break;
					}
				}
				
				if(searchIndex<0) {
					System.out.println("검색한 데이터가 존재하지 않습니다.");
					return;
				}
				
				Contact00 contact = contacts[searchIndex];
				
				System.out.println("데이터 수정을 진행합니다.");
				
				System.out.println("변경할 이름을 입력해주세요.(현재값: "+ contact.getName() +")\n" + "변경하지 않으려면 엔터키를 입력하세요.");
				String newName = sc.nextLine();
				
				// "   abc" -> "abc"
				// " " 공백문자로 입력되는 걸 방지하기 위해 trim 사용
				if(newName != null && newName.trim().length()>0) {
					contact.setName(newName);
				}
				
				System.out.println("변경할 전화번호를 입력해주세요.(현재값: "+ contact.getPhoneNumber() +")\n" + "변경하지 않으려면 엔터키를 입력하세요.");
				String newNumber = sc.nextLine();
				if(newNumber != null && newNumber.trim().length()>0) {
					contact.setPhoneNumber(newNumber);
				}
				
				System.out.println("변경할 이메일을 입력해주세요.(현재값: "+ contact.getEmail() +")\n" + "변경하지 않으려면 엔터키를 입력하세요.");
				String newEmail = sc.nextLine();
				if(newEmail != null && newEmail.trim().length()>0) {
					contact.setEmail(newEmail);
				}
				
				System.out.println("변경할 주소를 입력해주세요.(현재값: "+ contact.getAddress() +")\n" + "변경하지 않으려면 엔터키를 입력하세요.");
				String newAddress = sc.nextLine();
				if(newAddress != null && newAddress.trim().length()>0) {
					contact.setAddress(newAddress);
				}
				
				System.out.println("변경할 생일 날짜를 입력해주세요.(현재값: "+ contact.getBirthday() +")\n" + "변경하지 않으려면 엔터키를 입력하세요.");
				String newBirthday = sc.nextLine();
				if(newBirthday != null && newBirthday.trim().length()>0) {
					contact.setBirthday(newBirthday);
				}
				
				System.out.println("변경할 그룹을 입력해주세요.(현재값: "+ contact.getGroup() +")\n" + "변경하지 않으려면 엔터키를 입력하세요.");
				String newGruop = sc.nextLine();
				if(newGruop != null && newGruop.trim().length()>0) {
					contact.setGroup(newGruop);
				}
				
				System.out.println("데이터 수정이 완료되었습니다.");
				System.out.println();
	}
	
	
	
	
	
	//	삭제, (이름으로 검색)
	void deleteContact() {
		
		// 검색어 받기
		System.out.println("데이터를 삭제합니다.");
		System.out.println("삭제할 이름을 입력해주세요 >");
		String name = sc.nextLine();
		
		// 삭제하고자 하는 index 찾기 -> shift
		int searchIndex = -1; // 현재 검색의 결과는 없다! 그러니까 이제부터 찾을 거야~
		
		// 데이터 찾기
		for(int i=0; i<numOfContact; i++) {
			if(contacts[i].getName().equals(name)) {
				searchIndex = i;
				break;
			}
		}
		
		// 검색한 index 값으로 분기 : 시프트하거나 검색 결과 X
		if(searchIndex<0) {
			System.out.println("입력한 데이터가 존재하지 않습니다.");
		} else {
			for(int i=searchIndex; i<numOfContact-1; i++) {
				contacts[i] = contacts[i+1];
			}
			
			numOfContact--;
			System.out.println("데이터가 삭제되었습니다.");
		}
	}
	

	
	
	

	// 검색 후 결과 출력 (이름으로 검색)
	void searchInfoPrint() {

		// 1. 사용자에게 검색할 키워드 입력받는다!
		// 2. 배열에서 이름 검색
		// 3. 결과 출력: "검색한 이름의 정보가 없습니다."
		
		String name = null; // 검색할 이름
		
		System.out.println("검색을 시작합니다.");
		System.out.print("검색할 이름을 입력하세요. >");
		name = sc.nextLine();
		
		Contact00 contact = null;
		// 배열에서 검색할 이름을 가지는 인스턴스의 데이터 출력 메소드 실행
		for(int i=0; i<numOfContact; i++) {
			// 각 요소의 참조변수로 객체를 참조해서 이름 비교
			if(contacts[i].getName().equals(name)) { 
				contact = contacts[i];
				break;
			}
		}
		
		// 3. 결과 출력: "검색한 이름의 정보가 없습니다."
		System.out.println("-----------검색 결과-----------");
		if (contact == null) {
			System.out.println("검색한 이름 " + name + "의 정보가 없습니다.");
		} else {
			contact.printInfo();
		}

	}

	
	
	
	
	
	
	// 전체 입력 데이터의 출력
	void printAllData() {
		/// 배열에 저장된 데이터를 모두 출력
		
		System.out.println("모든 정보를 불러옵니다.");
		
		if(numOfContact == 0) {
			System.out.println("입력된 정보가 없습니다.");
			return;
		} 
		
		for (int i = 0; i < numOfContact; i++) {
			contacts[i].printInfo();
		}
	}

	
	
	
	
	void insertContact() {
		// 배열에 인스턴스를 저장하고,
		// 1. 데이터 받고
		// 2. 인스턴스 생성
		// 3. 배열에 인스턴스의 참조값을 저장
		
		if(numOfContact == contacts.length) {          // 현재 사이즈를 최대 사이즈와 비교
			System.out.println("최대 저장 개수는" + contacts + "개 입니다.");
			return;
		}

		String name = null;
		String phoneNumber = null;
		String email = null;
		String address = null;
		String birthday = null;
		String group = null;

		// 1. 데이터 받고
		System.out.println("입력을 시작합니다.");

		System.out.print("이름 > ");
		name = sc.nextLine();

		System.out.print("전화번호 > ");
		phoneNumber = sc.nextLine();

		System.out.print("이메일 > ");
		email = sc.nextLine();

		System.out.print("주소 > ");
		address = sc.nextLine();

		System.out.print("생일 > ");
		birthday = sc.nextLine();

		System.out.print("그룹 > ");
		group = sc.nextLine();

		// 2. 인스턴스 생성
		Contact00 contact = new Contact00(name, phoneNumber, email, address, birthday, group);

		// 배열에 저장

		// 처음 입력 : numOfContact -> 0 인덱스로 사용됨~
		contacts[numOfContact++] = contact;
		// numOfContact++;

	}

}
