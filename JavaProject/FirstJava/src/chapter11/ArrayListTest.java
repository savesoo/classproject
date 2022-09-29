package chapter11;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
	
	public static void main(String[] args) {
		
		// String 타입의 객체 저장을 위한 ArrayList 객체 생성
		ArrayList<String> list = new ArrayList<String>();
		//List<String> list1 = new ArrayList<String>();
		//List<String> list2 = new ArrayList(); // 앞에 String 타입을 써줬기 때문에 뒤에서는 생략 가능
		
		// 요소 저장
		list.add("류정한");
		list.add("임혜영");
		list.add(new String("문성일")); // 스트링 타입 따로 만들어주기 가능
		
		// 요소의 개수 length와 유사한 개념
		System.out.println("저장된 요소의 개수 : " + list.size());
		
		// 요소 참조. 인덱스 값으로 참조함~!
		System.out.println(list.get(0));
		
		// 일괄 참조 -> 일괄처리 해주기
//		System.out.println("----------전체 리스트 출력----------");
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
		printAll(list);
		
		// 특정 위치에 요소 추가
		list.add(1, "조정은");
		printAll(list);
		
		System.out.println(list.get(1)); // 내부 위치 확인
		
		// 요소 삭제
		list.remove(1);
		printAll(list);

	}
	
	// String 타입의 list만 올 수 있음!
	static void printAll(List<String> list) {
		System.out.println("----------전체 리스트 출력----------");
		for(String name :list) {
			System.out.println(name);
		}

//		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i));
//		}

		
	}
	
}
