package chapter12;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest {

	public static void main(String[] args) {

		try (BufferedReader in = new BufferedReader(new FileReader("c:\\Test\\text2.txt"))) {

			while (true) {

				String str = in.readLine(); // 행단위로 처리가 되기 때문에 읽을 때도 행 단위

				if (str == null) {
					break;
				}
				System.out.println(str);
			}

			System.out.println("프로그램 종료");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
