package chapter05.exam;

public class MemberMain {

	public static void main(String[] args) {

		Member m1 = new Member("Kim", "010-4444-2222", "농구", 1, "Kim@gmail.com", 19990803, "런던");

		m1.showMemberInfo();

		Member m2 = new Member("Lee", "010-0113-1224", "축구", 2, "Lee@gmail.com");

		m2.showMemberInfo();
	}

}
