package dami.hackerrank.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 1. 문자열 길이만큼 반복하며 각 char을 Map에 저장
// - key : char값, value : 나온 횟수
// 2. 각 문자별 문자 개수를 Set에 저장
// - 모두 같은 개수인 경우 == set size는 1 : YES
// - 다른 문자 개수가 2개 초과인 경우 == set size는 2 초과 == 문자 한개 제거해도 개수 통일 불가능 : NO
// - 다른 문자 개수가 2개인 경우 == set size는 2
//   - 둘 중 하나가 1이고, 1의 빈도수가 1인 경우 : YES
//   - 두 값의 차의 절댓값이 1이고, 둘 중 큰 수의 빈도수가 1인 경우 : YES
//   - 나머지 케이스 : NO
public class Sherlock_and_the_Valid_String {

	public String isValid(String s) {
		Map<Character, Integer> charsCountMap = getCharsCountMap(s);
		Set<Integer> otherValues = new HashSet<>(charsCountMap.values());
		int otherValueSize = otherValues.size();

		if (otherValueSize == 1) {
			return "YES";
		}
		if (otherValueSize > 2) {
			return "NO";
		}

		if (otherValues.contains(1) && charsCountMap.values().stream().filter(value -> value == 1).count() == 1) {
			return "YES";
		}
		int diff = Math.abs((int) otherValues.toArray()[0] - (int) otherValues.toArray()[1]);
		int max = Math.max((int) otherValues.toArray()[0], (int) otherValues.toArray()[1]);
		if (diff == 1 && charsCountMap.values().stream().filter(value -> value == max).count() == 1) {
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
