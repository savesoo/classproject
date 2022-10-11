package chapter12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest1 {
	
	public static void main(String[] args) {
		
		// 파일 읽기 : InputStream -> FileInputStream
		FileInputStream in = null;
		
		try {
			in = new FileInputStream("c:\\Test\\testfile1.txt");
			
			int data = in.read();
			System.out.println(data);
			System.out.println((char)data); // 형변환
		
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();

		} catch (IOException e) { // 여기서 에러 발생하면 인스턴스 생성 X
			
			e.printStackTrace();
		} finally {
			
			if(in != null) {
				try {
					in.close(); // null인데 close 처리 해주면 널익셉션 발생하므로
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
			
		}
		
		
	}

}
