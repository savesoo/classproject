package Project05;

public abstract class Contact implements ShowData {
	private String name;
	private String phoneNum;
	private String email;
	private String address;
	private String birthday;
	private String group;
	
	public Contact() {
		
	}

	public Contact(String name, String phoneNum, String email, String address, String birthday, String group) {

		this.name = name;
		this.phoneNum = phoneNum;
		this.email = email;
		this.address = address;
		this.birthday = birthday;
		this.group = group;
	}
	
	public Contact(String name, String phoneNum) {
		this(name, phoneNum, null, null, null, null);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public void chkContact() {
		System.out.println("----저장 정보----");
		System.out.println("이름 : " + this.name);
		System.out.println("전화번호 : " + this.phoneNum);
		System.out.println("이메일 : " + (this.email == null ? "미입력" : this.email));
		System.out.println("주소 : " + (this.address == null ? "미입력" : this.address));
		System.out.println("생일 : " + (this.birthday == null ? "미입력" : this.birthday));
		System.out.println("그룹 : " + (this.group == null ? "미입력" : this.group));

	}

}
