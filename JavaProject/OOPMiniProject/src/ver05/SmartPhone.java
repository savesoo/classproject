package ver05;

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
	// -> 10개 정보를 저장할 수 있다. -> 배열 인스턴스를 생성 Contact[]
	// Contact 클래스 기반의 인스턴스를 최대 10개까지 만들어서 배열에 참조값을 저장

	private Contact00[] contacts;
	private int numOfContact;
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
	// 수정하고, (이름으로 검색)
	// 삭제, (이름으로 검색)
	// 검색 후 결과 출력, (이름으로 검색, 중복 없음을 가정)
	// 저장된 데이터의 리스트를 출력하는 메소드를 정의합니다.

	
	// 이름을 입력받고 배열에 해당 이름의 Contact 객체가 있는 index 반환
	private int getIndex() {
		String name = sc.nextLine();

		// 이름 검색을 통해 index 찾기
		int searchIndex = -1; // 현재 검색의 결과는 없다!

		// 데이터 찾기
		for (int i = 0; i < numOfContact; i++) {
			if (contacts[i].getName().equals(name)) {
				searchIndex = i;
				break;
			}

		}

		return searchIndex;

	}

	
	// 이름 검색 후 데이터 수정
	void editContact() {

		// 검색어 받기
		System.out.println("데이터를 수정합니다.");
		System.out.println("수정할 이름을 입력해주세요 >");

		int searchIndex = getIndex();

		if (searchIndex < 0) {
			System.out.println("검색한 데이터가 존재하지 않습니다.");
			return;
		}

		Contact00 contact = contacts[searchIndex];

		System.out.println("데이터 수정을 진행합니다.");

		System.out.println("변경할 이름을 입력해주세요.(현재값: " + contact.getName() + ")\n" + "변경하지 않으려면 엔터키를 입력하세요.");
		String newName = sc.nextLine();

		// " abc" -> "abc"
		// " " 공백문자로 입력되는 걸 방지하기 위해 trim 사용
		if (newName != null && newName.trim().length() > 0) {
			contact.setName(newName);
		}

		System.out.println("변경할 전화번호를 입력해주세요.(현재값: " + contact.getPhoneNumber() + ")\n" + "변경하지 않으려면 엔터키를 입력하세요.");
		String newNumber = sc.nextLine();
		if (newNumber != null && newNumber.trim().length() > 0) {
			contact.setPhoneNumber(newNumber);
		}

		System.out.println("변경할 이메일을 입력해주세요.(현재값: " + contact.getEmail() + ")\n" + "변경하지 않으려면 엔터키를 입력하세요.");
		String newEmail = sc.nextLine();
		if (newEmail != null && newEmail.trim().length() > 0) {
			contact.setEmail(newEmail);
		}

		System.out.println("변경할 주소를 입력해주세요.(현재값: " + contact.getAddress() + ")\n" + "변경하지 않으려면 엔터키를 입력하세요.");
		String newAddress = sc.nextLine();
		if (newAddress != null && newAddress.trim().length() > 0) {
			contact.setAddress(newAddress);
		}

		System.out.println("변경할 생일 날짜를 입력해주세요.(현재값: " + contact.getBirthday() + ")\n" + "변경하지 않으려면 엔터키를 입력하세요.");
		String newBirthday = sc.nextLine();
		if (newBirthday != null && newBirthday.trim().length() > 0) {
			contact.setBirthday(newBirthday);
		}

		System.out.println("변경할 그룹을 입력해주세요.(현재값: " + contact.getGroup() + ")\n" + "변경하지 않으려면 엔터키를 입력하세요.");
		String newGruop = sc.nextLine();
		if (newGruop != null && newGruop.trim().length() > 0) {
			contact.setGroup(newGruop);
		}

		// 형변환 연산자를 이용한 자료형 타입 변경+다형성
		if (contact instanceof CompanyContact) {

			CompanyContact companyContact = (CompanyContact) contact;

			System.out.println(
					"변경할 회사 이름을 입력해주세요.(현재값: " + companyContact.getCompany() + ")\n" + "변경하지 않으려면 엔터키를 입력하세요.");
			String newCompany = sc.nextLine();
			if (newCompany != null && newCompany.trim().length() > 0) {
				companyContact.setCompany(newCompany);
			}

			System.out.println(
					"변경할 부서 이름을 입력해주세요.(현재값: " + companyContact.getDivision() + ")\n" + "변경하지 않으려면 엔터키를 입력하세요.");
			String newDivision = sc.nextLine();
			if (newDivision != null && newDivision.trim().length() > 0) {
				companyContact.setDivision(newDivision);
			}

			System.out.println("변경할 직급을 입력해주세요.(현재값: " + companyContact.getManager() + ")\n" + "변경하지 않으려면 엔터키를 입력하세요.");
			String newManager = sc.nextLine();
			if (newManager != null && newManager.trim().length() > 0) {
				companyContact.setManager(newManager);
			}

		} else if (contact instanceof CustomerContact) {
			CustomerContact customerContact = (CustomerContact) contact;

			System.out.println(
					"변경할 회사 이름을 입력해주세요.(현재값: " + customerContact.getCompany() + ")\n" + "변경하지 않으려면 엔터키를 입력하세요.");
			String newCompany = sc.nextLine();
			if (newCompany != null && newCompany.trim().length() > 0) {
				customerContact.setCompany(newCompany);
			}

			System.out.println(
					"변경할 거래 품목을 입력해주세요.(현재값: " + customerContact.getProduct() + ")\n" + "변경하지 않으려면 엔터키를 입력하세요.");
			String newProduct = sc.nextLine();
			if (newProduct != null && newProduct.trim().length() > 0) {
				customerContact.setCompany(newProduct);
			}

			System.out.println(
					"변경할 담당자 이름을 입력해주세요.(현재값: " + customerContact.getManager() + ")\n" + "변경하지 않으려면 엔터키를 입력하세요.");
			String newManager = sc.nextLine();
			if (newManager != null && newManager.trim().length() > 0) {
				customerContact.setManager(newManager);
			}

		}

		System.out.println("데이터 수정이 완료되었습니다.");
		System.out.println();
	}

	
	// 삭제, (이름으로 검색)
	void deleteContact() {

		// 검색어 받기
		System.out.println("데이터를 삭제합니다.");
		System.out.println("삭제할 이름을 입력해주세요 >");

		int searchIndex = getIndex();

		// 검색한 index 값으로 분기 : 시프트하거나 검색 결과 X
		if (searchIndex < 0) {
			System.out.println("입력한 데이터가 존재하지 않습니다.");
		} else {
			for (int i = searchIndex; i < numOfContact - 1; i++) {
				contacts[i] = contacts[i + 1];
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

		int searchIndex = getIndex();

		// 3. 결과 출력: "검색한 이름의 정보가 없습니다."
		System.out.println("-----------검색 결과-----------");
		if (searchIndex < 0) {
			System.out.println("검색한 이름 " + name + "의 정보가 없습니다.");
		} else {
			contacts[searchIndex].printInfo();
		}

	}

	
	// 전체 입력 데이터의 출력
	void printAllData() {
		/// 배열에 저장된 데이터를 모두 출력

		System.out.println("모든 정보를 불러옵니다.");

		if (numOfContact == 0) {
			System.out.println("입력된 정보가 없습니다.");
			return;
		}

		for (int i = 0; i < numOfContact; i++) {
			contacts[i].printInfo();
		}
	}

	
	// 저장할 정보 입력
	void insertContact() {
		// 배열에 인스턴스를 저장하고,
		// 1. 데이터 받고
		// 2. 인스턴스 생성
		// 3. 배열에 인스턴스의 참조값을 저장

		if (numOfContact == contacts.length) {
			System.out.println("최대 저장 개수는 " + contacts.length + "개 입니다.");
			return;
		}

		// 회사 친구 입력?
		// 거래처 정보 입력

		System.out.println("입력하고자 하는 친구 타입을 선택해주세요.");
		System.out.println("1. 회사 동료 \t 2. 거래처");
		int select = Integer.parseInt(sc.nextLine()); // 예외 처리 필요

		String name = null;
		String phoneNumber = null;
		String email = null;
		String address = null;
		String birthday = null;
		String group = null;

		// 1. 데이터 받고
		System.out.println("입력을 시작합니다.");

		System.out.print("이름 > ");
		name = getName();

		System.out.print("전화번호 > ");
		phoneNumber = getPhoneNumber();

		System.out.print("이메일 > ");
		email = getName();

		System.out.print("주소 > ");
		address = getName();

		System.out.print("생일 > ");
		birthday = getString();

		System.out.print("그룹 > ");
		group = getString();

		Contact00 contact = null;

		// 분기 1. 회사 2. 거래처
		if (select == 1) {
			// CompanyContact 인스턴스 생성

			System.out.print("회사이름 >> ");
			String company = getString();
			System.out.println("부서이름 >> ");
			String division = getString();
			System.out.println("직급 >> ");
			String manager = getString();

			// 2. 인스턴스 생성
			contact = new CompanyContact(name, phoneNumber, email, address, birthday, group, company, division,
					manager);

		} else {
			// CustomerContact 인스턴스 생성

			System.out.print("거래처이름 >> ");
			String company = getString();
			System.out.println("거래 품목 >> ");
			String product = getString();
			System.out.println("담당자 >> ");
			String manager = getString();

			// 2. 인스턴스 생성
			contact = new CustomerContact(name, phoneNumber, email, address, birthday, group, company, product,
					manager);
		}

		// 배열에 저장

		// 처음 입력 : numOfContact -> 0 인덱스로 사용됨~
		contacts[numOfContact++] = contact;
		// numOfContact++;

	}

	
	// Scanner를 통해서 사용자에게 문자열을 받아서 반환하는 메소드
	// 집력 문자가 공백일 경우 다시 입력하도록 하는 기능
	private String getString() {

		String str = null;

		while (true) {
			str = sc.nextLine();
			if (str != null && str.trim().length() != 0) {
				break;
			} else {
				System.out.println("공백은 허용하지 않습니다. 정상적인 문자를 입력하세요. ");
			}
		}

		return str;
	}

	
	// 이름 정보를 받아서 중복 여부 체크 후 문자열 반환
	private String getName() {
		String name = null;

		while (true) {
			
			name = sc.nextLine();

			if (name != null && name.trim().length() != 0) {
				// 배열의 요소에 같은 이름의 요소가 있는지 체크
				boolean check = false;

				// 이름 검색
				for (int i = 0; i < numOfContact; i++) {
					if (name.equals(contacts[i].getName())) {
						check = true;
						break;
					}
				}

				if (check) {
					System.out.println("같은 이름의 데이터가 존재합니다. \n 다시 입력하세요. >>");
					//continue; // 다시 조건부부터 시작
				} else {
					break;
				}

			} else {
				System.out.println("공백은 허용하지 않습니다. 정상적인 문자를 입력하세요. ");
			}
		}

		return name;
	}

	
	// 전화번호를 받아서 중복된 전화번호가 있는지 체크, 중복되지 않는 전화번호를 받아서 반환
	private String getPhoneNumber() {
		String PhoneNumber = null;

		while (true) {
			
			PhoneNumber = sc.nextLine();

			if (PhoneNumber != null && PhoneNumber.trim().length()>0) {
				
				boolean check = false;
				
				// 중복여부 체크
				for(int i=0; i<numOfContact; i++) {
					if (PhoneNumber.equals(contacts[i].getPhoneNumber())) {
						check = true;
						break;
					}
				}
				
				if(check) {
					System.out.println("종복된 전화번호가 존재합니다. \n 다시 입력하세요. >>");
				} else {
					break;
				}

			} else {
				System.out.println("공백은 허용하지 않습니다. 정상적인 문자를 입력하세요. ");
			}
		}

		return PhoneNumber;
	}

}
