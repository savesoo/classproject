package chapter13;

public class SalesMain {
	
	public static void main(String[] args) {
		
		Product p = new Product(); // 사용할 자원, Data
		
		Customer c1 = new Customer(p);
		Customer c2 = new Customer(p);
		
		Seller seller = new Seller(p);
		


		try {
			c1.start();
			c2.start();
			
			Thread.sleep(5000);
			seller.start();
			
			c1.join(); // 끝날 때까지 보장
			c2.join();
			
			seller.join();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

		
	}

}
