package chapter11;

import java.util.ArrayList;

public class WrapperClassTest {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(10); 
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		
		printAll(list);
		
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("King");
		list2.add("Kim");
		
		printAll(list2);
	}
	
	// 출력시 제네릭으로 처리해서 한 번에 받아서 처리가 가능
	static <E> void printAll(ArrayList<E> list) {
		for( E obj : list) {
			System.out.println(obj);
		}
		
	}
}
