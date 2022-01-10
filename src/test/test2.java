package test;

public class test2 {
	public static void main(String[] args) {
//		Double dblValue= Double.parseDouble("1.99E+07");
//	    String str= String.format("%.2f", dblValue);
//	    System.out.println(str);
	    
	    String AMOUNT = "1.99E+07";
	    
	    String[] AMOUNTS = {"0.8937000000","0.445200000","0.468500000","0.662700000","헐"};
	    
	    for(int i = 0, len = AMOUNTS.length; i < len; i++) {
	    	AMOUNT = AMOUNTS[i];
	    	try {
//				AMOUNT = String.format( "%.9f" , Double.parseDouble(AMOUNT));
//				AMOUNT = String.valueOf((float)(Math.round(Float.parseFloat(AMOUNT)*10000))/100);
				AMOUNT = String.format("%.2f", Float.parseFloat(AMOUNT)*100);
				System.out.println(AMOUNT);
			}catch( Exception e ) {
				System.out.println("걍 문자열 처리된거 : " + AMOUNT);
			}
	    }
	    
	}
}
