package chapter11;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
	
	public static void main(String[] args) {
		
		HashSet<String> set =new HashSet<>();
		
		// 중복 체크 후 저장
		set.add("류정한");
		set.add("문성일");
		set.add("소정화");
		set.add("류정한");
		set.add("문성일");
		
		System.out.println("저장된 요소의 개수 : " + set.size());
		
		// 중복인 데이터는 저장되지 않았으므로 3개만 출력, 순서가 없으므로 무작위 출력
		Iterator<String> itr = set.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}

}
