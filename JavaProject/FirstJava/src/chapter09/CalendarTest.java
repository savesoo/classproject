package chapter09;

import java.util.Calendar;

public class CalendarTest {
	
	public static void main(String[] args) {
		
		Calendar cal1 = Calendar.getInstance();
		//System.out.println(call);
		
		System.out.println(cal1.getTime());
		System.out.println(cal1.getTimeInMillis()); // 현재시간 정보를 밀리초로 가져오기
		
		// 현재 시간에서 1시간 증가 (감소는 -1)
		cal1.add(Calendar.HOUR, 1); 
		System.out.println(cal1.getTime());
		
		Calendar cal2 = Calendar.getInstance();
		Calendar cal3 = Calendar.getInstance();
		
		// 현재 날짜 정보가 아닌 특정 날짜와 시간 지정. 월의 경우 0~11까지 넣어줌.
		cal2.set(2002, 5, 4); // 날짜만 변경
		cal3.set(2000, 0, 1, 0, 0, 1); // 시분초까지 변경
		
		System.out.println(cal2.getTime()); 
		System.out.println(cal3.getTime());
		
		// cal1 2022, cal3 2000
		System.out.println(cal1.before(cal3)); // 1이 3보다 이전 시점인가?
		System.out.println(cal1.after(cal3));
		
		
	}

}
