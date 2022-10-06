package chapter12;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializableTest {
	
	public static void main(String[] args) {
		
		String msg = "안녕하세요";
		
		ObjectOutputStream outputStream = null;
		
		try {
			outputStream = new ObjectOutputStream(new FileOutputStream("instanceData.ser"));
			// .ser 확장자를 권장
			
			outputStream.writeObject(msg); // 직렬화 가능한 객체가 와야 함
			
			Person p = new Person("김효진", 29);
			
			//직렬화해서 처리하고 싶어요!
			outputStream.writeObject(p);
			
			ArrayList<Person> list = new ArrayList<>();
			list.add(new Person("l",28));
			list.add(new Person("c",28));
			list.add(new Person("p",27));
			list.add(new Person("s",27));
			list.add(new Person("y",24));
			
			outputStream.writeObject(list);
			
			System.out.println("저장 되었습니다.");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		
	}

}
