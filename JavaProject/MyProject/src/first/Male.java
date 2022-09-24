package first;

public class Male extends Person {

	public Male(String name, int birth) {
		super(name, birth);
	}

	@Override
	void printHello() {
		super.printHello();
		System.out.println("성별은 남자입니다.");
	}

}
