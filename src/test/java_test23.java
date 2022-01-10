package test;

import java.util.Random;
import java.util.Scanner;

/**
어떤 수를 이진수로 나타냈을 때, 적어도 3개의 연속되는 수가 있을 때, 그 숫자를 멋진 수라고 한다. 예를 들어, 8 (1000), 15 (1111)와 같은 수는 멋진 수 이지만, 27(11011)은 멋진 수가 아니다.

입력으로 L과 R이 주어졌을 때, L보다 크거나 같고, R보다 같거나 작은 수 중에 멋진 수가 총 몇개 있는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 L과 R이 주어진다. R은 0보다 크거나 같고, 2147483647보다 작거나 같은 자연수이고, L은 0보다 크거나 같고, R보다 작거나 같은 자연수이다.

출력
첫째 줄에 입력으로 주어진 범위내에 멋진 수가 몇개있는지 출력한다.

예제 입력 1 
17 100
예제 출력 1 
49
*/
public class java_test23 {
	public static final int MIN = 0;
	public static final int MAX = 2147483647;
	public static Scanner s = null;
	public static Random r = null;
	public static void main(String args[]) {
		test();
	}
	
	public static void test() {
		System.out.println();
		s = new Scanner(System.in);
		String input = s.nextLine();
		String[] inputs = input.split(" ");
		if(inputs.length != 2) {
			System.out.println("초기 입력값 오류");
			test();
		}else {
			act(inputs);
		}
	}
	
	public static void act (String[] inputs) {
		NUM num = new NUM();
		num.setR(Integer.parseInt(inputs[0]));
		num.setL(Integer.parseInt(inputs[1]));
		int start = num.getR(), end = num.getL(), similer = 0, total = 0;
		char prev = ' ', now = ' ';
		boolean good = false;
		while(start <= end) {
			String binary = Integer.toBinaryString(start);
			System.out.print(start + " -> " + binary);
			similer = 0;
			char[] chs = binary.toCharArray();
			prev = chs[0];
			now = ' ';
			for(char c : chs) {
				now = c;
				if(prev == now)	{ similer++; }
				else			{ prev = now; similer = 1; }
				if(similer >= 3) { good = true; }
			}
			if(good)	{ System.out.println("\t [멋진 수]"); good = false; total++; }
			else		{ System.out.println(""); }
			start++;
		}
		
		System.out.println("총 개수 : " + total);
		
	}
	
	
}


class NUM{
	private int L;
	private int R;
	public void setL(int L) { this.L = L; }
	public void setR(int R) { this.R = R; }
	public int getL() { return this.L; }
	public int getR() { return this.R; }
	public void incL() { this.L++; }
	public void incR() { this.R++; }
	
	public NUM() {
		
	}
}
