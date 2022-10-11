package chapter09;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassTest {
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		Class userClass = Class.forName("chapter09.User"); // Class 정보를 가지고 있음
		
		// 변수, 메소드, 생성자 같은 정보들을 가지고 오며 동적으로 클래스 인스턴트 생성이 가능.
		
		System.out.println("변수 리스트 ============");
		Field[] fieldList = userClass.getFields(); // 변수타입의 배열을 가져옴 +s 붙음
		
		//System.out.println(fieldList.length);
		
		for(Field f : fieldList) { // 필드값의 요소를 받을 수 있도록 처리
			System.out.println(f.getName()); // 메소드를 통해 해당 필드가 가진 이름(변수) 받아옴
		}
		
		System.out.println("생성자 리스트 ============");
		for(Constructor c : userClass.getConstructors()) {
			System.out.println("매개변수 개수"+c.getParameterCount());
			
			System.out.println("파라미터의 타입 ============");
			for(Class param : c.getParameterTypes()) {
				System.out.println(param.getName());
				
			}
		}
		
		System.out.println("메소드 리스트 ============");
		for(Method method : userClass.getMethods()) {
			System.out.println(method.getName());
		}
		
	}
	

}


