package chapter07;

public class Buyer {
	
	int money; // 0 초기화가 아님. 초기화는 생성자 통해서~
	int myPoint;
	
	Buyer(int money){
		this.money = money;
	}
	
	void buy(Product p) {
		
		money = money - p.price; // 내가 가진 돈 차감
		// 보너스 증가
		myPoint += p.point;
		System.out.println(p + "제품을 구매했습니다.");
		// p -> p.toString
	}
	
	public static void main(String[] args) {
		
		// 제품 만들기 : TV 인스턴스, Computer 인스턴스
		TV tv = new TV(100);
		Computer com = new Computer(200);
		
		// 다형성
		Product p1 = tv;
		Product p2 = com;
		
		// 다형성을 이용한 배열
		Product[] products = new Product[5];
		products[0] = new TV(100);            // 상위[] = new 하위
		products[1] = new Computer(200);
		products[2] = new Computer(200);
		products[3] = new Computer(200);
		products[4] = new TV(100);
		
		System.out.println("--------판매 상품 리스트-------");
		for(int i=0; i<products.length; i++) {
			System.out.println(products[i] + "가격 : " + products[i].price);
		}
		System.out.println("---------------------------");
		
		// 구매자 생성
		Buyer buyer = new Buyer(1000);
		
		// 구매 테스트: tv, com, p1, p2
		buyer.buy(tv);
		buyer.buy(p2);
		buyer.buy(p1);
		buyer.buy(com);
		
	}

}
