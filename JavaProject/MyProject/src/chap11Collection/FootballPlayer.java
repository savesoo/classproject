package chap11Collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class FootballPlayer implements Comparable<FootballPlayer> {

	private String name;
	private int number;
	private String team;
	private int age;

	public FootballPlayer(String name, int number, String team, int age) {
		super();
		this.name = name;
		this.number = number;
		this.team = team;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getNumber() {
		return number;
	}

	public String getTeam() {
		return team;
	}

	public int getAge() {
		return age;
	}

	@Override
	public int hashCode() {
		String samePl = team + name + age;
		return samePl.hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		boolean result = false;

		if (obj != null && obj instanceof FootballPlayer) {
			FootballPlayer fbp = (FootballPlayer) obj;
			result = this.name.equals(fbp.getName()) && this.team.equals(fbp.getTeam()) && this.age == fbp.getAge();
		}

		return result;
	}

	public void showPlayer() {
		System.out.println("이름 : " + name);
		System.out.println("번호 : " + number);
		System.out.println("소속팀 : " + team);
		System.out.println("나이 : " + age);
		System.out.println("------------------");
	}

	
	
	public static void main(String[] args) {
		
		
		// 1. 축구선수 인스턴스를 저장할 수 있는 List<E> 컬렉션 인스턴스를 생성해서
		// 인스턴스를 저장하고 출력하는 프로그램을 만들어 봅시다.
		ArrayList<FootballPlayer> fbPlayers = new ArrayList<>();
		
		fbPlayers.add(new FootballPlayer("Kim", 1, "red", 28));
		fbPlayers.add(new FootballPlayer("Lee", 2, "red", 27));
		fbPlayers.add(new FootballPlayer("Park", 3, "yellow", 27));
		fbPlayers.add(new FootballPlayer("Shim", 4, "blue", 26));
		fbPlayers.add(new FootballPlayer("Lee", 5, "Orange", 28));
		
		for( FootballPlayer tempfb : fbPlayers ) {
			tempfb.showPlayer();
		}
		
		
		System.out.println();
		System.out.println();
		

		// 2. 축구선수의 인스턴스가 팀과 이름 그리고 나이가 같으면 같은 선수라 판단하고
		// 입력이 되지 않도록 Set<E> 컬렉션을 이용해서
		// 축구선수 인스턴스를 저장하고 출력하는 프로그램을 만들어 봅시다.
		HashSet<FootballPlayer> set = new HashSet<>();
		
		set.add(new FootballPlayer("Kim", 1, "red", 28));
		set.add(new FootballPlayer("Lee", 2, "red", 27));
		set.add(new FootballPlayer("Park", 3, "blue", 26));
		set.add(new FootballPlayer("Park", 4, "blue", 26));
		set.add(new FootballPlayer("Lee", 5, "Orange", 28));
		
		for(FootballPlayer tempfb : set ) {
			tempfb.showPlayer();
		}
		
		
		System.out.println();
		System.out.println();

		
		// 3. TreeSet<E>을 이용해서 팀 이름순으로 정렬하고,
		// 같은 팀의 선수들은 이름 순으로 정렬하고,
		// 같은 이름의 선수는 번호 순으로 저장하는 프로그램을 만들어 봅시다.
		TreeSet<FootballPlayer> tree = new TreeSet<>();
		
		tree.add(new FootballPlayer("Kim", 1, "red", 28));
		tree.add(new FootballPlayer("Lee", 1, "red", 27));
		tree.add(new FootballPlayer("Park", 3, "blue", 26));
		tree.add(new FootballPlayer("Park", 4, "blue", 26));
		tree.add(new FootballPlayer("Lee", 1, "red", 28));
		
		for(FootballPlayer tempfb : tree ) {
			tempfb.showPlayer();
		}
		
		System.out.println();
		System.out.println();
		

		// 4. 축구선수의 번호를 key로 하고
		// 축구선수 인스턴스를 저장하는 Map<K,V> 인스턴스를 이용해서 프로그램을 만들어봅시다	
		HashMap<Integer, FootballPlayer> map = new HashMap<>();
		
		map.put(1, new FootballPlayer("Kim", 1, "red", 28));
		map.put(2, new FootballPlayer("Lee", 2, "red", 28));
		map.put(3, new FootballPlayer("Park", 3, "red", 28));
		map.put(4, new FootballPlayer("Shim", 4, "red", 28));
		map.put(5, new FootballPlayer("Lee", 5, "red", 28));
		
		Set<Integer> keys = map.keySet();
		for(Integer key : keys) {
			map.get(key).showPlayer();
		}
		
		
	}

	@Override
	public int compareTo(FootballPlayer o) {

		int result = team.compareTo(o.getTeam());

		if (result == 0) {
			result = name.compareTo(o.getName());
			if (result == 0) {
				result = Integer.compare(number, o.getNumber());
			}
		}

		return result;

	}

}
