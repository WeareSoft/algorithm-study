package programmers;

import java.util.*;

/**
 * [3차] 압축
 * https://programmers.co.kr/learn/courses/30/lessons/17684
 */
public class Solution17684 {

	public static void main(String[] args) {
		System.out.println(DICTIONARY_BASE);
		System.out.println(Arrays.toString(new Solution17684().solution("KAKAO")));
		System.out.println(Arrays.toString(new Solution17684().solution("TOBEORNOTTOBEORTOBEORNOT")));
	}

	private final static Map<String, Integer> DICTIONARY_BASE = new HashMap<>();

	static {
		for (int i = 0; i < 26; i++) {
			DICTIONARY_BASE.put(Character.toString((char) ('A' + i)), i + 1);
		}
	}

	// 1. key를 기준으로 정렬된 map 생성 (문자열이 길이 내림차순)
	// 2. msg가 dictionary의 key로 시작하는지 체크
	// 3. 조건에 맞는 key를 찾으면, 색인을 저장하고 문자열 처리
	// 		- 문자열 처리: 사전에 'key+다음문자'에 해당하는 문자열 추가, msg에서 key에 해당하는 문자열 삭제
	// 4. 반복
	public int[] solution(String msg) {

		// 1. key를 기준으로 정렬된 map 생성 (문자열이 길이 내림차순)
		Map<String, Integer> dictionary = new TreeMap<>((o1, o2) -> {
			if (o1.length() == o2.length()) {
				return o1.compareTo(o2);
			}
			return o2.length() - o1.length();
		});
		dictionary.putAll(DICTIONARY_BASE);


		List<Integer> result = new ArrayList<>();
		while (msg.length() > 0) {
			for (String key : dictionary.keySet()) {
				// +) 문자열 비교로 중간에 연산 줄일 수 있을 듯
				// 2. msg가 dictionary의 key로 시작하는지 체크
				if (msg.startsWith(key)) {
					//  3. 조건에 맞는 key를 찾으면, 색인을 저장하고 문자열 처리
					result.add(dictionary.get(key));
					int length = key.length();
					if (msg.length() > length) {
						// 3-1. 'key+다음문자'에 해당하는 문자열 추가
						dictionary.putIfAbsent(msg.substring(0, length + 1), dictionary.size() + 1);
					}
					// 3-2. msg에서 key에 해당하는 문자열 삭제
					msg = msg.substring(length);
					break;
				}
			}
			// 4. 반복
		}

		return result.stream().mapToInt(Integer::intValue).toArray();
	}


	private Comparator<String> comparator() {
		return (o1, o2) -> {
			if (o1.length() == o2.length()) {
				return o1.compareTo(o2);
			}
			return o2.length() - o1.length();
		};
	}

}
