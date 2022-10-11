package chapter11.exam;

public class FootballPlayer implements Comparable<FootballPlayer> {

	private String name;
	private int number;
	private String team;
	private int age;

	// 초기화 생성자 생성
	public FootballPlayer(String name, int number, String team, int age) {
		super();
		this.name = name;
		this.number = number;
		this.team = team;
		this.age = age;
	}

	// 기본 생성자 생성
	public FootballPlayer() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		return age;
	}

	@Override
	public boolean equals(Object obj) {

		boolean result = false;

		if (obj != null && obj instanceof FootballPlayer) {

			FootballPlayer player = (FootballPlayer) obj;
			// 팀과 이름 그리고 나이가 같으면
			result = team.equals(player.getTeam()) && name.equals(player.getName()) && age == player.getAge();
		}

		return result;
	}

	
	@Override
	public int compareTo(FootballPlayer o) {
		// 타입은 int이나 사실상 세 개의 값으로 구분됨
		// 팀 이름 -> 선수 이름 -> 번호 순
		int result = team.compareTo(o.getTeam());
		if(result == 0) {
			result = name.compareTo(o.getName());
			if(result == 0) {
				result = number - o.getNumber(); 
				// 등번호가 같으면 0, 크면 양수, 작으면 음수
				// Integer.compare(number, o.getNumber()) 사용 가능; x를 y와 비교
			}
		} 
		
		return result;
	}

	
	// 출력할 때를 대비해 toString 처리
	@Override
	public String toString() {
		return "FootballPlayer [name=" + name + ", number=" + number + ", team=" + team + ", age=" + age + "]";
	}

	
	// 현재 클래스의 기능 테스트 용도
	public static void main(String[] args) {

	}

}
