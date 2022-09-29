package chapter11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CollectionsTest {

	public static void main(String[] args) {

		List<Integer> lottoNumber = new ArrayList<>();

		// System.out.println(random.nextInt()); // int 범위 안의 값을 무작위 출력

		for (int i = 0; i < 6; i++) {
			lottoNumber.add(new Random(System.nanoTime()).nextInt(45) + 1);
		}

		System.out.println("로또 번호");
		printAll(lottoNumber);

		System.out.println();

		System.out.println("최대값 : " + Collections.max(lottoNumber));
		System.out.println("최소값 : " + Collections.min(lottoNumber));
		
		// 정렬
		Collections.sort(lottoNumber);
		System.out.println("정렬---------------");
		printAll(lottoNumber);
		
		// 역순으로 정렬(기본이 오름차순)
		Collections.reverse(lottoNumber);
		System.out.println("역순 정렬-----------");
		printAll(lottoNumber);
		
		// 섞기
		Collections.shuffle(lottoNumber);
		System.out.println("요소 위치 섞기 : 셔플");
		printAll(lottoNumber);
		
		List<Integer> list1 = Collections.emptyList(); // 리스트를 비어있는 형태로 반환!
		System.out.println("List 요소의 개수 : " + list1.size());

	}

	static void printAll(List<Integer> list) {
		for (int n : list) {
			System.out.println(n);
		}
	}

}
