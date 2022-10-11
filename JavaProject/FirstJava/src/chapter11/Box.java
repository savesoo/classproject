package chapter11;

public class Box {
	
	void insert(Orange o) {
		o.print();
	}
	
	void insert(Apple a) {
		a.print();
	}
 // 다른 타입이 들어오지 않도록 해줌!
	
//	void insert(Object o) {
//		System.out.println(o);
//	}
	
	public static void main(String[] args) {
		Box box = new Box();
		box.insert(new Orange());
		box.insert(new Apple());
		// box.insert(new String("Apple"));  // 입력되지 않은 다른 타입이라 처리 불가
	}

}


class Apple {
	void print() {
		System.out.println("Apple");
	}
}

class Orange {
	void print() {
		System.out.println("Orange");
	}
}
