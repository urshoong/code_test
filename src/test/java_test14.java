package test;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

/**
문자열 형식으로 입력 받은 모스코드(dot: . dash:-)를 해독하여 영어 문장으로 출력하는 프로그램을 작성하시오.

글자와 글자 사이는 공백 하나, 단어와 단어 사이는 공백 두개로 구분한다.

예를 들어 다음 모스부호는 "he sleeps early"로 해석해야 한다.

.... .  ... .-.. . . .--. ...  . .- .-. .-.. -.--
모스부호 규칙 표

문자	부호	문자	부호
A	.-		N	-.
B	-...	O	---
C	-.-.	P	.--.
D	-..		Q	--.-
E	.		R	.-.
F	..-.	S	...
G	--.		T	-
H	....	U	..-
I	..		V	...-
J	.---	W	.--
K	-.-		X	-..-
L	.-..	Y	-.--
M	--		Z	--..
*/
public class java_test14 {
	public static void main(String args[]) {
		Gson gson = new Gson();
		JsonObject MOS = new JsonObject();
		String MOS_str =	"{" +
						" \".-\"    : \"A\" , \"-.\"    : \"N\"" +
						",\"-...\"  : \"B\" , \"---\"   : \"O\"" +
						",\"-.-.\"  : \"C\" , \".--.\"  : \"P\"" +
						",\"-..\"   : \"D\" , \"--.-\"  : \"Q\"" +
						",\".\"     : \"E\" , \".-.\"   : \"R\"" +
						",\"..-.\"  : \"F\" , \"...\"   : \"S\"" +
						",\"--.\"   : \"G\" , \"-\"     : \"T\"" +
						",\"....\"  : \"H\" , \"..-\"   : \"U\"" +
						",\"..\"    : \"I\" , \"...-\"  : \"V\"" +
						",\".---\"  : \"J\" , \".--\"   : \"W\"" +
						",\"-.-\"   : \"K\" , \"-..-\"  : \"X\"" +
						",\".-..\"  : \"L\" , \"-.--\"  : \"Y\"" +
						",\"--\"    : \"M\" , \"--..\"  : \"Z\"" +
						"}";
//		System.out.println(MOS_str);
		String INPUT = ".... .  ... .-.. . . .--. ...  . .- .-. .-.. -.--";
		MOS = gson.fromJson(MOS_str, JsonObject.class);
		Iterator<String> keys = MOS.keySet().iterator();
		/*
		while(keys.hasNext()) {
			String key = keys.next();
			System.out.printf("%7s : %s \n", key, MOS.get(key).getAsString());
		}
//		*/
		String[] tokens = INPUT.split(" ");
		for(String s: tokens) System.out.print(s.trim().equals("") ? " " : MOS.get(s).getAsString().toLowerCase());
		
	}
}
