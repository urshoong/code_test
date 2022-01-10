/**
문제
강아지와 병아리의 합과 다리의 수를 입력받아 강아지와 병아리가 각각 몇 마리씩인지 구하는 프로그램을 작성하시오. 


입력형식
강아지와 병아리의 합 1000 이하 다리의 합 4000 이하의 음이 아닌 정수가 공백으로 구분하여 입력된다. 하나의 결과가 나온 후에도 계속 새로운 입력을 받다가 0 0 이 입력되면 프로그램을 종료한다.

출력형식
강아지와 병아리가 각각 몇 마리씩인지 공백으로 구분하여 출력한다. 주어진 데이터로 마리수를 정할 수 없을 때는 "0" 을 출력한다. 데이터의 크기가 주어진 범위를 벗어날 경우는 "INPUT ERROR!"를 출력한다.

입력 예
25 80
15 10
1500 20000
0 0

출력 예
15 10
0
INPUT ERROR!

*/
package test;

import java.util.Scanner;

public class java_test24 {
	static final int BIRD = 2;
	static final int DOG = 4;
	public static void main(String[] args) {
		System.out.println("- Start -");
		Scanner s = new Scanner(System.in);
		while(s.hasNext()) {
			String inputLine = s.nextLine();
			if(inputLine.equals("0 0")) {
				System.out.println("- End -");
				System.exit(0);
			}else {
				cal(inputLine);
			}
		}
	}
	
	public static void cal(String in) {
		String result = "";
		String error1 = "INPUT ERROR!";
		String[] inputs = in.split(" ");
		try {
			if(inputs.length != 2) result = error1;
			else {
				try {
					int totalC = Integer.parseInt(inputs[0]);
					int totalF = Integer.parseInt(inputs[1]);
					if(totalF < totalC*BIRD || totalF > totalC*DOG) result = error1;
					else {
//						System.out.println(totalC + "\t" + totalF);
						int maxDOG = totalF / DOG;
						
						cal2(totalC, totalF, maxDOG);
					}
				}catch(Exception e) {
					result = error1;
				}
			}
		}finally {
			System.out.println(result);
		}
	}
	
	public static void cal2(int tC, int tF, int DC) {
		if(DC < 0) { System.out.println(0); return; } 
		int totalC = tC, totalF = tF, DOG_count = DC;
		int BIRD_count = totalC - DOG_count;
//		System.out.println("DOG_count : " + DOG_count + "\tBIRD_count : " + BIRD_count);
//		System.out.println((BIRD_count * BIRD) + (DOG_count * DOG));
//		System.out.println(totalF);
		if(totalF == ((BIRD_count * BIRD) + (DOG_count * DOG)))	System.out.println("DOG:"+DOG_count + "\tBIRD:" + BIRD_count);
		else													cal2(totalC, totalF, (DOG_count-1));
	}
}
