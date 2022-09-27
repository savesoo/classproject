package chapter09;

public class Car extends Object {

	String name;
	
	Car(String name){
		this.name=name;
	}
		
//	@Override
//	public String toString() {
//		return name;                   // 반환형태 변경
//	}

	@Override
	public boolean equals(Object obj) { // Object에 속한 인스턴스 들어올 수 있음. 이때 비교하고 싶은 건 자동차 타입
		
		boolean result = false;
		
		if(obj != null && obj instanceof Car) { // Car 타입으로 변환이 가능한지 확인
			Car car = (Car)obj; // 상위->하위 형변환 연산자 명시적 표시
			result = this.name.equals(car.name); // 입력받은 이름이 기존 이름이랑 같은지 판단하고 참이면 ture 반환
		}
		
		return result;
	}


	@Override
	public String toString() {
		return "Car [name=" + name + "]";
	}
	
	public static void main(String[] args) {
		Car car1 = new Car("BMW");
		Car car2 = new Car("BMW");
		
		System.out.println(car1); // toString() -> 클래스의 풀네임@해시코드 16진수 형태로 출력됨
		//System.out.println(car1.hashCode()); // 10진수로 변환해 출력 
		System.out.println(car2);
		
		// 만약 car1 과 car2가 같을 때 참인지 확인
		System.out.println("car1 == car2 ->" + (car1==car2)); // 객체의 주소값을 비교한 것이라 결과는 false
		System.out.println("car1.equals(car2) ->" + car1.equals(car2));
		// Object equals() 메소드는 참조값 비교하고 결과를 반환하도록 정의
		// 메소드 오버라이딩 해서 문자열 비교가 필요함
		
		if(car1.equals(car2)) {
			System.out.println("동일한 차종입니다.");
		} else {
			System.out.println("다른 차종입니다.");
		}
		
	}

	
}
