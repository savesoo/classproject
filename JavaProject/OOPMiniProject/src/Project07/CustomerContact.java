package Project07;

public class CustomerContact extends Contact {
	
	private String company;
	private String goods;
	private String position;
	
	public CustomerContact(String name, String phoneNum, String email, String address, String birthday, String group,
			String company, String goods, String position) {
		super(name, phoneNum, email, address, birthday, group);
		this.company = company;
		this.goods = goods;
		this.position = position;	
	}
	
	@Override
	public void chkContact() {
		super.chkContact();
		System.out.println();
		System.out.println("------거래처 정보------");
		System.out.println("거래처명 : " + this.company);
		System.out.println("거래 품목 : " + this.goods);
		System.out.println("직급 : " + this.position);
		System.out.println();
	}
	

	public String getCompany() {
		return company;
	}

	public String getGoods() {
		return goods;
	}

	public String getPosition() {
		return position;
	}
	

	// 인터페이스 상속
	@Override
	public void showData() {
		
	}

	
}
