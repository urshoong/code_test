package test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class encoding_test5 {
	public static void main(String args[]) throws Exception {
		//euc_kr_str - euc-kr 문자열
		String str = "한글";
		CharBuffer cbuffer = CharBuffer.wrap((new String(str.getBytes("EUC-KR"), "EUC-KR")).toCharArray());
		Charset utf8charset = Charset.forName("UTF-8");
		ByteBuffer bbuffer = utf8charset.encode(cbuffer);

		//변환된 UTF-8 문자열
		String tmpDecode = new String(bbuffer.array());
		
		System.out.println(tmpDecode);
	}
}
