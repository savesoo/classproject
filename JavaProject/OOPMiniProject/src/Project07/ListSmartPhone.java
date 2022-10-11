package Project07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ListSmartPhone implements ISmartPhone{

	private List<Contact> contacts;
	Scanner scan;

	private ListSmartPhone() {
		contacts = new ArrayList<>(10);
		scan = new Scanner(System.in);
	}

	private static ListSmartPhone listsp = new ListSmartPhone();

	public static ListSmartPhone getInstance() {
		if (listsp == null) {
			listsp = new ListSmartPhone();
		}
		return listsp;
	}

	
	// 연락처 저장
	public void inputContact() {

		// 최대 저장 개수 초과시
		if (contacts.size() == 10) {
			System.out.println("저장 개수는 최대 " + contacts.size() + "개 입니다.");
		}

		// 저장 정보 선택-저장
		String name = null;
		String phoneNumber = null;
		String email = null;
		String address = null;
		String birthday = null;
		String group = null;

		System.out.println("저장할 정보 유형을 선택해주세요.");
		System.out.println("1. 회사 정보 2. 거래처 정보 3. 취소");

		int select = inputStringToInt();

		if (select > 3 || select == 0) {
			System.out.println("허용되지 않은 범위입니다. 1-3 사이의 번호를 선택해주세요.");
			return;
		} else if (select == 3) {
			System.out.println("저장을 취소하고 첫 화면으로 돌아갑니다.");
			return;
		}

		System.out.print("이름 > ");
		name = inputString();

		System.out.print("전화번호 > ");
		phoneNumber = inputPhoneNum();

		System.out.print("이메일 > ");
		email = inputWithoutSpace();

		System.out.print("주소 > ");
		address = inputWithoutSpace();

		System.out.print("생일 > ");
		birthday = inputWithoutSpace();

		System.out.print("그룹 > ");
		group = inputWithoutSpace();

		Contact contact = null;

		if (select == 1) {

			String company = null;
			String department = null;
			String position = null;

			System.out.print("회사 > ");
			company = inputWithoutSpace();
			System.out.print("부서 >");
			department = inputWithoutSpace();
			System.out.print("직급 >");
			position = inputWithoutSpace();

			contact = new CompanyContact(name, phoneNumber, email, address, birthday, group, company, department,
					position);

		} else if (select == 2) {

			String company = null;
			String goods = null;
			String position = null;

			System.out.print("거래처 > ");
			company = inputWithoutSpace();
			System.out.print("판매 물품 > ");
			goods = inputWithoutSpace();
			System.out.print("담당자 > ");
			position = inputWithoutSpace();

			contact = new CustomerContact(name, phoneNumber, email, address, birthday, group, company, goods, position);

		}

		for (Contact con : contacts) {
			if (con != null && con.getPhoneNum().equals(phoneNumber)) {
				System.out.println("입력하신 것과 동일 번호가 이미 존재하므로 저장이 불가합니다.");
				return;
			}
		}

		// 요소 저장 후 계속 추가
		contacts.add(contact);

	}

	
	// 연락처 검색
	public void searchContact() {

		if (contacts.size() == 0) {
			System.out.println("현재 저장된 정보가 없습니다.");
			return;
		}

		String searchName = null;

		System.out.println("연락처 검색을 시작합니다.");
		System.out.println("검색할 연락처의 이름을 입력해주세요.");
		
		searchName = inputWithoutSpace();
		int index = getIndex(searchName);

		if (index == -1) {
			System.out.println("이름과 일치하는 정보가 존재하지 않습니다. \n처음 화면으로 돌아갑니다.");
			return;
		} else {
			contacts.get(index).chkContact();
		}

		// 반복문을 이용한 출력
//		for(Contact contact : contacts) {
//			if(contact.getName().equals(searchName)) {
//				System.out.println("------검색 결과------");
//				contact.chkContact();
//				return;
//			} 
//		}
//		System.out.println("이름과 일치하는 정보가 존재하지 않습니다.");

	}

	
	// 연락처 수정
	public void editContact() {

		if (contacts.size() == 0) {
			System.out.println("현재 저장된 정보가 없습니다.");
			return;
		}

		String searchName = null;

		System.out.println("연락처 수정을 시작합니다.");
		System.out.println("수정할 연락처의 이름을 입력해주세요.");
		
		searchName = inputWithoutSpace();

		int index = getIndex(searchName);

		if (index == -1) {
			System.out.println("해당하는 정보가 없습니다.");
			return;
		}

		String name = null;
		String phoneNumber = null;
		String email = null;
		String address = null;
		String birthday = null;
		String group = null;

		System.out.println("수정할 정보 유형을 선택해주세요.");
		System.out.println("1. 회사 정보 2. 거래처 정보 3. 취소");

		int select = inputStringToInt();

		if (select > 3 || select == 0) {
			System.out.println("허용되지 않은 범위입니다. 1-3 사이의 번호를 입력해주세요.");
			return;
		} else if (select == 3) {
			System.out.println("수정을 취소하고 첫 화면으로 돌아갑니다.");
			return;
		}

		System.out.print("이름 > (기존 정보 : " + contacts.get(index).getName() + " )");
		name = inputString();

		System.out.print("전화번호 > (기존 정보 : " + contacts.get(index).getPhoneNum() + " )");
		phoneNumber = inputPhoneNum();

		System.out.print("이메일 > (기존 정보 : " + contacts.get(index).getEmail() + " )");
		email = inputWithoutSpace();

		System.out.print("주소 > (기존 정보 : " + contacts.get(index).getAddress() + " )");
		address = inputWithoutSpace();

		System.out.print("생일 > (기존 정보 : " + contacts.get(index).getBirthday() + " )");
		birthday = inputWithoutSpace();

		System.out.print("그룹 > (기존 정보 : " + contacts.get(index).getGroup() + " )");
		group = inputWithoutSpace();

		Contact contact = null;

		if (select == 1) {

			String company = null;
			String department = null;
			String position = null;

			System.out.print("회사 > (기존 정보 : " + ((CompanyContact)contacts.get(index)).getCompany() + " )");
			company = inputWithoutSpace();
			System.out.print("부서 > (기존 정보 : " + ((CompanyContact)contacts.get(index)).getDepartment() + " )");
			department = inputWithoutSpace();
			System.out.print("직급 > (기존 정보 : " + ((CompanyContact)contacts.get(index)).getPosition() + " )");
			position = inputWithoutSpace();

			contact = new CompanyContact(name, phoneNumber, email, address, birthday, group, company, department,
					position);

		} else if (select == 2) {

			String company = null;
			String goods = null;
			String position = null;

			System.out.print("거래처 > " + "(기존 정보 : " + ((CustomerContact)contacts.get(index)).getCompany() + " )");
			company = inputWithoutSpace();
			System.out.print("판매 물품 > " + "(기존 정보 : " + ((CustomerContact)contacts.get(index)).getGoods() + " )");
			goods = inputWithoutSpace();
			System.out.print("담당자 > " + "(기존 정보 : " + ((CustomerContact)contacts.get(index)).getPosition() + " )");
			position = inputWithoutSpace();

			contact = new CustomerContact(name, phoneNumber, email, address, birthday, group, company, goods, position);

		}

	}

	
	// 연락처 삭제
	public void deleteContact() {

		if (contacts.size() == 0) {
			System.out.println("입력된 데이터가 존재하지 않습니다.");
			return;
		}

		String searchName = null;

		System.out.println("정보를 삭제합니다.");
		System.out.println("삭제하실 정보의 이름을 입력해주세요. >");
		searchName = scan.nextLine();

		int index = getIndex(searchName);

		if (index == -1) {
			System.out.println("해당하는 정보가 없습니다.");
			return;
		}

		contacts.remove(index);
		System.out.println("삭제를 완료하였습니다.");

	}

	
	// 저장된 모든 연락처 출력
	public void printAllContact() {

		System.out.println("저장된 연락처를 모두 불러옵니다.");

		if (contacts.size() == 0) {
			System.out.println("저장된 연락처가 없습니다.");
			return;
		}

		for (Contact contact : contacts) {
			contact.chkContact();
		}
		System.out.println("총 " + contacts.size() + "개의 연락처가 저장되어 있습니다.");

	}

	
// ------------------------------------------------------------	

	
	// 인덱스 반환 메소드
	private int getIndex(String searchName) {

		int index = -1;

		for (int i = 0; i < contacts.size(); i++) {
			if (contacts.get(i).getName().equals(searchName)) {
				index = i;
				break;
			}
		}
		return index;
	}

	
	// 공백 제외 메소드
	public String inputWithoutSpace() {

		String str = null;

		while (true) {
			str = scan.nextLine();

			if (str != null && str.trim().length() != 0) {
				break;
			} else {
				System.out.println("공백과 띄어쓰기를 제외한 형식으로 입력해주세요.");
			}
		}
		return str;
	}

	
	// 스트링 타입을 정수로 변환, 그 외 다른 문자 입력시 예외 처리
	public int inputStringToInt() {

		int result = 0;

		String str = scan.nextLine();

		try {
			result = Integer.parseInt(str);
		} catch (Exception e) {
			System.out.println("숫자만 입력 가능합니다. 다시 입력해주세요.");
		}
		return result;
	}

	
	// 이름 입력시 공백 X, 한글 및 영대소문자만 가능
	public String inputString() {

		String tempName = null;

		while (true) {

			tempName = scan.nextLine();

			if (tempName != null && tempName.trim().length() != 0) {

				if (Pattern.matches("^[a-zA-Z가-힣ㄱ-ㅎ]*$", tempName)) {
					break;
				} else {
					System.out.println("한글 및 영대소문자만 입력 가능합니다. \n 다시 입력해주세요.");
				}
			} else {
				System.out.println("공백이나 띄어쓰기를 제외한 문자를 입력해주세요.");
			}
		}
		return tempName;

	}

	
	// 공백 없이 정해진 형식으로 입력되었는가->중복된 번호인가
	public String inputPhoneNum() {

		String tempPhoneNum = null;

		while (true) {

			tempPhoneNum = inputWithoutSpace();

			if (Pattern.matches("^\\d{3}-\\d{4}-\\d{4}+$", tempPhoneNum)) {
			
				boolean chk = false;
	
				for( Contact con : contacts) {
					// 동일하면 반복문을 벗어나 print 출력
					if(con.getPhoneNum().equals(tempPhoneNum)) {
						chk = true;
						break;
					} 
				}
				if(chk) {
					System.out.println("동일한 번호가 이미 존재합니다. 다시 입력해주세요.");
					// continue;  // 다음 단계 진행하지 않고 반복
				} else {
					break;
				}
				// break; // continue 시행시 필요(탈출 목적)
			} else {
				System.out.println("허용되지 않는 형식입니다. 010-0000-0000 형태로 입력해주세요.");
			}
		}
		return tempPhoneNum;
	}

}
