package chapter05.modifier;

public class PrivateTest {
	
	private String name;
	private int age;
	
	public PrivateTest() {
		super();
		this.name = "김효진";
		this.age = 28;
	}
	
	public void showInfo() {
		System.out.println("이름 : " + this.name);
		System.out.println("나이 : " + this.age);
	}
	
	

}
