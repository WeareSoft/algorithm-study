package dami.leetcode.medium;

import java.util.Stack;

// https://leetcode.com/problems/daily-temperatures/
// 스팬 문제
public class Daily_Temperatures_739 {
	// 시간복잡도 O(nlogn), 실행시간 : 15ms / 메모리 : 47.4MB
	public int[] dailyTemperatures(int[] T) {
		int[] result = new int[T.length];

		Stack<Integer> r = new Stack<>();
		r.push(0);
		for (int i = 1; i < T.length; i++) {
			while (!r.isEmpty() && T[r.peek()] < T[i]) {
				int index = r.pop();
				result[index] = i - index;
			}
			r.push(i);
		}

		while (!r.isEmpty()) {
			result[r.pop()] = 0;
		}

		return result;
	}
}



/*
// 시간복잡도 O(n^2), 실행시간 : 1095 ms / 메모리 : 47MB
public int[] dailyTemperatures(int[] T) {
	int[] result = new int[T.length];
	for (int i = 0; i < T.length; i++) {
		int count = 0;
		for (int j = i + 1; j < T.length; j++) {
			if (T[i] < T[j]) {
				result[i] = count + 1;
				break;
			}
			count++;
		}

		if (count + i + 1 == T.length) {
			result[i] = 0;
		}
	}

	return result;
}

*/
