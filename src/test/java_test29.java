package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
입력
첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.

예제 입력 1         예제 출력 1     
3 1              1           
                 2           
                 3           


예제 입력 2         예제 출력 2    
4 2              1 2        
                 1 3        
                 1 4        
                 2 1        
                 2 3        
                 2 4        
                 3 1        
                 3 2        
                 3 4        
                 4 1        
                 4 2        
                 4 3        


예제 입력 3         예제 출력 3             
4 4              1 2 3 4             
                 1 2 4 3             
                 1 3 2 4             
                 1 3 4 2             
                 1 4 2 3             
                 1 4 3 2             
                 2 1 3 4             
                 2 1 4 3             
                 2 3 1 4             
                 2 3 4 1             
                 2 4 1 3             
                 2 4 3 1             
                 3 1 2 4             
                 3 1 4 2             
                 3 2 1 4             
                 3 2 4 1             
                 3 4 1 2             
                 3 4 2 1             
                 4 1 2 3             
                 4 1 3 2             
                 4 2 1 3             
                 4 2 3 1             
                 4 3 1 2             
                 4 3 2 1             


*/
public class java_test29 {
	public static void main(String[] args) {
		Random r = new Random();
		int total = r.nextInt(8)+1;
		int size  = r.nextInt(total)+1;
		total = 4;
		size = 4;
		System.out.println("total : " + total + "\tsize : " + size);
		execute(total, size);
	}
	
	public static void execute(int a, int b) {
		List<Integer> temp = new ArrayList<>();
		for(int i = 1; i <= a; i++) temp.add(i);
		reculsion(temp, new ArrayList<>(), a, b);
	}
	
	/**
	 * 순열 구하기
	 * @param arr    : 기준 리스트
	 * @param result : 결과를 담아줄 리스트
	 * @param n      : 전체 갯수
	 * @param r      : 뽑을 갯수
	 */
	private static <T> void reculsion(List<T> arr, List<T> result, int n, int r) {
		System.out.println("\nn : " + n + "\tr : " + r);
		if (r == 0) {
			System.out.println(result.toString());
			return;
		}
		
		for (int i = 0; i < n; i++) {
			result.add(arr.remove(i));	System.out.println(result + "\t" + arr);
			reculsion(arr, result, n - 1, r - 1);
			arr.add(i, result.remove(result.size() - 1));
		}
	}
}
