package chapter08.exam;

// 2. Calculator 인터페이스를 상속하는 인스턴스를 생성할 수 있는 클래스를 정의해봅시다. 
public class CalculatorImpl implements Calculator {

	@Override
	public long add(long n1, long n2) {
		return n1+n2;
	}

	@Override
	public long substract(long n1, long n2) {
		return n1-n2;
	}

	@Override
	public long multiply(long n1, long n2) {
		return n1*n2;
	}

	@Override
	public double divide(double n1, double n2) {
		return n1/n2;
	}

	public static void main(String[] args) {

		// 3. 다형성의 특징으로 상위 타입인 인터페이스 타입의 참조변수에 
		// 인터페이스를 구현한 클래스 타입의 인스턴스를 참조하는 코드를 작성해봅시다.
		CalculatorImpl cal1 = new CalculatorImpl();
		Calculator cal2 = new CalculatorImpl();

		// 인스턴스 생성 가능한 코드가 완성된 상태
		// 여기 오버라이딩 된 코드는 한번 사용하면 소멸 -> 인스턴스 생성 후 소멸
		Calculator cal3 = new Calculator() {

			@Override
			public long substract(long n1, long n2) {
				return n1 + n2;
			}

			@Override
			public long multiply(long n1, long n2) {
				return n1 - n2;
			}

			@Override
			public double divide(double n1, double n2) {
				return n1 * n2;
			}

			@Override
			public long add(long n1, long n2) {
				return n1 / n2;
			}
		};

	}

}
