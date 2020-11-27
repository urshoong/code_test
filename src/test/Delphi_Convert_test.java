package test;


public class Delphi_Convert_test {
	static int Crypt0 = 13579;
	static int Crypt1 = 74102;
	static int Crypt2 = 12337;
	static char[] HexaChar  = {	'0', '1', '2', '3', 
								'4', '5', '6', '7', 
								'8', '9', 'A', 'B', 
								'C', 'D', 'E', 'F' };
	public static void main(String[] args) {
		String str = "I000066";
		
		String encrypt = Encrypt(str, Crypt0);
		System.out.println("   [[[  encrypt  ]]]\n" + encrypt);
		
		String decrypt = Decrypt(encrypt, Crypt0);
		System.out.println("   [[[  decrypt  ]]]\n" + decrypt);
		
	}
	
	/**
	{=============================================================================
	  암호작성
	 ------------------------------------------------------------------------------}
	function Encrypt(const S: String; Key: Word): String;
	var i : byte;
	    FirstResult : String;
	begin
	  SetLength(FirstResult, Length(S));
	
	  For i := 1 to Length(S) do
	      begin
	         FirstResult[i] := char(byte(S[i]) xor (Key shr 8));
	         Key := (byte(FirstResult[i]) + Key) * Crypt1 + Crypt2;
	      end;
	
	 Result := ValueToHex(FirstResult);
	end;
	*/
	
	public static String Encrypt(String S, int Key) {
//		System.out.println(" [[[ Encrypt Start ]]] ");
	    if ((Key < 0) || (Key > 0xFFFF)) throw new IllegalArgumentException("Key is outside the valid range of values");

//	    System.out.println("Input String ::: " + S);
	    
	    byte[] Str = S.getBytes();
	    String temp1 = "", temp2 = "";
	    char[] ch = new char[S.length() * 2];

	    for(int i = 0; i < Str.length; ++i) {
	        Str[i] = (byte) (ByteToUnsignedByte(Str[i]) ^ (Key >> 8));
	        Key = ((ByteToUnsignedByte(Str[i]) + Key) * Crypt1 + Crypt2) & 0xFFFF;
//	        char c = (char)Integer.parseInt(String.format(Locale.US, "%03d", ByteToUnsignedByte(Str[i])));
	        char c = (char) ByteToUnsignedByte(Str[i]);
	        temp1 += c;
	    }
	    
	    ch = ValueToHex(temp1.toCharArray());
	    
	    for(int i = 0,len = ch.length; i < len; i++) {
	    	temp2 += ch[i];
	    }
	    
//	    System.out.println("Output String ::: " + temp2);
	    
	    return temp2;
	}
	
	/**
	{==============================================================================
	  암호풀기
	 ------------------------------------------------------------------------------}
	function Decrypt(const S: String; Key: Word): String;
	var  i : byte;
	     FirstResult : String;
	begin
	  FirstResult := HexToValue(S);
	  SetLength( Result, Length(FirstResult) );
	  For  i := 1 to Length(FirstResult) do
	       begin
	         Result[i] := char(byte(FirstResult[i]) xor (Key shr 8));
	         Key := (byte(FirstResult[i]) + Key) * Crypt1 + Crypt2;
	       end;
	end;
	*/
	
    public static String Decrypt(String S, int Key) {
//    	System.out.println(" [[[ Decrypt Start ]]] ");
    	if ((Key < 0) || (Key > 0xFFFF)) throw new IllegalArgumentException("Key is outside the valid range of values");
    	
//    	System.out.println("Input String ::: " + encrypted);
    	
    	char[] ch = HexToValue(S.toCharArray());
    	String temp = "";
    	byte[] Str = new byte[ch.length];
    	
    	for(int i = 0, len = ch.length; i < len; i++ ) {
    		Str[i] = (byte) ( ByteToUnsignedByte((byte)ch[i]) ^ (Key >> 8) );
    		Key = ((ByteToUnsignedByte((byte)ch[i]) + Key) * Crypt1 + Crypt2 ) & 0xFFFF;
    		char c = (char) ByteToUnsignedByte(Str[i]);
    		temp += c;
    	}
    	
//    	System.out.println("Output String ::: " + temp2);
    	
        return temp;
    }
    
    /**
    {==============================================================================
	  Byte로 구성된 데이터를 Hexadecimal 문자열로 변환
	 ------------------------------------------------------------------------------}
	function ValueToHex(const S : String): String;
	var  i : Integer;
	begin
	  SetLength(Result, Length(S)*2); // 문자열 크기를 설정
	  For  i := 0 to Length(S)-1 do
	       begin
	         Result[(i*2)+1] := HexaChar[Integer(S[i+1]) shr 4];
	         Result[(i*2)+2] := HexaChar[Integer(S[i+1]) and $0f];
	//         ShowMessage('v['+IntToStr((i*2)+1)+'] ::: '+Result[(i*2)+1]+'    v['+IntToStr((i*2)+2)+'] ::: '+Result[(i*2)+2]);
	       end;
	end;
    */
	
	public static char[] ValueToHex(char[] S) {
		char[] result = new char[(S.length * 2) + 1];
		
		for(int i = 0; i < S.length; i++) {
			result[(i*2)+0] = HexaChar[ (CharToUnsignedByte(S[i])) >> 4 ];
			result[(i*2)+1] = HexaChar[ (CharToUnsignedByte(S[i])) & 0x0f ];
		}
		
		return result;
	}
	
	/**
	{==============================================================================
	  Hexadecimal로 구성된 문자열을 Byte 데이터로 변환
	 ------------------------------------------------------------------------------}
	function HexToValue(const S : String) : String;
	var  i : Integer;
	begin
	  SetLength(Result, Length(S) div 2);
	  For i := 0 to (Length(S) div 2) - 1 do
	      begin
	        Result[i+1] := Char(StrToInt('$'+Copy(S,(i*2)+1, 2)));
	      end;
	end;
	*/
	
	public static char[] HexToValue(char[] S) {
		char[] result = new char[S.length/2];
		String temp = "";
		
		for(int i = 0,len = S.length/2; i < len; i++) {
			temp += (char) Integer.parseInt("" + S[(i*2)+0] + S[(i*2)+1], 16);
		}
		result = temp.toCharArray();
		return result;
	}
	
	private static int CharToUnsignedByte(char c) {
	    return ((int) c) & 0xFF;
	}
	
	private static int ByteToUnsignedByte(byte b) {
	    return ((int)b) & 0xFF;
	}
}




