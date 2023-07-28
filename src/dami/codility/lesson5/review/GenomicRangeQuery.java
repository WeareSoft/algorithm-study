package dami.codility.lesson5.review;

import java.util.*;

// ⭐️ Prefix Sum 알고리즘
// 문제 : https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/
// 결과 : 62%
public class GenomicRangeQuery {

	// 시간 : O(n)
	public int[] solution(String S, int[] P, int[] Q) {
		Map<Character, Integer> dnaMap = new HashMap<>();
		dnaMap.put('A', 1);
		dnaMap.put('C', 2);
		dnaMap.put('G', 3);
		dnaMap.put('T', 4);

		int[][] prefix = new int[S.length()][dnaMap.size()];
		for (int i = 0; i < S.length(); i++) {
			prefix[i][dnaMap.get(S.charAt(i)) - 1]++;
		}

		return null;
	}

	// 시간 : O(n^2) => O(n) 방법 찾기
	public int[] timeout(String S, int[] P, int[] Q) {
		Map<Character, Integer> dnaMap = new HashMap<>();
		dnaMap.put('A', 1);
		dnaMap.put('C', 2);
		dnaMap.put('G', 3);
		dnaMap.put('T', 4);

		int[] result = new int[P.length];
		for (int i = 0; i < P.length; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = P[i]; j <= Q[i]; j++) {
				min = Math.min(min, dnaMap.get(S.charAt(j)));
				if (min == 1) break;
			}
			result[i] = min;
		}

		return result;
	}
}
