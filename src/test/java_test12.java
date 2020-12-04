package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
수퍼마켓의 계산 줄을 처리하는데 소요되는 전체 시간을 구하는 프로그램을 작성한다.
문제의 입력으로는 정수 리스트와 정수값 하나가 제시된다. 리스트는 고객을 의미하며, 다른 정수값은 계산대의 개수이다. 리스트 내의 각 정수값은 개별 고객으로 각 고객이 계산을 마치는데 필요한 시간을 정의한다.

규칙
빈 계산대가 없으면 나머지 손님은 모두 기다려야 한다.
빈 계산대가 나타나면 계산줄을 무조건 앞에서부터 처리된다.
모든 손님이 계산대 통과를 완료해야 한다.
*/
public class java_test12 {
	static final int SPACE = 7;
	public static void main(String args[]) {
		test();
	}
	
	public static void test() {
		int total = 0;
		List<Integer> customers = new ArrayList<>();
		List<Integer> counters = new ArrayList<>();
		int customer_count = 0;
		int counter_count = 0;
		
		Random r = new Random();
		customer_count = r.nextInt(11) + 5;
		counter_count = r.nextInt(3)+2;
		for(int i = 0; i < customer_count; i++) customers.add(r.nextInt(10)+1);
		System.out.println("Customers count : " + customers.size());
		for(Integer cust : customers) System.out.print("[" + cust + "] "); System.out.println();
		System.out.println("Counter count : " + counter_count); System.out.println();
		
		for(int a = 0;a < counter_count; a++) System.out.print(String.format("%-"+SPACE+"s", "("+(a+1)+")")); System.out.println();
		for(int a = 0;a < counter_count; a++) System.out.print(String.format("%-"+SPACE+"s", "====")); System.out.println();
		for(int c = 0, len = customers.size(); c < len; c++) {
			int customer = customers.get(c);
			if(c < counter_count) {
				counters.add(customer);
				getCounters(counters, -1);
			}else {
				int min = Collections.min(counters);
				int idx = counters.indexOf(min);
				counters.set(idx, min + customer);
				getCounters(counters, idx);
			}
		}
		total = Collections.max(counters);
		System.out.println("총 소요 시간 : " + total);
		getCounters(counters, -1);
	}
	
	public static void getCounters(List<Integer> counters, int g) {
		int len = counters.size();
		for(int c = 0; c < len; c++) System.out.print(String.format("%-"+SPACE+"s", (g == c) ? "[" + counters.get(c) + "]  " : counters.get(c) + "  " )); System.out.println();
	}
}
