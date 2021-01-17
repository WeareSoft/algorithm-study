package programmers;

import java.util.*;

/**
 * [1차] 뉴스 클러스터링
 * https://programmers.co.kr/learn/courses/30/lessons/17677
 */
public class Solution17677 {
	public static void main(String[] args) {
		System.out.println(new Solution17677().solution("FRANCE", "french"));
		System.out.println(new Solution17677().solution("handshake", "shake hands"));
		System.out.println(new Solution17677().solution("aa1+aa2", "AAAA12"));
		System.out.println(new Solution17677().solution("E=M*C^2", "e=m*c^2"));
	}

	private final static int TRANS = 65536;

	public int solution(String str1, String str2) {
		Map<String, Integer> list1 = generateMap(str1.toLowerCase());
		Map<String, Integer> list2 = generateMap(str2.toLowerCase());

		double intersectionElementsSize = getIntersectionElementsSize(list1, list2);
		double unionElementsSize = getUnionElementsSize(list1, list2);

		if (unionElementsSize == 0) {
			return TRANS;
		}

		return (int) ((intersectionElementsSize / unionElementsSize) * TRANS);
	}

	private Map<String, Integer> generateMap(String s) { // 다중집합을 map으로 표현
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length() - 1; i++) {
			if (!Character.isLowerCase(s.charAt(i)) || !Character.isLowerCase(s.charAt(i + 1))) {
				continue;
			}
			map.merge(s.substring(i, i + 2), 1, Integer::sum);
		}

		return map;
	}

	private int getIntersectionElementsSize(Map<String, Integer> map1, Map<String, Integer> map2) {
		Map<String, Integer> result = new HashMap<>(); // 반환용
		for (String key : map1.keySet()) {
			if (map2.containsKey(key)) {
				int n = Math.min(map1.get(key), map2.get(key));
				result.put(key, n);
			}
		}

		int cnt = 0;
		for (String key : result.keySet()) { // value 카운팅
			cnt += result.get(key);
		}
		return cnt;
	}

	private int getUnionElementsSize(Map<String, Integer> map1, Map<String, Integer> map2) {
		Map<String, Integer> result = new HashMap<>(map1); // 반환용(map1 카피)
		for (String key : result.keySet()) { // map1과 map2 중 max 값
			if (map2.containsKey(key)) {
				int n = Math.max(result.get(key), map2.get(key));
				result.put(key, n);
			}
		}

		for (String key : map2.keySet()) { // map1에 없는 map2 데이터 추가
			if (!result.containsKey(key)) {
				result.put(key, map2.get(key));
			}
		}

		int cnt = 0;
		for (String key : result.keySet()) { // value 카운팅
			cnt += result.get(key);
		}
		return cnt;
	}
}
