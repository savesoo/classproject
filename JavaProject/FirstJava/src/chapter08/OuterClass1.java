package chapter08;

public class OuterClass1 {
	
	OuterClass1(){
		NestedClass nst = new NestedClass();
		nst.simpleMethod();
	}
	
	static class NestedClass {
		public void simpleMethod() {
			System.out.println("NestedClass Instance"); // 인스턴스 내부에서 사용할 수 있는 같은 멤버로 본 것
		}
	}
	
	public static void main(String[] args) {
		OuterClass1.NestedClass nst1 = new OuterClass1.NestedClass();
		//nst1.simpleMethod();
		
		OuterClass1 o = new OuterClass1();
	}

}
