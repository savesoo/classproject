package first;

public class Mem3Main {
	public static void main(String[] args) {

		Member3 pi1 = new Member3("이승준", "010-777-0113", "영어영문학", 3, "icyice@gmail.com");
		pi1.printInfo();

		System.out.println();
		System.out.println();

		Member3 pi2 = new Member3("김효진", "010-047-0803", "일어일문학", 4, "deer94@gmail.com", "", "서울시 마포구");
		pi2.printInfo();
		
		System.out.println();
		System.out.println();
		
		Member3 pi3 = new Member3();
		pi3.printInfo();

	}
}