package methodStudy;

import java.util.Scanner;

public class CheckBMI {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		double height;
		double weight;
		
		System.out.print("키를 입력해주세요.(단위: m)>> ");
		height = in.nextDouble();
		System.out.println();
		System.out.print("몸무게를 입력해주세요.(단위: kg)>> ");
		weight = in.nextDouble();
		System.out.println();
		
		//double bmi = getBMI(height, weight);
		//printConditionFactor(bmi);
		// 위 아래 동일 코드
		printConditionFactor(getBMI(height, weight));
		
		in.close();
	}
	
	public static double getBMI(double height, double weight) {
		return weight / (height * height);
	}
	
	public static void printConditionFactor(double bmi) {
		if(bmi<18.5) {
			System.out.println("저체중");
		} else if(bmi>=18.5 && bmi<25) {
			System.out.println("정상");
		} else if(bmi>=25 && bmi<30) {
			System.out.println("과체중");
		} else {
			System.out.println("비만");
		}
	}

}
