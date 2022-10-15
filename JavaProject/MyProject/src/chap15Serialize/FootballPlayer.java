package chap15Serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class FootballPlayer implements Serializable {

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

		// 2. 이 인스턴스 들을 파일로 저장하는 기능을 만들어 봅시다.

		ObjectOutputStream outputStream = null;

		try {
			outputStream = new ObjectOutputStream(new FileOutputStream("football.ser"));

			// 파일로 저장
			outputStream.writeObject(fbPlayers);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			if (outputStream != null) {
				outputStream.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		// 3. 저장된 파일을 객체로 만드는 기능을 만들어봅시다.

		ObjectInputStream inputStream = null;

		try {

			inputStream = new ObjectInputStream(new FileInputStream("football.ser"));

			ArrayList<FootballPlayer> list = (ArrayList<FootballPlayer>) inputStream.readObject();

			for (FootballPlayer fbp : list) {
				fbp.showPlayer();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if (inputStream != null) {
				inputStream.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
