package dami.programmers.level2;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

// https://programmers.co.kr/learn/courses/30/lessons/17677

// 1. 주어진 두 문자열 각각 2글자씩 끊고, 소문자로 바꾸고 알파벳 외 문자는 버려서 Map에 저장
// 2. 두 맵에 공통으로 들은 key 중 작은 value의 합 = 교집합 개수
// 3. 두 맵에 공통으로 들은 key 중 큰 value의 합 + 공통 아닌 key의 value의 합 = 합집합 개수
public class 뉴스_클러스터링 {
	private static final Pattern ALPHABET = Pattern.compile("[a-z]*");

	public int solution(String str1, String str2) {
		Map<String, Integer> str1Map = divideString(str1);
		Map<String, Integer> str2Map = divideString(str2);

		int inter = getIntersectionCount(str1Map, str2Map);
		int union = getUnionCount(str1Map, str2Map);

		return union == 0 ? 65536 : (int)((double) inter / union * 65536);
	}

	private Map<String, Integer> divideString(String str) {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length() - 1; i++) {
			String divided = str.substring(i, i + 2).toLowerCase();
			if (ALPHABET.matcher(divided).matches()) {
				map.put(divided, map.getOrDefault(divided, 0) + 1);
			}
		}
		return map;
	}

	private int getIntersectionCount(Map<String, Integer> map1, Map<String, Integer> map2) {
		return map1.keySet().stream()
				.filter(map2::containsKey)
				.mapToInt(key -> Math.min(map1.get(key), map2.get(key)))
				.sum();
	}

	private int getUnionCount(Map<String, Integer> map1, Map<String, Integer> map2) {
		int same = map1.keySet().stream()
				.filter(map2::containsKey)
				.mapToInt(key -> Math.max(map1.get(key), map2.get(key)))
				.sum();
		int diff = map1.keySet().stream()
				.filter(key -> !map2.containsKey(key))
				.mapToInt(map1::get)
				.sum()
				+
				map2.keySet().stream()
				.filter(key -> !map1.containsKey(key))
				.mapToInt(map2::get)
				.sum();
		return same + diff;
	}
}
