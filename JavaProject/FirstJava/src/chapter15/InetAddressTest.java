package chapter15;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
	
	public static void main(String[] args) {
		
		String hostName = "www.naver.com";
		
		try {
			InetAddress ip = InetAddress.getByName(hostName);
			
			System.out.println(ip.getHostName());
			System.out.println(ip.getHostAddress()); 
			// 원하는 서버의 아이피를 알고 싶은 경우
			// 아이피는 바뀔 수 있다
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		
		
	}

}

