package chapter05;

public class LocalVariable {
	
	
	void method(int num) {
		// 매개변수도 지역변수
		
		int lv = 10; // 메소드 내부에서 선언되는 변수도 지역변수
		
		if(num>10) {
			boolean check = true; // 지역변수
		} else {
			boolean check = false;
		} // 블럭이 따로 나뉘어 두 개가 한 번에 실행되는 경우는 없으므로 같은 변수명 사용 가능
		
		// int lv = 100; 같은 블록 안이라 처리 불가
		
		for(int i=0; i<10; i++) {
			// i는 for 블록 안에서만 사용가능한 지역변수
		} 
		// System.out.println(i);
		
		while(lv<0) {
			int lv2 = 0;
			System.out.println(num++);
		}
		
		// System.out.println(lv2); 블록 벗어나서 처리 불가
		System.out.println(num++);
	
	}	
	
	public static void main(String[] args) {
		
		LocalVariable lv = new LocalVariable();
		lv.method(0);
	}
	
}


