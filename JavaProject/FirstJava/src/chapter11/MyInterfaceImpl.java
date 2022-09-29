package chapter11;

public class MyInterfaceImpl<T1, T2> implements MyInterface<T1, T2> {

	@Override
	public T1 method1(T1 t) {
		return t;
	}

	@Override
	public T2 method2(T2 t) {
		return t;
	}

	public static void main(String[] args) {

		MyInterfaceImpl<String, Integer> myClass = new MyInterfaceImpl<String, Integer>(); // 생략해도 문제되지 않으나 적어줌
		// 제네릭 클래스 사용의의 : 처리하고 싶은 타입을 지정해줌으로써 보다 안전한 클래스 사용 가능

		System.out.println(myClass.method1("Ten"));
		System.out.println(myClass.method2(10)); // 괄호 안에 new Integer(10) 써도 됨
	}
	
}
