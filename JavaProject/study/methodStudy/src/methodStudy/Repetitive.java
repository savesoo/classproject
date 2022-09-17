package methodStudy;

public class Repetitive {
	// 구구단 (for문)

	public static void main(String[] args) {
		for (int i = 0; i < 5; ++i) {
			System.out.print("* ");
		}
		System.out.println();

		printTimesTable();
		printSquareStars();
		System.out.println();
		printTriangleStars();

	}

	public static void printTimesTable() {
		for (int s = 1; s < 10; s++) {
			for (int h = 1; h < 10; h++) {
				System.out.println(s + " X " + h + " = " + s * h);
			}
		}
	}

	public static void printSquareStars() {
		for (int f = 0; f < 5; ++f) {
			for (int u = 0; u < 5; ++u) {
				System.out.print(" * ");
			}
			System.out.println();
		}

		System.out.println();
		for (int f = 0; f < 5; ++f) {
			for (int u = 0; u < 5; ++u) {
				if (f == 0 || f == 4) {
					System.out.print(" * ");
				} else if ( u == 0 || u == 4) {
					System.out.print(" * ");
				}else {
					System.out.print("   ");
				}
			}
			System.out.println();
		}
	}

	public static void printTriangleStars() {
		for (int f = 0; f < 5; ++f) {
			for (int u = 0; u <= f; ++u) {
				System.out.print(" * ");
			}
			System.out.println();
		}

		System.out.println();

		for (int f = 0; f < 5; ++f) {
			for (int u = 0; u <= f; ++u) {
				if (u == f) {
					System.out.print(" * ");
				} else if (u == 0 || f == 4) {
					System.out.print(" * ");
				} else {
					System.out.print("   ");
				}
			}
			System.out.println();
		}
	}

}
