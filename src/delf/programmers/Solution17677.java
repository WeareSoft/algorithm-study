package programmers;

import java.util.*;

/**
 * [1차] 뉴스 클러스터링
 * https://programmers.co.kr/learn/courses/30/lessons/17677
 */
public class Solution17677 {
	public static void main(String[] args) {
		System.out.println(new Solution17677().solution("FRANCE", "french"));
//		System.out.println(new Solution17677().solution("handshake", "shake hands"));
//		System.out.println(new Solution17677().solution("aa1+aa2", "AAAA12"));
//		System.out.println(new Solution17677().solution("E=M*C^2", "e=m*c^2"));

		// aa
		// aa
	}

	private final static int TRANS = 65536;

	public int solution(String str1, String str2) {
		Map<String, Integer> list1 = generateSet(str1.toLowerCase());
		Map<String, Integer> list2 = generateSet(str2.toLowerCase());

		System.out.println(list1);
		System.out.println(list2);

		double intersectionElementsSize = getIntersectionElementsSize(list1, list2);
		System.out.println(intersectionElementsSize);
		double unionElementsSize = getUnionElementsSize(list1, list2);
		System.out.println(unionElementsSize);

		return (int) ((intersectionElementsSize / unionElementsSize) * TRANS);
	}

	private Map<String, Integer> generateSet(String s) {
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
		Map<String, Integer> map = new HashMap<>();
		for (String key : map1.keySet()) {
			if (map2.containsKey(key)) {
				int n = Math.min(map1.get(key), map2.get(key));
				map.put(key, n);
			}
		}
		System.out.println(map);
		int cnt = 0;

		for (String key : map.keySet()) {
			cnt += map.get(key);
		}
		return cnt;
	}

	private int getUnionElementsSize(Map<String, Integer> map1, Map<String, Integer> map2) {
		Map<String, Integer> map = new HashMap<>();
		for (String key : map1.keySet()) {
			if (map2.containsKey(key)) {
				int n = Math.max(map1.get(key), map2.get(key));
				map.put(key, n);
			}
		}
		System.out.println(map);
		int cnt = 0;
		for (String key : map.keySet()) {
			cnt += map.get(key);
		}
		return cnt;
	}
}
