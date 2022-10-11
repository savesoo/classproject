package chapter11;

import java.util.HashMap;
import java.util.Set;

public class HashMapTest {
	
	public static void main(String[] args) {
		
		
		HashMap<String, SmartPhone> hashMap = new HashMap<>();
		
		hashMap.put("Spring", new SmartPhone("Spring", "010-1111-1111"));
		hashMap.put("king", new SmartPhone("king", "010-2222-2222")); // 대소문자 구분할까? YES
		
		System.out.println(hashMap.get("king"));
		
		hashMap.put("Lee", new SmartPhone("Lee", "010-3333-3333"));
		hashMap.put("king", new SmartPhone("king", "010-7777-7777")); // 같은 Key값이어도 오류 발생X
		
		System.out.println("------------------------------------------");
		
		System.out.println(hashMap.get("king")); // 같은 Key값이어도 문제 없으나 나중에 입력된 값으로 변경됨
		System.out.println(hashMap.get("Lee"));
		System.out.println(hashMap.get("lee")); // 대소문자를 구분하므로 null 반환
		
		System.out.println("------------------------------------------");
		
		// hashMap이 가진 key 값들을 Set 객체로 받는다.
		Set<String> keySet = hashMap.keySet();
		
		for(String key : keySet) {
			//System.out.println(key); // key 값만 반환
			System.out.println(key + " = " + hashMap.get(key)); // 안에 든 value값을 불러올 수 있음
		}
	}

}
