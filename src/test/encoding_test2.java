package test;

public class encoding_test2 {
	public static void main(String args[]) throws Exception {
		String str = "테스트";
		String[] cset = {"utf-8","euc-kr","ksc5601","iso-8859-1","x-windows-949", "MS949"};
		
		for(int i = 0, ilen = cset.length; i < ilen; i++) {
			for(int j = 0, jlen = cset.length; j < jlen; j++) {
				System.out.println("["+cset[i]+" to "+cset[j]+"] = "+new String(str.getBytes(cset[i]),cset[j]));
			}
			System.out.println();
		}
	}
}
