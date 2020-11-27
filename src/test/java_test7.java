package test;

import java.util.ArrayList;
import java.util.Arrays;

/**
피보나치 수열이란, 첫 번째 항의 값이 0이고 두 번째 항의 값이 1일 때, 이후의 항들은 이전의 두 항을 더한 값으로 이루어지는 수열을 말한다.

예) 0, 1, 1, 2, 3, 5, 8, 13
인풋을 정수 n으로 받았을때, n 이하까지의 피보나치 수열을 출력하는 프로그램을 작성하세요
*/
public class java_test7 {
	static final int LIMIT = 100;
	public static void main(String args[]) {
		test(LIMIT);
		System.exit(0);
	}
	
	public static void test(int limit) {
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(0,1));
		if(limit <= 1) {
			System.out.println("입력된 수가 너무 작습니다.");
		}else {
			for(int i = 2, num = 0; num < limit; i++) {
				num = list.get(i-2) + list.get(i-1);
				if(num <= limit) list.add(num);
			}
			for(int n : list) System.out.print(n+" ");
		}
	}
}