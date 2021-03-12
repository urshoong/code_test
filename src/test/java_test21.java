package test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
김형택이 세운 나라의 화폐 체계는 단순하다. 이곳은 동전만 사용하고, 동전은 다음과 같이 다른 값을 가진다.

1, 10, 25, 100, 1000, 2500, 10000, 100000, ...

식으로 나타내면 0보다 크거나 같은 모든 K에 대해서 10^K인 동전과 25*100^K인 동전이 있다.

이기훈은 이 나라에서 새로운 차를 한 대 사려고 한다. 이기훈은 차를 살 때, 가능하면 동전의 개수를 최소로 하려고 한다. 이기훈이 필요한 동전 개수의 최솟값을 출력하는 프로그램을 작성하시오. (모든 값의 동전의 개수는 무한하고, 차를 살 때 정확하게 차의 값만큼 지불해야 한다.)

첫째 줄에 테스트 케이스의 개수 T가 주어진다. 둘째 줄부터 T개의 줄에 차의 값이 주어진다. 이 값은 10^15보다 작거나 같은 자연수이다.

총 T개의 줄에 각각의 테스트 케이스의 필요한 동전의 개수를 출력한다.

예제 입력 1 
2
47
9
예제 출력 1 
5
9
*/
public class java_test21 {
	public static final Long MAX = (long) Math.pow(10, 15);
	public static LinkedList<Long> COINS = new LinkedList<Long>();
	public static long[] CASES = null;
	public static Scanner s = null;
	public static int TOTAL = 0;
	public static void main(String[] args) {
		initCOINS();
		test();
	}
	
	public static void test() {
		setCASES();
		runTest();
	}
	
	public static void runTest() {
		System.out.println("------------------------------------------------------");
		for(int i = 0, iend = CASES.length; i < iend; i++) {
			TOTAL = 0;
			long c = CASES[i];
			int maxIDX = 0, m = -1, n = -1;
			for(int j = COINS.size()-1, jend = 0; j >= jend; j--) {
//				System.out.println(c / COINS.get(j) + "\tcoin : " + COINS.get(j));
				if(c / COINS.get(j) > 0) {
					maxIDX = j;
					break;
				}
			}
			while(n != 0) {
				m = (int) (c / COINS.get(maxIDX));
				n = (int) (c % COINS.get(maxIDX));
//				System.out.println("m : " + m + "\tn : " + n + "\tc : " + c + "\tcoin : " + COINS.get(maxIDX));
				if(m > 0) {
					c -= COINS.get(maxIDX) * m;
					TOTAL += m;
				}
				maxIDX--;
			}
			System.out.println(TOTAL);
		}
	}
	
	public static void setCASES() {
		System.out.println();
		s = new Scanner(System.in);
		int c = s.nextInt();
		CASES = new long[c];
		for(int i = 0, len = CASES.length; i < len; i++) {
			s = new Scanner(System.in);
			long l = s.nextLong();
			CASES[i] = l;
		}
	}
	
	public static void initCOINS() {
		setCOINS(1,10);
		setCOINS(25,100);
		sortCOINS();
//		showCOINS();
	}
	
	public static void setCOINS(int key1, int key2) {
		long l = 0;
		int i = 0;
		while(l <= MAX) {
			l = key1 * (long)Math.pow(key2, i++);
			COINS.add(l);
		}
	}
	
	public static void sortCOINS() {
		Collections.sort(COINS);
	}
	
	public static void showCOINS() {
		for(long l : COINS) System.out.println(l);
	}
}
