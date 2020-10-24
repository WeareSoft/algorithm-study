package dami.leetcode.medium;

import java.util.*;

public class Partition_Labels_763 {
	private List<Integer> result = new ArrayList<>();

	public List<Integer> partitionLabels(String S) {
		Set<Character> characters = this.distinct(S);
		Iterator<Character> iter = characters.iterator();

		char next = iter.next();
		int firstIndex = S.indexOf(next);
		int lastIndex = S.lastIndexOf(next);

		while (iter.hasNext()) {
			char current = next;
			next = iter.next();

			lastIndex = Math.max(lastIndex, S.lastIndexOf(current));
			if (S.indexOf(next) == lastIndex + 1) {
				result.add(lastIndex - firstIndex + 1);
				firstIndex = S.indexOf(next);
				lastIndex = S.lastIndexOf(next);
			}
		}

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
