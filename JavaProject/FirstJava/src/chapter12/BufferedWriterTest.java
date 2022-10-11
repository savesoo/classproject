package chapter12;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterTest {

	public static void main(String[] args) {

		// BufferedWriter out =null;

		try (BufferedWriter out = new BufferedWriter(new FileWriter("c:\\Test\\text2.txt"));) {
			// out = new BufferedWriter(new FileWriter("c:\\Test\\text2.txt"));

			out.write("홍차는 맛있다.");
			out.newLine(); // 개행
			out.write("녹차도 맛있다.");
			out.newLine();
			out.write("밀크티는 꽤 취향을 타지만 맛있다.");
			out.newLine();
			out.newLine();
			out.write("하지만 수분 보충이 되진 않으므로 물을 따로 섭취해야 한다.");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
