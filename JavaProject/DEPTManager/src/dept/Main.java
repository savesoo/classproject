package dept;

import java.util.Scanner;

public class Main {
	
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		//List list = new List();
		Command command = new Command();
		
		
		while(true) {
			
			menu();
			
			System.out.println("메뉴를 입력하세요. >>");
			int select = Integer.parseInt(sc.nextLine());
			
			//list.list.get(select).process();
			command.command.get(select).process();

			
//			switch(select) {
//			case 1:
//				//controller.select();
//				new SelectController().process();
//				break;
//			case 2:
//				//controller.selectByDeptno();
//				new SelectByController().process();
//				break;
//			case 3:
//				//controller.insert();
//				new InsertController().process();
//				break;
//			case 4:
//				//controller.update();
//				new UpdateControllr().process();
//				break;
//			case 5:
//				//controller.delete();
//				new DeleteController().process();
//				break;
//			case 6:
//				//controller.exit();
//				new ExitController().process();
//				
//			}
			
		}
		
	}
	
	public static void menu() {
		System.out.println("부서관리 프로그램");
		System.out.println("1. 전체 부서 리스트");
		System.out.println("2. 부서 검색");
		System.out.println("3. 부서 정보 저장");
		System.out.println("4. 부서 정보 수정");
		System.out.println("5. 부서 정보 삭제");
		System.out.println("6. 종료");
	}

}
