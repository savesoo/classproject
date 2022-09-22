package personal;

public class ContactMain {
	
	public static void main(String[] args) {
		
		Contact c1 = new Contact("류","010-1112-1516","ryu@gamil.com","파리",19900101,"회사");
		System.out.println("----저장 정보----");
		System.out.println("이름 : " + c1.getName());
		System.out.println("전화번호 : " + c1.getPhoneNum());
		System.out.println("이메일 : " + c1.getEmail());
		System.out.println("주소 : " + c1.getAddress());
		System.out.println("생일 : " + c1.getBirthday());
		System.out.println("그룹 : " + c1.getGroup());
		
		System.out.println();
		
		Contact c2 = new Contact("임","010-0607-2020");
		c2.chkContact();
		
		System.out.println();
		
		c2.setName("Lee");
		c2.setPhoneNum("010-0000-2222");
		c2.setEmail("lhy@gmail.com");
		c2.setAddress("강릉");
		c2.setBirthday(19900101);
		c2.setGroup("동아리");
		
		c2.chkContact();
		
	}

}
