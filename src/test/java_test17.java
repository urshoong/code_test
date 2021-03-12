package test;

import java.awt.List;
import java.util.ArrayList;
import java.util.Random;

/**
유진수는 어떤 수를 10진수로 표현한 뒤 그 수를 두 부분으로 나눴을 때, 앞부분 자리수의 곱과 뒷부분 자리수의 곱이 같을 때를 말한다.

예를 들어, 1221은 유진수이다. 12와 21로 나눴을 때, 앞부분 자리수의 곱 1*2는 뒷부분 자리수의 곱 2*1과 같기 때문이다. 1236도 마찬가지로 유진수이다. 하지만, 1234는 아니다. 수를 나눌 때 항상 연속된 자리수를 나눠야하고, 각 부분에 적어도 한자리는 있어야 한다.

예를 들어, 12345는 총 4가지 방법으로 나눌 수 있다. 1-2345, 12-345, 123-45, 1234-5 어떤 수 N이 주어질 때, 이 수가 유진수인지 아닌지 구하는 프로그램을 작성하시오.

첫째 줄에 수 N이 주어진다. 이 수는 2,147,483,647보다작거나 같은 자연수이다.

첫째 줄에 N이 유진수이면 YES, 아니면 NO를 출력한다.
*/
public class java_test17 {
	public static void main(String args[]) {
		test();
	}
	
	public static void test() {
		boolean flag = true;
		while(flag) {
			int N = Math.abs(new Random().nextInt() * Integer.MAX_VALUE + 1); System.out.println("N : " + N);
			char[] c = (N+"").toCharArray();
			ArrayList<Integer> t1 = null, t2 = null;
			for(int i = 1, ilen = c.length, s1 = 1, s2 = 1; i < ilen; i++) {
				t1 = new ArrayList<Integer>(); t2 = new ArrayList<Integer>();
				s1 = 1; s2 = 1;
				for(int cnt = 0, a = 0, b = i, x = 0, y = 0; cnt < ilen; cnt++ ) {
					if(a < i) { x = Integer.parseInt(c[a]+""); s1 *= x; t1.add(x); a++; }
					if(b < ilen) { y = Integer.parseInt(c[b]+""); s2 *= y; t2.add(y); b++; }
				}
				for(int x : t1) System.out.print(x); System.out.print("-"); for(int x : t2) System.out.print(x); 
				if(s1 != 0 && s2 != 0 && s1 == s2)	{ System.out.println("\t["+s1+":"+s2+"] <<유진수>>"); flag = false; }
				else								{ System.out.println("\t["+s1+":"+s2+"]"); }
			}
			System.out.println();
		}
	}
}
