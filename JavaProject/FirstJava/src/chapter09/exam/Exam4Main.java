package chapter09.exam;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Exam4Main {
	
	// 4. 자신의 생일을 기준으로 오늘까지 몇 일을 살았는지 출력하는 프로그램을 만들어봅시다. 
	public static void main(String[] args) {
		
		LocalDate birthday = LocalDate.of(1991, 01, 10);
		LocalDate now = LocalDate.now();
		
		// 두 개의 간격을 비교해서 반환해주는 함수 필요
		// 두 날짜를 비교해 일수를 반환해줌
		long days = ChronoUnit.DAYS.between(birthday, now);
		System.out.println(days);
		
		// 일수 아닌 개월수로도 반환 가능
		//long days = ChronoUnit.MONTHS.between(birthday, now);
		//System.out.println(days);
		
		// 캘린더에서 밀리초 가져와서 계산해도 되고~
		
		// 크리스마스까지 남은 날짜 계산
		LocalDate xMas = LocalDate.of(2022, 12, 25);
		
		long days2 = ChronoUnit.DAYS.between(xMas, now);
		System.out.println(days2);
		
		LocalDate dDay = now.plusDays(88); // 진짜 88일이 남았을까? 검증 위해 88일을 더해줌
		System.out.println(dDay);
	}

}
