package test;

import java.nio.*;
import java.nio.charset.*;

public class encoding_test3 {
	public static void main(String args[]) throws Exception {
		// UTF-8.
//		String str = new String("헬로월드!");//1
		String str = "헬로월드!";//2
		str = new String(str.getBytes("euc-kr"), "euc-kr");//2

		Charset eucKRCharset = Charset.forName("EUC-KR");
//		CharBuffer sourceBuffer = CharBuffer.wrap(str.toCharArray());//1
//		ByteBuffer resultByteBuffer = eucKRCharset.encode(sourceBuffer);//1
//		byte[] resultBytes =  resultByteBuffer.array();//1
		byte[] resultBytes = str.getBytes(eucKRCharset);//2
		// EUC-KR 의 String 을 생성할 때, 두번째 인자값으로 인코딩 정보를 넣어준다.
		System.out.println(new String(resultBytes, eucKRCharset));
		// 만약 인코딩 정보를 넣지 않는다면 에러 스트링이(�, 0xfffd) 이 출력될 것이다. 
		System.out.println(new String(resultBytes));

		// 원래의 UTF-8 로 디코딩.
		CharBuffer charBuffer = eucKRCharset.decode(ByteBuffer.wrap(resultBytes));
		System.out.println(charBuffer.toString());
	}
}
