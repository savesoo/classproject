package Project07;

public class SmartPhoneMain {
	
	public static void main(String[] args) {
		
		ListSmartPhone smartPhone = ListSmartPhone.getInstance();
		
		while(true) {
			
			System.out.println("======================");
			System.out.println("# 전화번호부");
			System.out.println("1. 연락처 저장");
			System.out.println("2. 연락처 검색");
			System.out.println("3. 연락처 수정");
			System.out.println("4. 연락처 삭제");
			System.out.println("5. 연락처 전체 출력");
			System.out.println("6. 종료");
			System.out.println("======================\n");
			System.out.println("원하시는 메뉴 번호를 입력해주세요.");
			
			// 메뉴 입력 시 발생할 수 있는 예외 처리
			int insert = smartPhone.inputStringToInt();
			
			switch(insert) {
			case 1:
				smartPhone.inputContact(); // 저장
				break;
			case 2:
				smartPhone.searchContact(); // 검색
				break;
			case 3:
				smartPhone.editContact(); // 수정
				break;
			case 4:
				smartPhone.deleteContact(); // 삭제
				break;
			case 5:
				smartPhone.printAllContact(); // 출력
				break;
			case 6:
				System.out.println("프로그램이 종료되었습니다.");
				return;
			}
		}
	}

}
