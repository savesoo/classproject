package chapter11;

import java.util.Iterator;
import java.util.LinkedList;

public class IteratorTest {
	
	public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<>();
		
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		
		// Iterator를 이용한 일괄 처리
		Iterator<Integer> itr = list.iterator();
		
		while(itr.hasNext()) {
			Integer integer = itr.next();
			// itr.next(); 두 번 사용하면 데이터의 유무에 상관없이 넘어가므로 X
			System.out.println(integer);
		}
		
	}
	
	static <E> void printAll(LinkedList<E> list) {
		for( E obj : list) {
			System.out.println(obj);
		}
		
	}

}
