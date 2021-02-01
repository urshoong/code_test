package test;
/**
체스판은 8*8크기이고, 검정 칸과 하얀 칸이 번갈아가면서 색칠되어 있다. 가장 왼쪽 위칸 (0,0)은 하얀색이다. 체스판의 상태가 주어졌을 때, 하얀 칸 위에 말이 몇 개 있는지 출력하는 프로그램을 작성하시오.
입력
첫째 줄부터 8개의 줄에 체스판의 상태가 주어진다. ‘.’은 빈 칸이고, ‘F’는 위에 말이 있는 칸이다.

.F.F...F
F...F.F.
...F.F.F
F.F...F.
.F...F..
F...F.F.
.F.F.F.F
..FF..F.

>>     1
*/
public class java_test16 {
	public static void main(String args[]) {
		final int LIMIT = 8;
		int size = LIMIT * LIMIT;
		boolean flag = true;
		int count = 0;
		char[] arr = generator();
		for(int i = 1; i <= size; i++) {
			if(i % 2 == (flag ? 1 : 0) && arr[i-1] == 'F') count++;
			System.out.print( i % 2 == (flag ? 1 : 0) ? "["+arr[i-1]+"]" : " "+arr[i-1]+" " );
			if(i % 8 == 0) { flag = !flag; System.out.println(); }
		}
		System.out.println("\nTotal : " + count);
	}
	
	public static char[] generator() {
		return (".F.F...F"+
				"F...F.F."+
				"...F.F.F"+
				"F.F...F."+
				".F...F.."+
				"F...F.F."+
				".F.F.F.F"+
				"..FF..F.").toCharArray();
	}
}
