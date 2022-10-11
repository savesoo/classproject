package Project06;

import java.util.Scanner;
import java.util.regex.Pattern;

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
		String birthD = null;
		String group = null;

		System.out.println("저장하고자 하는 정보를 선택해주세요.");
		System.out.println("1. 회사 정보 2. 거래처 정보 3. 취소");

		int inputInfo = inputStringToInt();

		if (inputInfo > 3 || inputInfo == 0) {
			System.out.println("입력할 수 없는 형태입니다.");
			return;
		} else if (inputInfo == 3) {
			System.out.println("저장을 취소합니다.");
			return;
		}

		System.out.println("기본 정보를 입력합니다.");
		System.out.print("이름 >");
		
		name = insertName();
		
		// 이름 중복 방지->기존에 저장된 이름이 있는 경우 재입력
		if(getIndex(name)!=-1) {
			System.out.println("이미 동일한 이름이 저장되어 있습니다. 처음 화면으로 돌아갑니다.");
			return;
		}

		System.out.print("전화번호 >");
		phoneNum = insertPhoneNum();

		System.out.print("이메일 >");
		email = reInsert();

		System.out.print("주소 >");
		address = reInsert();

		System.out.print("생일 >");
		birthD = reInsert();

		System.out.print("그룹 >");
		group = reInsert();

		Contact contact = null;

		if (inputInfo == 1) {

			String company = null;
			String department = null;
			String position = null;

			System.out.println("회사 정보를 입력합니다.");
			System.out.print("회사명 >");
			company = reInsert();
			System.out.print("부서명 >");
			department = reInsert();
			System.out.print("직급 >");
			position = reInsert();

			contact = new CompanyContact(name, phoneNum, email, address, birthD, group, company, department, position);

		} else if (inputInfo == 2) {
			String company = null;
			String goods = null;
			String position = null;

			System.out.println("거래처 정보를 입력합니다.");
			System.out.print("거래처명 >");
			company = reInsert();
			System.out.print("거래 품목 >");
			goods = reInsert();
			System.out.print("직급 >");
			position = reInsert();

			contact = new CustomerContact(name, phoneNum, email, address, birthD, group, company, goods, position);

		}

		for (Contact cnt : contacts) {
			if (cnt != null && cnt.getPhoneNum().equals(phoneNum)) {
				System.out.println("동일한 전화번호가 존재하므로 이 정보를 저장할 수 없습니다. 처음 화면으로 돌아갑니다. ");
				return;
			}
		}

		contacts[countNum++] = contact; // 변수에 현재 위치를 넣어서 각 데이터를 순차적으로 처리해줌

	}

	// 수정
	void editContact() {

		if (countNum == 0) {
			System.out.println("현재 정보가 없습니다.");
			return;
		}

		String name = null;

		System.out.println("수정을 시작합니다.");
		System.out.print("수정할 이름을 입력해주세요.");
		name = insertName();

		int index = getIndex(name);

		if (index == -1) {
			System.out.println("해당하는 정보가 없습니다.");
			return;
		}

		String phoneNum = null;
		String email = null;
		String address = null;
		String birthD = null;
		String group = null;

		System.out.println("수정할 정보를 선택해주세요.");
		System.out.println("1. 회사 정보 2. 거래처 정보 3. 수정 취소");

		int inputInfo = inputStringToInt();

		if (inputInfo > 3 || inputInfo == 0) {
			System.out.println("입력할 수 없는 형태입니다.");
			return;
		} else if (inputInfo == 3) {
			System.out.println("수정을 취소합니다.");
			return;
		}

		System.out.println("기본 정보를 수정합니다.");
		System.out.print("전화번호 > (현 정보: " + contacts[index].getPhoneNum() + " )");
		phoneNum = insertPhoneNum();

		System.out.print("이메일 > (현 정보: " + contacts[index].getEmail() + " )");
		email = reInsert();

		System.out.print("주소 > (현 정보: " + contacts[index].getAddress() + " )");
		address = reInsert();

		System.out.print("생일 > (현 정보: " + contacts[index].getBirthday() + " )");
		birthD = reInsert();

		System.out.print("그룹 > (현 정보: " + contacts[index].getGroup() + " )");
		group = reInsert();

		Contact contact = null;

		if (inputInfo == 1) {

			String company = null;
			String department = null;
			String position = null;

			System.out.println("회사 정보를 수정합니다.");
			System.out.print("회사명 > (현 정보 : " + ((CompanyContact) contacts[index]).getCompany() + " )");
			company = reInsert();
			System.out.print("부서명 : " + ((CompanyContact) contacts[index]).getDepartment() + " )");
			department = reInsert();
			System.out.print("직급 > " + ((CompanyContact) contacts[index]).getPosition() + " )");
			position = reInsert();

			contact = new CompanyContact(name, phoneNum, email, address, birthD, group, company, department, position);

		} else if (inputInfo == 2) {

			String company = null;
			String goods = null;
			String position = null;

			System.out.println("거래처 정보를 수정합니다.");
			System.out.print("거래처명 > (현 정보 > " + ((CustomerContact) contacts[index]).getCompany() + " )");
			company = reInsert();
			System.out.print("거래품목 > " + ((CustomerContact) contacts[index]).getGoods() + " )");
			goods = reInsert();
			System.out.print("직급 > " + ((CustomerContact) contacts[index]).getPosition() + " )");
			position = reInsert();

			contact = new CustomerContact(name, phoneNum, email, address, birthD, group, company, goods, position);
		}

		contacts[index] = contact;

		System.out.println("정보 수정을 완료하였습니다.");
		System.out.println();
	}

	// 삭제
	void delContact() {

		if (countNum == 0) {
			System.out.println("현재 정보가 없습니다.");
			return;
		}

		System.out.println("정보를 삭제합니다.");
		System.out.print("삭제를 원하는 정보의 이름 항목을 입력해주세요.");
		String name = insertName();

		int index = getIndex(name);
		
		// 입력한 이름이 기존 데이터에 없는 경우
		if (index==-1) {
			System.out.println("해당하는 정보가 없습니다.");
			return;
		}
		
		contacts[index] = contacts[countNum - 1]; // 삭제하고자 하는 인덱스를 찾아 맨 끝에 있는 데이터를 덮어쓰기
		contacts[countNum - 1] = null; // 이때 맨 끝에 있던 데이터는 중복되므로 null 처리(=삭제)
		countNum--; // 맨 끝의 데이터는 삭제되었으므로 현재 위치(인덱스)는 감소
		System.out.println("삭제를 완료하였습니다.");
	}


	// 검색하여 정보 출력
	void searchContract() {

		if (countNum == 0) {
			System.out.println("현재 정보가 없습니다.");
			return;
		}

		String name = null;

		System.out.println("검색을 시작합니다.");
		System.out.print("검색할 이름을 입력해주세요.");
		name = insertName();

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

	// 공백 문자열 입력시 재입력 유도
	private String reInsert() {

		String str = null;

		while (true) {

			str = scan.nextLine();

			// 공백이 아니거나 앞뒤 공백 제외하고 문자가 존재할 경우
			if (str != null && str.trim().length() != 0) {
				break;
			} else {
				System.out.println("허용되지 않은 형식입니다. 공백이나 띄어쓰기를 제외한 문자를 입력하세요.");
			}
		}

		return str;

	}

	// 생일을 int 타입으로 설정할 경우
	int inputBirth() {
		int result = 0;

		while (true) {
			try {

				String temp = scan.nextLine();

				if (temp != null && temp.trim().length() == 8 && Pattern.matches("^[0-9]*$", temp)) {
					result = Integer.parseInt(temp);
					break;
				} else {
					throw new Exception("허용되지 않은 형식입니다. 공백이나 띄어쓰기를 제외한 숫자 8자리를 입력하세요.");
				}
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
		}
		return result;
	}

	// 숫자 외 데이터 입력 받았을 때 예외 처리
	int inputStringToInt() {

		int result = 0;
		String str = scan.nextLine(); // string을 입력 받아서 str에 저장

		try {
			result = Integer.parseInt(str); // str이라는 string을 정수형으로 변환
			// result = Integer.parseInt(scan.nextLine()); // string을 입력 받아서 바로 정수형으로 변환
		} catch (Exception e) {
			System.out.println("잘못된 형태의 입력입니다. 숫자를 입력해주세요.");
		}
		return result;
	}

	// 이름 입력시 영문자와 한글만 허용
	String insertName() {

		String result = null;

		while (true) {
			result = scan.nextLine();
			try {
				if (Pattern.matches("^[a-zA-Z가-힣]*$", result) == true) {
					if(getIndex(result)!=-1) {
						System.out.println("동일하게 저장된 이름이 이미 존재합니다. 다시 입력해주세요.");
						break;
					}
				} else {
					throw new Exception("한글 및 영대소문자만 입력 가능합니다. 다시 입력해주세요.");
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		return result;

	}

	// 전화번호 형식에 맞지 않을 때 예외 처리
	String insertPhoneNum() {

		String result = null;

		while (true) {
			result = scan.nextLine();
			try {
				if (Pattern.matches("^\\d{3}-\\d{4}-\\d{4}+$", result)) {
					break;
				} else {
					throw new Exception("010-0000-0000 형식으로만 입력 가능합니다. 다시 입력해주세요. ");
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	// 입력된 값과 비교해 해당 인덱스를 반환
	int getIndex(String name) {

		int index = -1;

		for (int i = 0; i < countNum; i++) {
			if (contacts[i].getName().equals(name)) {
				index = i;
				break;
			}
		}
		return index;
	}

}
