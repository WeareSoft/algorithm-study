package dami.leetcode.medium;

import java.util.*;

// https://leetcode.com/problems/group-anagrams/
// 주어진 문자열 배열에서 애너그램 그룹핑 해서 반환

// 1. 주어진 문자열 배열에서 각 문자열을 오름차순 소팅한 sortedStrs 생성
// 2. sortedStr을 Key로 하는 Map 생성
// 3. 주어진 문자열 배열 크기만큼 반복하면서
//   소팅한 문자열이 맵에 키로 들어가있지 않으면 put
//   키로 들어있으면 해당 문자열은 해당 키의 값
// 3. map의 values() 반환

public class Group_Anagrams_49 {
	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs.length == 0) {
			return new ArrayList<>();
		}

		Map<String, List<String>> result = new HashMap<>();
		for (String s : strs) {
			char[] str = s.toCharArray();
			Arrays.sort(str);

			String key = String.valueOf(str);
			if (!result.containsKey(key)) {
				result.put(key, new ArrayList<>());
			}
			result.get(key).add(s);
		}

		return new ArrayList<>(result.values());
	}
}

/*  // Stream 활용한 풀이 **Collectors.groupingBy()**
	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groups = Arrays.asList(strs)
			.stream()
			.collect(Collectors.groupingBy(word -> {
				char[] chars = word.toCharArray();
				Arrays.sort(chars);
				return new String(chars);
			}))
			.values()
			.stream()
			.collect(Collectors.toList());

        return groups;
    }

*/

/*  // 마지막 테스트케이스 타임아웃 발생
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> strGroup = new HashMap<>();
		for (String str : strs) {
			String sortedStr = sortString(str);
			strGroup.put(sortedStr, sameValues(sortedStr, strs));
		}
		return new ArrayList<>(strGroup.values());
	}

	private String sortString(String str) {
		char[] chars = str.toCharArray();
		Arrays.sort(chars);

		StringBuilder sb = new StringBuilder();
		for (char c : chars) {
			sb.append(c);
		}
		return sb.toString();
	}

	private List<String> sameValues(String value, String[] strs) {
		return Arrays.stream(strs)
				.filter(str -> sortString(str).equals(value))
				.collect(Collectors.toList());
	}

*/
