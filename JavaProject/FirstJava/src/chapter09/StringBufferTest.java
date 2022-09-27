package chapter09;

public class StringBufferTest {
	
	public static void main(String[] args) {
		
		// StringBuffer, StringBuilder
		// StringBuffer : 멀티스레드에서 하나의 참조변수로 동시에 작업이 들어올 때 순차적으로 처리해줌. 동기화로 생기는 충돌 문제 방지
		// StringBuilder : 기능은 같으나 동기화 처리 X. 
		
		StringBuffer sb = new StringBuffer("Hello"); // 6+16 저장공간(문자열 끝에는 항상 null이 들어가서 +1됨)
		
		System.out.println(sb);
		
		// 문자열 붙이기
		sb.append("~");
		sb.append(false);  // String에는 concat, 버퍼에서는 append
		
		System.out.println(sb);
		
		// 특정 문자열 삭제
		System.out.println(sb.delete(0, 1)); // 인덱스 0~1 하나 빼기
		
		// 특정 위치에 문자열 삽입
		System.out.println(sb.insert(6, "~")); // 인덱스 6번째 자리를 삭제하고 대신 문자열 넣기
		System.out.println(sb.insert(sb.length(), true)); // 인덱스 다음 위치에 넣을게요 = append와 같은 기능
		
		System.out.println(sb.reverse()); // 현재 문자열을 역순으로 변경
		
		// 연산이 많은 String 클래스 대신 StringBuffer, StringBuilder를 사용해주면 cpu 점유율이 덜하고 효율적.
	}

}
