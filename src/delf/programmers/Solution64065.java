package programmers;

import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * 튜플
 * https://programmers.co.kr/learn/courses/30/lessons/64065
 */
public class Solution64065 {
	public int[] solution(String input) {
		List<List<Integer>> list = new ArrayList<>();

		input = input.substring(2, input.length() - 2);
		String[] arr = input.split("},\\{");
		for (String s : arr) {
			list.add(Arrays.stream(s.split(",")).map(Integer::parseInt).collect(toList()));
		}

		list.sort(Comparator.comparingInt(List::size));

		int[] result = new int[list.size()];
		Set<Integer> set = new HashSet<>();
		int cursor = 0;
		for (List<Integer> l : list) {
			for (int n : l) {
				if (set.contains(n)) {
					continue;
				}
				set.add(n);
				result[cursor++] = n;
				break;
			}
		}

		return result;
	}