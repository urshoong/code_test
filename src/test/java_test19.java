package test;

import java.util.Random;

/**
2진수가 주어졌을 때, 8진수로 변환하는 프로그램을 작성하시오.

첫째 줄에 2진수가 주어진다. 주어지는 수의 길이는 1,000,000을 넘지 않는다.

첫째 줄에 주어진 수를 8진수로 변환하여 출력한다.
*/
public class java_test19 {
	public static final int BLOCK = 3;
	public static final int MAX = 20;
	public static void main(String[] args) {
		String str = "11001100", str2 = "";
		StringBuilder rs = new StringBuilder();
		Random r = new Random();
		for(int i = 0, len = (r.nextInt(MAX) + 1); i < len; i++) rs.append(r.nextInt(2));
		int idx = rs.indexOf("1");
		str2 = rs.substring(idx < 0 ? 0 : idx);
		
		test(str);
//		System.out.println("before : " + rs);
		test(str2);
	}
	
	public static void test(String str) {
		StringBuilder result = new StringBuilder();
		StringBuilder rstr = new StringBuilder(); System.out.println("2진수 : " + str);
		rstr = new StringBuilder(str).reverse(); //System.out.println(rstr);
		char[] c = rstr.toString().toCharArray();
		for(int i = 0, sum = 0, len = rstr.length(); i <= len; i++) {
			if(i == len) {
				if(i%3 != 0) result.append(sum);				
			}else {
				int a = Integer.parseInt(c[i]+""), limit = (i) % 3;
				sum += a * Math.pow(2, limit);
				if((limit + 1) == 3) { result.append(sum); sum = 0; }
			}
		}
		
		System.out.println("8진수 : " + new StringBuilder(result).reverse() + "\n");
	}
}
