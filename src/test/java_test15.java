package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
https://codingdojang.com/scode/443?answer_mode=hide

위 그림은 {5,2,4,6,1,3} 이라는 배열을 소트하는 방법을 보여준다.
배열의 두번째 인덱스부터 시작하여 시작한 인덱스(검정색 블록) 좌측의 항목 중 자신이 들어가야 할 위치를 판단(소트되도록)하여 이동 한다.
좌측의 배열 요소들은 본인보다 좌측에 값이 삽입되어 들어올 경우 한칸씩 우측으로 이동한다. 단, 삽입되어 들어오는 요소(그림에서 검정색 블록)가 있던 인덱스(원래의 위치)까지만 이동한다.
마지막 인덱스까지 위 과정을 반복한다.
이와 같은 기능을 하는 소트 프로그램을 작성하시오.
*/
public class java_test15 {
		public static final int[] LIST = {5,2,4,6,1,3};
	public static void main(String args[]) {
		test();
		test2();
		test3();
	}
	
	public static void test() {
		System.out.println("\nTEST 1");
		ArrayList<Integer> list = new ArrayList<Integer>(); { for(int i : LIST) list.add(i); };
		ArrayList<Integer> result = new ArrayList<>();
		printList(list, true);
		for(int i = 0, len = list.size(); i < len; i++) {
			int min = Collections.min(list);
			int idx = list.indexOf(min);
			result.add(min);
			list.remove(idx);
		}
		printList(result, false);
	}
	
	public static void test2(){
		System.out.println("\nTEST 2");
		ArrayList<Integer> list = new ArrayList<Integer>(); { for(int i : LIST) list.add(i); };
		printList(list, true);
		Collections.sort(list);
		printList(list, false);
	}
	
	public static void test3() {
		System.out.println("\nTEST 3");
		ArrayList<Integer> list = new ArrayList<Integer>(); { for(int i : LIST) list.add(i); };
		printList(list, true);
		for(int i = 1, ilen = list.size(); i < ilen; i++) {
			int current = list.get(i);	System.out.print(current+"-");
			for(int j = 0; j < i; j++) {
				int temp = list.get(j);
				if(current < temp) {
					int curIdx = list.indexOf(current);
					int tmpIdx = list.indexOf(temp);
					list.remove(curIdx);
					list.add(tmpIdx, current);
					break;
				}
			}
			printList(list, false);
		}
		printList(list, false);
	}
	
	public static void printList(ArrayList<Integer> list, boolean flag) {
		String msg = flag ? "Before Sorting\t: " : "After Sorting\t: ";
		System.out.print(msg); for(int i : list) System.out.print(i + " "); System.out.println();
	}
}
