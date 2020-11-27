package test;

import java.util.ArrayList;

/**
다음은 233 이란 10진수를 2진수로 변환하는 과정을 나타낸 그림이다.
2진수   233 -> 11101001
8진수   233 -> 351
16진수 233 -> E9


위 그림을 참조하여 라이브러리를 사용하지 말고 10진수를 n진수로 변환하는 프로그램을 작성하시오.. (단, n의 범위는 2 <= n <= 16)
*/
public class java_test10 {
	static final int N10 = 233;
	static final int START = 2;//고정
	static final int END = 16;//고정
	static final boolean flag = true;
	static final String[] CHARS = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
	public static void main(String args[]) {
		test();
	}
	
	public static void test() {
		ArrayList<String> list = null;
		for(int i = START; i <= END; i++) {
			list = new ArrayList<>();
			int q = N10, r = 0;//q:몫 r:나머지
			System.out.println("["+i+"]");
			while(q >= i) {
				r = q % i;
				q = q / i;
				if(flag) System.out.println(" 몫 : " + q + " 나머지 : " + r);
				list.add(CHARS[r]);
			}
			list.add(CHARS[q]);//마지막에 남은 q는 r이다.
			System.out.print(i + "N -> "); for(int a = list.size() - 1; a >= 0; a--) System.out.print(list.get(a)); System.out.println();
		}
	}
}