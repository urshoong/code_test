package test;

import java.util.ArrayList;
import java.util.Arrays;

/**
자기 자신을 제외한 모든 양의 약수들의 합이 자기 자신이 되는 자연수를 완전수라고 한다. 예를 들면, 6과 28은 완전수이다. 6=1+2+3 // 1,2,3은 각각 6의 약수 28=1+2+4+7+14 // 1,2,4,7,14는 각각 28의 약수

입력으로 자연수 N을 받고, 출력으로 N 이하의 모든 완전수를 출력하는 코드를 작성하라.
*/

public class test_java4 {
	static final int N = 100;
	public static void main(String args[]) {
		test();
	}
	
	public static void test() {
		ArrayList<Integer> result = new ArrayList<>();
		ArrayList<Integer> list = null;
		for(int i = 2; i <= N; i++) {
			list = new ArrayList<>(Arrays.asList(1));
			int sum = 1;
			for(int j = 2; j < i; j++) {
				if(i % j == 0) {
					list.add(j);
					sum += j;
				}
			}
			if(i == sum) result.add(i);
//			System.out.print("["+i+"] "); for(int j : list) System.out.print(j+" "); System.out.print(i+"\n");//내용 확인용
		}
		
		System.out.print("자연수 "+N+" 이하의 완전수 : ");for(int i : result) System.out.print(i + " ");
	}
}
