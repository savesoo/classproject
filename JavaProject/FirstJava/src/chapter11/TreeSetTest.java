package chapter11;

import java.util.TreeSet;

public class TreeSetTest {
	
	public static void main(String[] args) {
		
		TreeSet<SmartPhone> set = new TreeSet<>();
		
		set.add(new SmartPhone("Java", "010-0000-0000"));
		set.add(new SmartPhone("Kim", "010-0422-0803"));
		set.add(new SmartPhone("Lee", "010-7777-7777"));
		set.add(new SmartPhone("Brandon", "010-0113-0000"));
		set.add(new SmartPhone("MK", "010-1111-1111"));
		set.add(new SmartPhone("Sensation", "010-7777-7777"));
		
		System.out.println("요소의 개수 : " + set.size());
		
		for(SmartPhone sp : set) {
			System.out.println(sp);
		}
	}

}
