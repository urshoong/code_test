package test;
/**
문제는 다음과 같다:

6 6

  0   1   2   3   4   5
 19  20  21  22  23   6
 18  31  32  33  24   7
 17  30  35  34  25   8
 16  29  28  27  26   9
 15  14  13  12  11  10
위처럼 6 6이라는 입력을 주면 6 X 6 매트릭스에 나선형 회전을 한 값을 출력해야 한다.


*/
public class java_test6 {
	static int X = 6;
	static int Y = 6;
	public static void main(String args[]) {
		test(X, Y);
	}
	
	public static void test(int x, int y) {
		int[][] matrix = new int[x][y];
		int size = x*y;
		int format = (""+size).toCharArray().length;
		int inc = 1, xval = 0, yval = 0, seq = 0, xmax = x, ymax = y;
		boolean flag = true;//true -> x, false -> y
		
		for(int i = 0; i < size; i ++) {
			if(flag) {	//x increment
				seq++;
				matrix[xval][yval] = i;
				if(seq == xmax) {
					flag = !flag;
					seq = 0;
					xmax -= 1;
					ymax -= 1;
					yval += inc;
				}else {
					xval += inc;
				}
			}else {		//y increment
				seq++;
				matrix[xval][yval] = i;
				if(seq == ymax) {
					flag = !flag;
					seq = 0;
					inc *= -1;
					xval += inc;
				}else {
					yval += inc;
				}
			}
		}
		
		for(int yy = 0; yy < Y; yy++) {
			for(int xx = 0; xx < X; xx++) {
				System.out.print(String.format("%"+format+"d", matrix[xx][yy]) + " ");
			}
			System.out.println();
		}
	}
}
