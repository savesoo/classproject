package dept.domain;

// 데이터베이스 결과, 데이터베이스 insert로 저장해두고 사용함
// 별도의 컬럼을 만들어 출력하기도 하지만, select의 결과를 저장하기도 함

// DTO : Java Beans 형식으로 정의
// 모든 변수는 private 처리, 기본 생성자가 반드시 존재, getter/setter 메소드 존재
public class Dept {
	
	private int deptno;
	private String dname;
	private String loc;
	
	public Dept(int deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	public Dept() {
	}

	public int getDeptno() {
		return deptno;
	}

	public String getDname() {
		return dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
	}
	
	
	
	
	


}
