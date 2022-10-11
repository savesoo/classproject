package chapter08.phone;

public class PhoneMain {

	public static void main(String[] args) {

		PhoneImpl phone1 = new PhoneImpl();
		// 전원 켜기
		phone1.turnOn();
		// 전화 걸기
		phone1.call();
		// 전원 끄기
		phone1.turnOff();

		System.out.println(phone1.power);

		Phone phone01 = phone1; // 하위->상위 형변환 연산자 생략
								// 상위 타입인 Phone에 하위타입인 PhoneImpl 을 넣어준 것

		phone01.turnOn();
		phone01.call();
		phone01.turnOff();

		// System.out.println(phone01.power);
		// phone01일 때 Phone에는 존재하지 않는 멤버라 오류. PhoneImpl로 가야 있음.

		SmartPhone2 smartPhone2 = new SmartPhone2("sleeep@gmail.com");
		smartPhone2.turnOn();
		smartPhone2.call();

		System.out.println();
		smartPhone2.appRun("카카오톡");
		System.out.println();
		smartPhone2.appStop("카카오톡");

		Computer phone02 = smartPhone2; // smartPhone2 가 Computer를 상속하고 있기 때문에 가능
		Phone phone03 = smartPhone2;
		Application phone04 = smartPhone2;

		// ........

		smartPhone2.turnOff();

		System.out.println("----------------------------");

		SmartPhone3 phone3 = new SmartPhone3("god@mail.com");
		phone3.turnOn();
		phone3.call();
		phone3.appRun("네이버");
		phone3.appStop("네이버");

		Phone phone05 = phone3;

		// ..........

		phone3.turnOff();

		Phone[] list = new Phone[3]; // SmartPhone 1, 2, 3을 묶어서 배열로 묶어서 사용 가능 -> 일괄처리 가능!
		list[0] = phone1;
		list[1] = smartPhone2;
		list[2] = phone3;

		for (int i = 0; i < list.length; i++) {
			list[i].turnOn();
		}

	}

}
