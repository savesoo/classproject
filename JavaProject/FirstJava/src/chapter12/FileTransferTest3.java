package chapter12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileTransferTest3 {

	public static void main(String[] args) {
		
		// 파일 복사
		// 프로그램 입장에서는 특정 파일의 데이터를 읽어서 다른 위치의 파일에 쓰는 것 -> 복사
		
		// 원본 파일
		InputStream in = null;
		// 복사본 파일
		OutputStream out = null;
		
		int copyByte = 0; // 총 복사한 데이터 사이즈 체크
		int byteDataSize = 0;
		byte[] bufData = new byte[1024];
		
		try {
			in = new FileInputStream("c:\\Test\\test.zip");
			out = new FileOutputStream("c:\\Test\\testCopy1.zip");

		
			System.out.println("복사가 시작되었습니다.");
		
			while(true) {
			
				byteDataSize = in.read(bufData);
			
				if(byteDataSize == -1) {
					break;
				}
				
				// 원본, 0부터, 몇개의 데이터가 들어가있다
				out.write(bufData, 0, byteDataSize); // 새로운 파일에 데이터 쓰기
				copyByte += byteDataSize;
			}
		
			System.out.println("복사 완료!");
			System.out.println("복사한 파일의 size : " + copyByte);
		
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		} finally {
		
			if(in != null) {
			
				try {
				
					in.close();
				
				} catch (IOException e) {
				
					e.printStackTrace();
				}
			}
		}
		
	}
}
