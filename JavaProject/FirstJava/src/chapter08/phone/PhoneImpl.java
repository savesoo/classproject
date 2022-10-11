package chapter08.phone;

public class PhoneImpl implements Phone {

	boolean power;

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

		// power
		// false: 꺼져 있는 상태
		if (!power) {
			power = true;
		}

	}

	@Override
	public void turnOff() {
		if (power) {
			power = false;
		}

	}

}
