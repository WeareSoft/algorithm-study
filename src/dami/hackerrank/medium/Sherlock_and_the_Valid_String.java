package dami.hackerrank.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

// 1. 문자열 길이만큼 반복하며 각 char을 Map에 저장
// - key : char값, value : 나온 횟수
// 2. count : 서로 다른 값 개수, diff : 서로 다른 두 값 간 차
public class Sherlock_and_the_Valid_String {

	public String isValid(String s) {
		Map<Character, Integer> charsCountMap = getCharsCountMap(s);

		int firstValue = charsCountMap.get(s.charAt(0));
		int changeCount = new HashSet<>(charsCountMap.values()).size();
		int diffCount = 0;
		int diff = 0;
		for (char key : charsCountMap.keySet()) {
			int value = charsCountMap.get(key);
			if (firstValue != value) {
				diffCount++;
				diff = Math.max(Math.abs(firstValue - value), diff);
			}
		}
		int one = (int) charsCountMap.keySet().stream()
				.filter(key -> charsCountMap.get(key) == 1)
				.count();

		if ((one == 1 || diff < 2) && changeCount <= 2 && (diffCount == 1 || diffCount == charsCountMap.size()-1)) {
			return "YES";
		}
		return "NO";
	}

	private Map<Character, Integer> getCharsCountMap(String s) {
		Map<Character, Integer> charsCountMap = new HashMap<>();
		char[] string = s.toCharArray();

		for (char c : string) {
			charsCountMap.put(c, charsCountMap.getOrDefault(c, 0) + 1);
		}

		return charsCountMap;
	}
}
