package test;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
문자열을 입력받아서, 같은 문자가 연속적으로 반복되는 경우에 그 반복 횟수를 표시하여 문자열을 압축하기.

입력 예시: aaabbcccccca

출력 예시: a3b2c6a1
*/
public class java_test9 {
	public static void main(String args[]) {
		System.out.print("input text(exit to '!q') : ");
		Scanner s = new Scanner(System.in);
		while(true) {
			test(s.next());
		}
	}
	
	public static void test(String s) {
		String pattren = "^[a-zA-Z]*$";
		boolean exp = Pattern.matches(pattren, s);
		if(s.equals("!q")) {
			System.out.println("프로그램 종료");
			System.exit(0);
		}else if(!exp) {
			System.out.println("알파벳만 입력 가능합니다.");
		}else {
			StringBuffer sb = new StringBuffer();
			char[] c = s.toCharArray();
			char pre = (char)0, now = (char)0;
			int cnt = 0;
			for(int i = 0, len = c.length; i < len; i++) {
				if(i == 0) {
					pre = c[i];
					cnt++;
					sb.append(pre);
				} else {
					now = c[i];
					if(pre == now) {
						cnt++;
					}else {
						sb.append(cnt).append(now);
						cnt = 1;
					}
					pre = now;
				}
			}
			sb.append(cnt);
			System.out.println(sb);
		}
	}
}
