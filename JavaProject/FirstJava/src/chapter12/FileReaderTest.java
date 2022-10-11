package chapter12;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileReaderTest {

	public static void main(String[] args) {

		char[] buf = new char[10]; // 문자 열 개씩 읽어오기
		int readCnt = 0;

		Reader reader = null;

		try {
			reader = new FileReader("c:\\Test\\text1.txt"); 
			// 이 경로의 파일을 읽어올 것

			while(true) {
				
				readCnt = reader.read(buf);
				
				if(readCnt == -1) {
					break;
				}
				
				System.out.println(new String(buf));
				
			}
			
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {                   // 반드시 close
			if(reader != null) {
				
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}

	}

}
