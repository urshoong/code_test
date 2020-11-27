package test;

import java.net.*;

public class encoding_test4 {
	public static void main(String args[]) throws Exception {
		String hangul = "한글";
		String[] encodings = new String[] {"EUC-KR", "UTF-8", "ISO8859-1", "MS949"};

		for (String encoding1 : encodings) {  
		    String encoded = URLEncoder.encode(hangul, encoding1);
		    System.out.println(encoding1+" : "+encoded);
		    System.out.print("\t");

		    for (String encoding2 : encodings) {
		        String decoded = URLDecoder.decode(encoded, encoding2);
		        System.out.print("["+encoding2+"] "+decoded + "\t\t");
		    }
		    System.out.println("\n");
		}
	}
}
