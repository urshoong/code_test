package test;

public class encoding_test {
	public static void main(String args[]) throws Exception {
		String name = new String("한민호");
		byte[] strs = name.getBytes();
		System.out.println("Length : " + strs.length);
		System.out.println("Hex    : " + BinToHex(strs));
		System.out.println("Value  : " + new String(strs));
		System.out.println();
		strs = name.getBytes("UTF-8");
		System.out.println("Length : " + strs.length);
		System.out.println("Hex    : " + BinToHex(strs));
		System.out.println("Value  : " + new String(strs, "UTF-8"));
		System.out.println();
		name = new String(strs, "UTF-8");
		System.out.println("Length : " + strs.length);
		System.out.println("Hex    : " + BinToHex(strs));
		System.out.println("Value  : " + name);
		System.out.println();
		String convert = new String(name.getBytes("EUC-KR"), "UTF-8");
		System.out.println(convert);
		strs = convert.getBytes();
		System.out.println("Length : " + strs.length);
		System.out.println("euc-kr Hex    : " + BinToHex(strs));
		System.out.println();
		strs = convert.getBytes("UTF-8");
		System.out.println("Length : " + strs.length);
		System.out.println("utf-8  Hex    : " + BinToHex(strs));
		System.out.println();
	}
	
	public static String BinToHex(byte [] buf) {
		String res = "";
		String token = "";
		for (int ix=0; ix<buf.length; ix++) {	
			token = Integer.toHexString(buf[ix]);
//			CommonUtil.println("[" + ix + "] token value : " + token + " len : " + token.length());
			if (token.length() >= 2)
				token = token.substring(token.length()-2);
			else {
				for(int jx=0; jx<2-token.length();jx++)
					token = "0" + token;
			} 				
			res += " " + token;
		}
		
		return res.toUpperCase();
	}
}
