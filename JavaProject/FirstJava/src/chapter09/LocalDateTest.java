package chapter09;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTest {
	
	public static void main(String[] args) {
		
		// jdk 1.8 부터 : LocalDate(날짜), LocalDateTime(날짜+시간), LocalTime(시간)
		// 현재 날짜를 가져오자!
		LocalDate now = LocalDate.now(); 
		System.out.println(now);
		System.out.println(now.getYear()); // 년도 반환
		System.out.println(now.getMonthValue()); // 해당 월의 숫자
		System.out.println(now.getMonth()); // Month: 해당 월의 이름
		System.out.println(now.getDayOfMonth()); // 해당하는 달의 몇 번째 날짜인지를 반환
		System.out.println(now.getDayOfWeek());
		
		LocalDate nextDay = now.plusDays(1).plusMonths(1).plusYears(1);
		System.out.println(nextDay);
		// 추가된 날짜 새롭게 생성. 즉 오늘을 기준으로 입력값만큼 더해서 반환
		
		System.out.println("================================");
		LocalTime now1 = LocalTime.now();
		System.out.println(now1);
		
		System.out.println(now1.getHour());
		System.out.println(now1.getMinute());
		System.out.println(now1.getSecond());
		System.out.println(now1.getNano());
		
		System.out.println("================================");
		LocalDateTime now2 = LocalDateTime.now();
		System.out.println(now2);
		
		System.out.println(now2.getYear());
		
		System.out.println("================================");
		
		LocalDate day = LocalDate.of(2022, 12, 24);
		System.out.println(day);
		LocalTime time = LocalTime.of(15, 30, 35);
		System.out.println(time);
		LocalDateTime localDateTime = LocalDateTime.of(2022, 10, 11, 17, 5);
		System.out.println(localDateTime);
		
	}



}
