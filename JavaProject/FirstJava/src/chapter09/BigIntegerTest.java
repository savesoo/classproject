package chapter09;

import java.math.BigInteger;

public class BigIntegerTest {
	
	public static void main(String[] args) {
		
		BigInteger bi1 = new BigInteger("100000000000000000000"); // 8byte 안에 들어갈 수 없는 숫자이므로 문자열 형태로 입력
		BigInteger bi2 = new BigInteger("100000000000000000000");
		
		System.out.println(bi1.add(bi2));
		System.out.println(bi1.subtract(bi2));
		System.out.println(bi1.multiply(bi2));
		System.out.println(bi1.divide(bi2));
		
	}

}
