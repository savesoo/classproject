package chapter08.phone;

// 상속과 구현 동시에, 다중상속처럼 사용
public class SmartPhone extends Computer implements Phone {

	boolean power;

	public SmartPhone(String account) {
		super(account);
		this.power = false;
	}

	@Override
	public void call() {
		// 119에 전화를 합니다
		// 상수를 이용해서 번호를 만들고 출력
		
		String number1 = String.valueOf(Phone.PHONE_NUM_1);
		String number9 = String.valueOf(Phone.PHONE_NUM_9);
		
		System.out.println(number1 + number1 + number9 + "에 전화합니다.");
		
	}

	@Override
	public void turnOn() {
		
		// true -> on, 전원이 있는 상태
		// false -> off, 전원이 없는 상태
		
		if(!power) {
			power = true;
		}
		
	}

	@Override
	public void turnOff() {
		if(power) {
			power = false;
		}
		
	}
	
	public static void main(String[] args) {
		
		SmartPhone phone = new SmartPhone("sleepy@gmail.com");
		
		phone.call();              // 인터페이스에 오버라이딩 된 것
		phone.calculator();        // 상위 클래스가 가진 멤버
		
	}

}
