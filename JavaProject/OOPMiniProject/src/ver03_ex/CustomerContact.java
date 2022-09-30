package ver03_ex;

public class CustomerContact extends Contact00 {

	// ② CustomerContact
	// 회사, 거래처의 정보를 저장하는 하위 클래스를 정의합니다.
	// - 거래처회사이름, 거래품목, 직급 변수 추가
	// - 정보를 출력하는 메소드를 오버라이딩 해서 추가된 정보를 추가해서 출력

	private String company;
	private String product;
	private String manager;

	public CustomerContact(
			String name, String phoneNumber, String email, 
			String address, String birthday, String group,
			String company, String product, String manager) {

		super(name, phoneNumber, email, address, birthday, group);

		this.company = company;
		this.product = product;
		this.manager = manager;
	}

	
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}
	
	
	@Override
	public void printInfo() {
		System.out.println("거래처 이름 : " + this.company);
		System.out.println("거래  품목 : " + this.product);
		System.out.println("담  당  자 : " + this.manager);

		super.printInfo();
	}
	
	
	public static void main(String[] args) {
		Contact00 contact = new CompanyContact(
				"Kim", "010-1224-0113", "lkl@gmailcom", 
				"Berlin", "1994-04-03", "동료", 
				"온", "기획", "팀장");
		
				contact.printInfo();
	
	
	}
	

}
