package chapter06;

public class ArrayTest6 {
	
	public static void main(String[] args) {
		
		// 참조형변수를 다루는 배열 : 객체를 저장하는
		String[] names = new String[3];
		
		for(String name : names) {
			System.out.println(name);
		}
		
		names[0] = "김효진";
		names[1] = "이승준";
		names[2] = "이창윤";
		
		for(String name : names) {
			System.out.println(name);
		}
		
		System.out.println(names[0].length());
		System.out.println(names[1].equals("이승준"));
	}

}
