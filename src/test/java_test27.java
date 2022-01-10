package test;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import sun.misc.PerformanceLogger;

/**
문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.

출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
*/

public class java_test27 {
	static boolean flag = false;
	static long timer1 = 0;
	static long timer2 = 0;
	public static void main(String[] args) {
		Integer[] test1 = {5,5,2,3,4,1};
		int[] test2 = {5,5,2,3,4,1};
		int[] test3 = gen();
		
		sort(test1);
		System.out.println("------------------------");
		sort(test2);
		System.out.println("------------------------");
		sort(test3);
	}
	
	public static void sort(Integer[] arr) {
		if(timer1 == 0) setTimer1();
		Set<Integer> set = new HashSet<Integer>(Arrays.asList(arr));
		//set으로 그냥 toString하면 일부 순서가 뒤바뀌는 현상 발생하여 List sort 한번 더 돌림
		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list);
		if(flag) setTimer2();
		System.out.println(list);
		if(flag) setTimer2();
		timer1 = 0;
	}
	
	public static void sort(int[] arr) {
		setTimer1();
		sort(Arrays.stream(arr).boxed().toArray(Integer[]::new));
	}
	
	public static int[] gen() {
		Random r = new Random();
		int max = r.nextInt(30)+1;
		int[] result = new int[max];
		for(int i = 0; i < max; i++) {
			result[i] = r.nextInt(1000)+1;
		}
		return result;
	}
	
	public static void setTimer1() {
		timer1 = System.nanoTime();
	}
	
	public static void setTimer2() {
		System.out.println(System.nanoTime() - timer1 + " n/s");
	}
}
