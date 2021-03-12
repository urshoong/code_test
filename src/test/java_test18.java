package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
영어에서는 어떤 글자가 다른 글자보다 많이 쓰인다. 예를 들어, 긴 글에서 약 12.31% 글자는 e이다.

어떤 글이 주어졌을 때, 가장 많이 나온 글자를 출력하는 프로그램을 작성하시오.

첫째 줄부터 글의 문장이 주어진다. 글은 최대 5000글자로 구성되어 있고, 공백, 알파벳 소문자, 엔터로만 이루어져 있다. 그리고 적어도 하나의 알파벳이 있다.

첫째 줄에 가장 많이 나온 문자를 출력한다. 여러 개일 경우에는 알파벳 순으로 앞서는 것부터 모두 공백없이 출력한다.
*/
public class java_test18 {
	public static final char[] ALP = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	public static void main(String[] args) {
		String text1 =	"english is a west germanic\r\n" + 
						"language originating in england\r\n" + 
						"and is the first language for\r\n" + 
						"most people in the united\r\n" + 
						"kingdom the united states\r\n" + 
						"canada australia new zealand\r\n" + 
						"ireland and the anglophone\r\n" + 
						"caribbean it is used\r\n" + 
						"extensively as a second\r\n" + 
						"language and as an official\r\n" + 
						"language throughout the world\r\n" + 
						"especially in common wealth\r\n" + 
						"countries and in many\r\n" + 
						"international organizations";
		String text2 =	"baekjoon online judge";
		test(text1);
		test(text2);
	}
	
	public static void test(String text) {
		HashMap<Character, Integer> ccnt = new HashMap<>();
		for(char c : ALP) ccnt.put(c, 0);
		char[] txt = text.toCharArray();
		for(char t : txt) {
			for(char c : ALP) {
				if(t == c) {
					ccnt.put(c, ccnt.get(c)+1);
				}
			}
		}

		int max = 0, cur = 0;
		Iterator<Character> iter = ccnt.keySet().iterator();
		while(iter.hasNext()) {
			cur = ccnt.get(iter.next());
			max = max >= cur ? max : cur;
		}
		
		for(char c : ALP) if(ccnt.get(c) == max) System.out.print(c);
		System.out.println("\t["+max+"]");
	}
	
}
