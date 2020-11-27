package test;

import java.util.TreeSet;
import java.util.concurrent.Executors;

/**
심술쟁이 수는 2,3,5의 곱으로 만들 수 있는 수이다. 다음과 같은 순서의 수가 11개의 심술쟁이 수이다.
1,2,3,4,5,6,8,9,10,12,15,....

처음 수는 1로 시작하도록 한다. 입력은 받지 않고, <number> 에 1500번째 심술쟁이 수가 출력되게 한다.

The 1500'th ugly number is <number>.
답 859963392
(1550번째는 1093500000, 십만번째는 290142196707511001929482240000000000000)
*/
public class java_test5 {
	static final int NUMBER = 1500;
	public static void main(String args[]) {
		System.out.println("START");
//		Executors.newSingleThreadExecutor().execute(()->{ test(); });
		Executors.newSingleThreadExecutor().execute(()->{ test2(); });
		System.exit(0);
	}
	/** 내꺼 */
	public static void test() {
		StringBuffer sb = new StringBuffer();
		sb.append("[ test1 ] ");
		long t1 = System.currentTimeMillis();
		long t2 = 0;
		long i = 1;
		int c = 0;
		for(; c < NUMBER;i++) {
			long a = i;
			
			while(a % 2 == 0) a /= 2;
			while(a % 3 == 0) a /= 3;
			while(a % 5 == 0) a /= 5;
			
			if(a == 1) c++;
			if(c == NUMBER) break;
		}
		t2 = System.currentTimeMillis();
		sb.append(NUMBER).append(" 번째 심술쟁이 수 : ").append(i);
		sb.append(" (").append(t2-t1).append(" ms").append(")");
		System.out.println(sb);
	}
	
	/** 1등 풀이 java 코드로 구현 */
	public static void test2() {
		StringBuffer sb = new StringBuffer();
		sb.append("[ test2 ] ");
		long t1 = System.currentTimeMillis();
		long t2 = 0;
		
		TreeSet<Long> set = new TreeSet<>();
		int i = 0;
		Long uglyNumber = (long) 0;
		set.add((long) 1);
		do {
			uglyNumber = set.first();
			set.remove(uglyNumber);
			set.add(uglyNumber * 2);
			set.add(uglyNumber * 3);
			set.add(uglyNumber * 5);
			i++;
		}while(i < NUMBER);
		
		t2 = System.currentTimeMillis();
		sb.append(NUMBER).append(" 번째 심술쟁이 수 : ").append(uglyNumber);
		sb.append(" (").append(t2-t1).append(" ms").append(")");
		System.out.println(sb);
	}
}
