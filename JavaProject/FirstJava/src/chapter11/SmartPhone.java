package chapter11;

public class SmartPhone implements Comparable<SmartPhone> {
	
	private String name;
	private String phoneNumber;
	
	public SmartPhone(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	// 값을 변경하지 못하게 하기 위해 getter 메소드만 생성
	public String getName() {
		return name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}


	// HashSet 중복 저장을 하지 않는다!
	// HashCode값 먼저 참조 -> equals 메소드로 비교
	
	@Override
	public int hashCode() {
		return phoneNumber.charAt(phoneNumber.length()-1); // 인덱스니까 -1 반환할 때는 int로 반환
		// 0 ~ 9 사이의 값이 나올 것 
	}

	@Override
	public boolean equals(Object obj) {
		
		boolean result = false;
		
		if(obj != null && obj instanceof SmartPhone) {
			SmartPhone phone = (SmartPhone)obj;
			result = phoneNumber.equals(phone.getPhoneNumber());
		}
	
		return result;
	}
	
	// TreeSetTest
	@Override
	public int compareTo(SmartPhone o) {
		return name.compareTo(o.getName())*-1; // 역순으로 정렬하고 싶을 때 : 
		//return name.compareTo(o.getName()); // 주소값이 아닌 String을 비교해서 반환
	}
	
	
	
	@Override
	public String toString() {
		return "SmartPhone [name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}


	

}
