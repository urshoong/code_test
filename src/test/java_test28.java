package test;
/*
문제
알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.

길이가 짧은 것부터
길이가 같으면 사전 순으로
입력
첫째 줄에 단어의 개수 N이 주어진다. (1 ≤ N ≤ 20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 주어지는 문자열의 길이는 50을 넘지 않는다.

출력
조건에 따라 정렬하여 단어들을 출력한다. 단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다.

예제 입력 1				  예제 출력 1
13						 i
but						im
i						  it
wont					   no
hesitate				   but
no						 more
more					   wait
no						 wont
more					   yours
it						 cannot
cannot					 hesitat
wait
im
yours

*/


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class java_test28 {
	public static void main(String[] args){
		String[] test = {"13","but","i","wont","hesitate","no","more","no","more","it","cannot","wait","im","yours"};
		execute(test);
	}

	public static void execute(String[] test){
		long timer1 = System.nanoTime();
		long timer2 = System.currentTimeMillis();
		List<String> list = Arrays.asList(test)
								  .stream()
								  .filter(t -> t.replaceAll("[\\d]", "").length() > 0)
								  .distinct()
								  .sorted(Comparator.comparingInt(String::length)
								  					.thenComparing(String::compareTo))
								  .collect(Collectors.toList());
		list.forEach(System.out::println);
//		for(String s : list) { System.out.println(s); }
		System.out.println();
		System.out.println(System.nanoTime() - timer1);
		System.out.println(System.currentTimeMillis() - timer2);
	}
}
