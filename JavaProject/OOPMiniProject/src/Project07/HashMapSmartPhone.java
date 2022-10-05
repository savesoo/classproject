package Project07;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;


public class HashMapSmartPhone implements ISmartPhone{

	private Map<String, Contact> contacts;
	Scanner scan;

	private HashMapSmartPhone() {
		contacts = new HashMap<>(10);
		scan = new Scanner(System.in);
	}

	private static HashMapSmartPhone mapsp = new HashMapSmartPhone();

	public static HashMapSmartPhone getInstance() {
		if (mapsp == null) {
			mapsp = new HashMapSmartPhone();
		}
		return mapsp;
	}

	// 저장
	public void inputContact() {

		if (contacts.size() == 10) {
			System.out.println("saved max can't save no more");
		}

		System.out.println("Contact save start");
		System.out.println("select 1. company 2. torihikisaki 3. cancel");

		int select = inputStringToInt();

		if (select > 3 || select == 0) {
			System.out.println("can't insert. plz return");
			return;
		} else if (select == 3) {
			System.out.println("it's canceled");
			return;
		}

		String name = null;
		String phoneNumber = null;
		String email = null;
		String address = null;
		String birthday = null;
		String group = null;

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

		contacts.put(name, contact);

	}

	// 검색
	public void searchContact() {

		if (contacts.size() == 0) {
			System.out.println("there is not exist saved one");
			return;
		}

		System.out.println("search start");
		System.out.println("plz input name what you wanna search");

		String searchName = null;
		searchName = inputString();

		if(contacts.get(searchName)!= null) {
			System.out.println("해당하는 정보가 없습니다.");
			return;
		}
		contacts.get(searchName).chkContact();

	}

	// 수정
	public void editContact() {

		if (contacts.size() == 0) {
			System.out.println();
			return;
		}

		System.out.println("수정을 시작합니다.");
		System.out.println("name");

		String searchName = inputString();
		// 이름 입력받아 객체 가져오기
		Contact c = getInfo(searchName);

		if (c == null) {
			System.out.println();
			return;
		}

		System.out.println("which type do you wanna edit? select it");
		System.out.println("1. company 2. customer 3. cancel");
		int select = inputStringToInt();

		if (select > 3 || select == 0) {
			System.out.println("wrong access");
			return;
		} else if (select == 3) {
			System.out.println("canceled");
		}

		String name = null;
		String phoneNumber = null;
		String email = null;
		String address = null;
		String birthday = null;
		String group = null;

		System.out.print("전화번호 > (기존 정보: " + c.getPhoneNum() + ")");
		phoneNumber = inputPhoneNum();

		System.out.print("이메일 > (기존 정보: " + c.getEmail() + ")");
		email = inputWithoutSpace();

		System.out.print("주소 > (기존 정보: " + c.getAddress() + ")");
		address = inputWithoutSpace();

		System.out.print("생일 > (기존 정보: " + c.getBirthday() + ")");
		birthday = inputWithoutSpace();

		System.out.print("그룹 > (기존 정보: " + c.getGroup() + ")");
		group = inputWithoutSpace();

		Contact contact = null;

		if (select == 1) {

			String company = null;
			String department = null;
			String position = null;

			System.out.print("회사 > (기존 정보: " + ((CompanyContact) c).getCompany() + ")");
			company = inputWithoutSpace();
			System.out.print("부서 > (기존 정보: " + ((CompanyContact) c).getDepartment() + ")");
			department = inputWithoutSpace();
			System.out.print("직급 > (기존 정보: " + ((CompanyContact) c).getPosition() + ")");
			position = inputWithoutSpace();

			contact = new CompanyContact(name, phoneNumber, email, address, birthday, group, company, department,
					position);

		} else if (select == 2) {

			String company = null;
			String goods = null;
			String position = null;

			System.out.print("거래처 > (기존 정보: " + ((CustomerContact) c).getCompany() + ")");
			company = inputWithoutSpace();
			System.out.print("판매 물품 > (기존 정보: " + ((CustomerContact) c).getGoods() + ")");
			goods = inputWithoutSpace();
			System.out.print("담당자 > (기존 정보: " + ((CustomerContact) c).getPosition() + ")");
			position = inputWithoutSpace();

			contact = new CustomerContact(name, phoneNumber, email, address, birthday, group, company, goods, position);

		}

	}

	// 삭제
	public void deleteContact() {

		if (contacts.isEmpty()) {
			System.out.println("저장된 정보가 없습니다.");
			return;
		}

		System.out.println("삭제를 시작합니다.");
		System.out.println("input the name what you wanna delete");

		String searchName = inputString();
		Contact c = getInfo(searchName);

		if (c == null) {

			System.out.println("해당하는 정보가 없습니다. ");
			return;

		} else if (c.getName().equals(searchName)) {
			contacts.remove(c);
			System.out.println("삭제가 완료되었습니다.");
		}

	}

	// 모든 연락처 출력
	public void printAllContact() {

		System.out.println("read all saved data");

		if (contacts.size() == 0) {
			System.out.println("there is nothing");
			return;
		}

		Set<String> key = contacts.keySet();
		for(String c : key ) {
			contacts.get(c).chkContact();
		}

		System.out.println("총 " + contacts.size() + "개의 연락처가 저장되어 있습니다.");
	}

	
	// -------------메소드------------------

	// 기존 정보 출력
	Contact getInfo(String name) {
	
		return contacts.get(name);
	}

	// 공백 제외
	public String inputWithoutSpace() {

		String str = null;

		while (true) {

			str = scan.nextLine();

			if (str != null && !(str.trim().isEmpty())) {
				break;
			} else {
				System.out.println("공백이나 띄어쓰기를 제외한 형식으로 입력해주세요. ");
			}
		}
		return str;
	}

	// 정해진 형식 아니면 재입력
	public String inputPhoneNum() {

		String tempPhoneNum = null;

		while (true) {
			tempPhoneNum = inputWithoutSpace();

			if (Pattern.matches("^\\d{3}-\\d{4}-\\d{4}+$", tempPhoneNum)) {
				break;
			} else {
				System.out.println("plz enter like 010-0000-0000");
			}
		}
		return tempPhoneNum;
	}

	// 스트링 타입을 정수로 숫자만 입력
	public int inputStringToInt() {
		
		int result = 0;
		
		String str = scan.nextLine();
		
		try {
			result = Integer.parseInt(str);
			
		} catch (Exception e) {
			System.out.println("you can write only number");
		}
		return result;
	}
	
	
	// 공백 제외 한글 및 영대소문자만 입력
	public String inputString() {
		
		String result = null;
		
		while (true) {
			
			result = scan.nextLine();
			
			if(result !=null && result.trim().length() !=0) {
				
				if(Pattern.matches("^[a-zA-zㄱ-ㅎ가-힣]*$", result)) {
					break;
				} else {
					System.out.println("you can only use alphabet");
				}
			} else {
				System.out.println("you can't enter empty space");
			}
		}
		return result;
	}

}
