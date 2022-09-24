package first;

public class Female extends Person {

	public Female(String name, int birth) {
		super(name, birth);
	}

	@Override
	void printHello() {
		super.printHello();
		System.out.println("성별은 여자입니다.");
	}

}
