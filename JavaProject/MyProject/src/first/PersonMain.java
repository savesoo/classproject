package first;

public class PersonMain {
	
	public static void main(String[] args) {	

	Person p1 = new Male("승준", 19901224);
	Person p2 = new Female("효진", 19910305);
	
	p1.printHello();
	p2.printHello();

	}
}
