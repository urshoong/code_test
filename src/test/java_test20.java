package test;

import java.util.HashMap;
import java.util.Scanner;

/**
준규네 집에는 총 N개의 스위치가 있고 이를 편하게 1번부터 N번까지 차례대로 번호를 매겼다. 그리고 준규의 취미는 이 스위치들을 켜고 끄는 것이다.

준규가 하는 스위치를 갖고 노는 일은 크게 두 가지이다. 하나는 A번부터 B번 사이의 스위치 상태를 반전시키는 것이고 다른 하나는 C번부터 D번 사이의 스위치 중 켜져 있는 상태의 스위치의 개수를 세는 것이다.

하지만 준규가 싫증을 느껴 우리가 이 귀찮은 일을 떠맡게 되었고 프로그래밍을 통해 일을 처리하도록 결정하였다.

첫 줄에는 스위치의 개수 N(2 ≤ N ≤ 100,000)과 처리할 일의 개수 M(1 ≤ M ≤ 100,000)이 주어진다. 다음 M개의 줄에 대해 각 줄에 처리할 일에 대한 정보가 담겨진 세 개의 정수 O, Si, Ti가 입력된다. O가 0이면 Si번 스위치부터 Ti번 스위치까지 스위치 상태를 반전시키는 일이고 1이면 Si번 스위치부터 Ti번 스위치까지 중 켜져 있는 상태의 스위치 개수를 묻는 일이다. 단, 초기에는 모든 스위치의 상태는 꺼져있는 상태로 되어있다.

입력에서 켜진 스위치 개수에 대한 답을 한 줄에 하나씩 출력한다.

ex1)
4 5
0 1 2
0 2 4
1 2 3
0 2 4
1 1 4
out)
1
2
*/
public class java_test20 {
	public static Scanner s = new Scanner(System.in);
	public static HashMap<Integer, Boolean> lights = new HashMap<Integer, Boolean>();
	public static String[] firstOptions = null;
	public static String[] jobs = null;
	public static int count = 0;
	public static void main(String args[]) {
		test();
	}
	
	public static void test() {
		boolean flag = true;
		System.out.println();
		int lightCount = 0, jobCount = 0; 
		
		
		String firstLine = "";
		s = new Scanner(System.in);
		if(s.hasNext()) firstLine = s.nextLine();
		firstOptions = firstLine.trim().split(" ");
		if(firstOptions.length != 2) {
			System.out.println("초기 입력값 오류. 전구의 개수(N)과 진행될 작업의 수(M)을 입력해 주십시오.");
			test();
		}else {
			lightCount = Integer.parseInt(firstOptions[0]);
			jobCount = Integer.parseInt(firstOptions[1]);
			if(lightCount < 2) { setTestErr("초기 입력값 오류. 전구의 개수(N)를 확인해 주십시오. (2 ≤ N ≤ 100000)"); flag = false; }
			if(jobCount < 1) { setTestErr("초기 입력값 오류. 작업의 수(M)를 확인해 주십시오. (1 ≤ M ≤ 100000)"); flag = false; }
			if(flag) {
				LightInit(lightCount);
				JobsInit(jobCount);
				setLights();
			}
		}
		
		if(flag) System.exit(0);
	};
	
	public static void setJob() {
		boolean flag = true;
		s = new Scanner(System.in);
		String get = s.nextLine();
		String[] gets = get.trim().split(" ");
		if(gets.length == 3) {
			int gubun = Integer.parseInt(gets[0]);
			int start = Integer.parseInt(gets[1]);
			int end   = Integer.parseInt(gets[2]);
			if(gubun != 0 && gubun != 1) { setJobsErr("작업구분자 입력 오류. 0:전원  1:출력"); flag = false; }
			if(start < 1 || end < 1) { setJobsErr("시작값 또는 종료값은 1부터 시작입니다."); flag = false; }
			if(start > end) { setJobsErr("작업 시작값이 종료값보다 큽니다."+start+":"+end); flag = false; }
			if(start > lights.size()) { setJobsErr("작업 시작값이 전체 전구수보다 큽니다."+start+":"+end); flag = false; }
			if(end > lights.size()) { setJobsErr("작업 종료값이 전체 전구수보다 큽니다."+start+":"+end); flag = false; }
		} else { setJobsErr("작업 입력값 오류. 다시 입력해 주십시오.(작업구분 시작값 종료값)"); flag = false; }
		if(flag) { jobs[count++] = get; }
	}
	
	public static void LightInit(int lightCount) {
		for(int i = 0; i < lightCount; i++) lights.put(i, false);
	}
	
	public static void JobsInit(int jobCount) {
//		showStatus();
		jobs = new String[jobCount];
		while(count < jobCount) setJob();
	}
	
	public static void setTestErr(String msg) {
		System.out.println(msg);
		test();
	}
	
	public static void setJobsErr(String msg) {
		System.out.println(msg);
		setJob();
	}
	
	public static void showStatus() {
		for(int i = 0 ;i < lights.size(); i++) System.out.print("\t"+(i+1)+"["+(lights.get(i) ? "켜짐" : "꺼짐")+"]"); System.out.println();
	}
	
	public static void setLights() {
		System.out.println("---------------------------------------------------------------------------------");
		for(int i = 0, len = jobs.length; i < len; i++) {
			String[] gets = jobs[i].trim().split(" ");
			int gubun = Integer.parseInt(gets[0]);
			int start = Integer.parseInt(gets[1]);
			int end   = Integer.parseInt(gets[2]);
			if(gubun == 0) {//전원
				for(int a = start-1; a < end; a++) { lights.put(a, !lights.get(a)); }
			}else if(gubun == 1) {//출력
				int cnt = 0;
				for(int a = start-1; a < end; a++) { if(lights.get(a)) cnt++; }
				System.out.println(cnt);
			}else {
				System.out.println("작업오류"); System.exit(0);
			}
//			System.out.print("<"+i+">"); showStatus();
		}
//		showStatus();
	}
}
