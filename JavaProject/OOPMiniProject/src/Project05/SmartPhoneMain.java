package Project05;

public class SmartPhoneMain {
	
	public static void main(String[] args) {
		
		SmartPhone smartphone = SmartPhone.getInstance();
		
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
			
			int insert = smartphone.scan.nextInt();
			smartphone.scan.nextLine();
			
			switch(insert) {
			case 1:
				smartphone.inputContact(); // 저장
				break;
			case 2:
				smartphone.searchContract(); // 검색
				break;
			case 3:
				smartphone.editContact(); // 수정
				break;
			case 4:
				smartphone.delContact(); // 삭제
				break;
			case 5:
				smartphone.printAllData(); // 출력
				break;
			case 6:
				System.out.println("프로그램이 종료되었습니다.");
				return;
			}
		}
	}

}
