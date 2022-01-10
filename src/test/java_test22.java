package test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
숫자의 신은 여러명이 있지만, 그 중에 자연수의 신은 오세준이다. 오세준은 자연수의 신으로 오래오래 살다가 어느 날 음수의 신과 전쟁을 하게 되었다. 오세준은 음수의 신 이다솜을 이기기위해서 큰 숫자를 만들기로 했다.
오세준은 지금 K개의 자연수를 가지고 있다. 오세준은 K개의 수 중에 정확하게 N개의 수를 뽑아내서 그 수를 붙여서 만들 수 있는 수중에 가장 큰 수를 만들고자 한다. 같은 수를 여러 번 이용해도 된다. 단, 모든 수는 적어도 한 번은 이용되어야 한다.

오세준이 현재 가지고 있는 K개의 수가 주어졌을 때, 이 수를 적어도 한 번 이상 이용해서 만들 수 있는 수 중에 가장 큰 수를 출력하는 프로그램을 작성하시오.

예를 들어 지금 오세준이 2, 3, 7 이라는 3개의 수를 가지고 있고, 4개의 수를 뽑아야 한다면, 7732를 만들면 가장 큰 수가 된다.

첫째 줄에 K와 N이 공백을 사이에 두고 주어진다. K와 N은 각각 1,000보다 작거나 같은 자연수이고, N은 K보다 크거나 같다. 둘째 줄에는 K개의 수가 한 줄에 하나씩 주어진다. 각 수는 1,000,000,000보다 작거나 같은 자연수이다. 이 수는 중복되어 들어올 수 있다. 만약 중복되어서 들어오는 경우에는 각 수가 적어도 입력으로 주어진 만큼 이용되어야 한다는 소리다.

예제 입력 1 
3 3
3
2
7
예제 출력 1 
732
*/
public class java_test22 {//K N			K:입력값 갯수   N:생성될 자릿수
	public static Scanner s = null;
	public static int max = -1, len = -1, K = -1, N = -1;
	public static LinkedList<Integer> nums = new LinkedList<Integer>();
	public static void main(String args[]) {
		setInit();
	}
	
	public static void setInit() {
		System.out.println();
		s = new Scanner(System.in);
		String input = s.nextLine();
		String[] inputs = null;
		
		if(input.indexOf(' ') > -1) {
			inputs = input.split(" ");
			try {
				K = Integer.parseInt(inputs[0]);
				N = Integer.parseInt(inputs[1]);
				if(K > N) {
					System.out.println("입력될 숫자의 갯수가 총 자리수보다 많습니다. ["+input+"]");
					setInit();
				}else {
					setNums();
					setN();
				}
				
				for(int a : nums) System.out.print(a); System.out.println();
				
			}catch (NumberFormatException ne) {
				System.out.println("숫자를 입력해 주십시오. ["+input+"]");
				setInit();
			}catch (Exception e) {
				System.out.println("입력오류 ["+input+"]");
				setInit();
			}
			
		}else {
			System.out.println("입력오류 ["+input+"]");
			setInit();
		}
	}
	
	public static void setNums() {
		while(nums.size() < K) {
			try {
				s = new Scanner(System.in);
				nums.add(s.nextInt());
			}catch (Exception e) {
				System.out.println("입력값이 숫자가 아닙니다.");
			}
		}
	}
	
	public static void setN() {
		int max = Collections.max(nums);
		Collections.sort(nums);
		Collections.reverse(nums);
		for(int j = 0; j < (N-K); j++) {
			nums.add(j, max);
		}
	}
}
