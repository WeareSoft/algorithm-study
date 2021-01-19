package dami.leetcode.medium;

import java.util.*;

// 1. 문자열 분리해서 Set에 저장
// 각 문자별 첫번째 인덱스, 마지막 인덱스를 비교하여 파티션
// 3. Set 길이만큼 반복하면서
//      어떤 문자의 마지막 인덱스(중 가장 큰 값) + 1 == 또 다른 문자의 첫번째 인덱스 확인
//      마지막 인덱스 포함 이전 문자열까지 잘라서 결과 리스트에 add
public class Partition_Labels_763 {
	private final List<Integer> result = new ArrayList<>();

	public List<Integer> partitionLabels(String S) {
		Set<Character> characters = this.distinct(S);
		Iterator<Character> iter = characters.iterator();

		char next = iter.next();
		int firstIndex = S.indexOf(next);
		int lastIndex = S.lastIndexOf(next);

		while (iter.hasNext()) {
			char current = next;
			next = iter.next();

			// 현재 문자의 마지막 인덱스와 이전 문자의 마지막 인덱스 비교
			lastIndex = Math.max(lastIndex, S.lastIndexOf(current));
			// 다음 문자의 첫번째 인덱스와 가장 큰 마지막 인덱스 + 1이 같으면
			// 문자열 파티션
			if (S.indexOf(next) == lastIndex + 1) {
				result.add(lastIndex - firstIndex + 1);
				firstIndex = S.indexOf(next);
				lastIndex = S.lastIndexOf(next);
			}
		}

		// Set의 마지막 문자의 마지막 인덱스는 반복문 내에서 확인할 수 없기 때문에 반복문 종료 후 한 번 더 확인
		lastIndex = Math.max(lastIndex, S.lastIndexOf(next));
		if (S.length() - 1 > lastIndex) {
			result.add(lastIndex - firstIndex + 1);
			result.add(S.length() - (lastIndex - firstIndex + 1));
		} else {
			result.add(S.length() - firstIndex);
		}

		return result;
	}

	private Set<Character> distinct(String s) {
		Set<Character> set = new LinkedHashSet<>();
		char[] string = s.toCharArray();
		for (char c : string) {
			set.add(c);
		}
		return set;
	}
}

/*
	public List<Integer> partitionLabels(String S) {
		int[] last = new int[26];
		for (int i = 0; i < S.length(); ++i)
			last[S.charAt(i) - 'a'] = i;

		int j = 0, anchor = 0;
		List<Integer> ans = new ArrayList();
		for (int i = 0; i < S.length(); ++i) {
			j = Math.max(j, last[S.charAt(i) - 'a']);
			if (i == j) {
				ans.add(i - anchor + 1);
				anchor = i + 1;
			}
		}
		return ans;
	}
*/
