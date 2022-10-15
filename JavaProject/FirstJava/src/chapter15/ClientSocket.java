package chapter15;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocket {
	
	public static void main(String[] args) {
		
		try {
			Socket s = new Socket("localhost", 9999);
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			
			dout.writeUTF("안녕하세요. 류정한입니다.");
			dout.flush();
			
			dout.close();
			s.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
