package test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
조건
입력값은 한 행의 문자열로 주어지며, 각 값은 공백으로 구분된다.
첫 번째 값은 리스트를 회전하는 양과 방향(음수의 경우 좌측으로, 양수의 경우 우측으로 회전)이다.
첫 번째 값을 제외한 나머지 값은 리스트의 각 항목의 값이다.
회전된 리스트를 문자열로 출력한다.
구현에 이용할 자료구조에 대한 조건이나 제약은 없다.
입력되는 리스트의 항목의 개수는 유한한다.

입출력예
예 1)
입력: 1 10 20 30 40 50
출력: 50 10 20 30 40

예 2)
입력: 4 가 나 다 라 마 바 사
출력: 라 마 바 사 가 나 다

예 3)
입력: -2 A B C D E F G
출력: C D E F G A B

예 4)
입력: 0 똘기 떵이 호치 새초미
출력: 똘기 떵이 호치 새초미
*/
public class java_test11 {
	public static void main(String args[]) {
		System.out.print("input value : ");
		Scanner s = new Scanner(System.in);
		test(s.nextLine());
		System.exit(0);
	}
	
	public static void test(String str) {
		String[] arr = str.split(" ");
		LinkedList<String> list = new LinkedList<>(Arrays.asList(arr));
		String gubun = list.getFirst();
		list.removeFirst();
		if(isNumeric(gubun)) {
			int size = Math.abs(Integer.parseInt(gubun));
			boolean side = Integer.parseInt(gubun) > 0 ? true : false;
			String temp = "";
			System.out.println("size : " + size + " side : " + side);
			for(int i = 0; i < size; i++) {
				if(side) {
					temp = list.getLast();
					list.removeLast();
					list.addFirst(temp);
				}else {
					temp = list.getFirst();
					list.removeFirst();
					list.addLast(temp);
				}
			}
			
			System.out.println("입력 : " + str);
			System.out.print("출력 : "); for(String s : list) System.out.print(s + " ");
		}else {
			System.out.println("구분값이 올바르지 않습니다.");
		}
	}
	
	public static boolean isNumeric(String string) {   
		if(string.equals("")) return false;
		return string.matches("-?\\d+(\\.\\d+)?");
	}
}
