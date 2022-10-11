package chapter11;

import java.util.LinkedList;

// ArrayList와 사용법은 같다 = 제네릭 사용해서 타입 맞춰주기
public class LinkedListTest {
	
	public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<>();
		
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		
		printAll(list);
		
	}
	
	static <E> void printAll(LinkedList<E> list) {
		for( E obj : list) {
			System.out.println(obj);
		}
		
	}

}
