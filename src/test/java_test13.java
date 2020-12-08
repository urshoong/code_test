package test;

import java.util.Scanner;

/**
재귀적인 패턴으로 별을 찍어 보자. N이 3의 거듭제곱(3, 9, 27, ...)이라고 할 때, 크기 N의 패턴은 N×N 정사각형 모양이다.

크기 3의 패턴은 가운데에 공백이 있고, 가운데를 제외한 모든 칸에 별이 하나씩 있는 패턴이다.
***
* *
***
N이 3보다 클 경우, 크기 N의 패턴은 공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태이다. 예를 들어 크기 27의 패턴은 예제 출력 1과 같다.
***************************
* ** ** ** ** ** ** ** ** *
***************************
***   ******   ******   ***
* *   * ** *   * ** *   * *
***   ******   ******   ***
***************************
* ** ** ** ** ** ** ** ** *
***************************
*********         *********
* ** ** *         * ** ** *
*********         *********
***   ***         ***   ***
* *   * *         * *   * *
***   ***         ***   ***
*********         *********
* ** ** *         * ** ** *
*********         *********
***************************
* ** ** ** ** ** ** ** ** *
***************************
***   ******   ******   ***
* *   * ** *   * ** *   * *
***   ******   ******   ***
***************************
* ** ** ** ** ** ** ** ** *
***************************
*/
public class java_test13 {
	public static long START = 0;
	public static long END = 0;
	public static int TEMP = 0;
	public static int SIZE = 0;
	public static int INPUT = 0;
	public static int[][] arr = null;
	public static void main(String args[]) {
		Start();
	}
	
	public static void Start() {
		Scanner s = new Scanner(System.in);
		System.out.print("입력(종료:999) = ");
		SIZE = TEMP = s.nextInt();
		START = System.currentTimeMillis();
		setSize();
	}
	
	public static void setSize() {
		if(SIZE == 999) exit();
		else if(SIZE % 3 != 0) { Start(); return; }
		int pow = getPow(SIZE);
		if(pow >= 1 && pow<= 8) {
			System.out.println("입력 : " + SIZE + " 지수 : " + pow);
			arr = new int[SIZE][SIZE];
			setSquare(SIZE, SIZE);
			showSquare();
		}else {
			System.out.println("입력값의 의 크기는 1 ≤ 지수 ≤ 8 입니다.");
			Start();
			return;
		}
	}
	
	public static int getPow(int size) {
		int temp = size, cnt = 0;
		while(temp != 1) {
			cnt++;
			temp = temp / 3;
		}
		return cnt;
	}
	
	public static void setSquare(int xsize, int ysize) {
		int tx = 0, ty = 0, xx = 0, yy = 0;
		TEMP /= 3;
		for(int x = 0; x < SIZE; x++) {
			xx = (x == 0) ? 0 : (x % xsize);
			tx = (xx == 0) ? 0 : xx / TEMP;
			for(int y = 0; y < SIZE; y++) {
				yy = (y == 0) ? 0 : (y % ysize);
				ty = (yy == 0) ? 0 : yy / TEMP;
				if(tx == 1 && ty == 1) arr[x][y] = 1;
			}
		}
		if(TEMP != 1) setSquare(TEMP, TEMP);
	}
	
	public static void showSquare() {
		for(int x = 0; x < SIZE; x++) {
			for(int y = 0; y < SIZE; y++) {
				System.out.print(arr[x][y]==0?'*':' ');
			}
			System.out.println();
		}
		
		END = System.currentTimeMillis();
		System.out.println(String.format("%.3f 초", ((float)(END-START))/1000));
	}
	
	public static void exit() {
		System.out.println("종료");
		System.exit(0);
	}
}
