package Project05;

public class CompanyContact extends Contact {
	
	private String company;
	private String department;
	private String position;
	
	public CompanyContact(String name, String phoneNum, String email, String address, String birthday, String group, 
			String company, String department, String position) {
		super(name, phoneNum, email, address, birthday, group);
		this.company = company;
		this.department = department;
		this.position = position;
	}
	
	@Override
	public void chkContact() {
		super.chkContact();
		System.out.println();
		System.out.println("------회사 정보------");
		System.out.println("회사명 : " + this.company);
		System.out.println("부서명 : " + this.department);
		System.out.println("직급 : " + this.position);
		System.out.println();
	}

	public String getCompany() {
		return company;
	}

	public String getDepartment() {
		return department;
	}

	public String getPosition() {
		return position;
	}
	
	
//	public static void main(String[] args) {
//		CompanyContact cc = new CompanyContact(null, null, null, null, 0, null, null, null, null);
//		CustomerContact cc2 = new CustomerContact(null, null, null, null, 0, null, null, null, null);
		
//		Contact c1 = cc;
//		Contact c2 = cc2;	
		
//		CompanyContact cc1 = null;
		
//		if (c1 instanceof Contact) {
//			System.out.println("가능");
//		} else {
//			System.out.println("--");
//		}
//	}

	@Override
	public void showData() {
		
	}

	
}



