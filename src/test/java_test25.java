package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

제한사항
마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
completion의 길이는 participant의 길이보다 1 작습니다.
참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
참가자 중에는 동명이인이 있을 수 있습니다.
입출력 예
participant	completion	return
["leo", "kiki", "eden"]	["eden", "kiki"]	"leo"
["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
["mislav", "stanko", "mislav", "ana"]	["stanko", "ana", "mislav"]	"mislav"
입출력 예 설명
예제 #1
"leo"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

예제 #2
"vinko"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

예제 #3
"mislav"는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.

*/
public class java_test25 {
	public static void main(String[] args) {
		List<String[]> participants = new ArrayList<String[]>();
		List<String[]> completions = new ArrayList<String[]>();
		participants.add(new String[]{"leo", "kiki", "eden"});
		participants.add(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"});
		participants.add(new String[]{"mislav", "stanko", "mislav", "ana"});
		completions.add(new String[]{"eden", "kiki"});
		completions.add(new String[]{"josipa", "filipa", "marina", "nikola"});
		completions.add(new String[]{"stanko", "ana", "mislav"});
		
		for(int i = 0, len = participants.size(); i < len; i++) {
			String[] participant = participants.get(i);
			String[] completion = completions.get(i);
			System.out.println(solution(participant, completion));
		}
	}
	
	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		Map<String, Integer> pList = new HashMap<String, Integer>();
		for(String p: participant) pList.put(p, pList.containsKey(p) ? pList.get(p)+1 : 1);
		for(String c : completion) {
//			/*//1안
			pList.put(c, pList.get(c)-1);
			if(pList.get(c) == 0) pList.remove(c);
//			*/
			/*//2안
			if(((int)pList.get(c) - 1) == 0) pList.remove(c); else pList.put(c, pList.get(c)-1);
//			*/
		}
		//그냥
		answer = pList.keySet().toString();
		//기대 답안용
//		Iterator<String> iter = pList.keySet().iterator();
//		while(iter.hasNext()) answer += iter.next();
		
        return answer;
    }
}
