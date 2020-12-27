package programmers;


import java.util.Arrays;
import java.util.function.BiFunction;

/**
 * 징검다리 건너기
 * https://programmers.co.kr/learn/courses/30/lessons/64062
 */
public class Solution64062 {
	private final static int MAX = 200_000_000;

	public int solution3(int[] stones, int k) {
		int[] gapsOfInterval = new int[stones.length - (k - 1)];
		int[] maxValueOfInterval = new int[stones.length - (k - 1)];
		for (int i = 0; i < stones.length - (k - 1); i++) {
			gapsOfInterval[i] = getGapOfInterval(stones, i, k, maxValueOfInterval);
		}
		System.out.println(Arrays.toString(gapsOfInterval));
		System.out.println(Arrays.toString(maxValueOfInterval));
		int minGap = Integer.MAX_VALUE;//  IntStream.of(gapsOfInterval).min().orElseThrow(IllegalAccessError::new);
		for (int n : gapsOfInterval) {
			minGap = Math.min(minGap, n);
		}

		int result = Integer.MAX_VALUE;
		for (int i = 0; i < gapsOfInterval.length; i++) {
			if (gapsOfInterval[i] == minGap) {
				result = Math.min(maxValueOfInterval[i], result);
			}
		}

		return result;
	}

	private int getGapOfInterval(int[] arr, int startIdx, int size, int[] maxValueOfInterval) {
		int max = arr[startIdx];
		int min = arr[startIdx];
		for (int i = startIdx; i < startIdx + size; i++) {
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}
		maxValueOfInterval[startIdx] = max;
		return max - min;
	}

	private int getFuncBetween(BiFunction<Integer, Integer, Integer> func, int[] arr, int startIdx, int size) {
		int result = arr[startIdx];
		for (int i = startIdx + 1; i <= startIdx + size; i++) {
			result = func.apply(result, arr[i]);
		}
		return result;
	}


	public int solution2(int[] stones, int k) {

		int[] nextStone = new int[stones.length];
		for (int crossFriends = 0; crossFriends < MAX; crossFriends++) {
			for (int i = 0, distance = 0; i < stones.length; i++) {
				if (nextStone[i] >= k) {
					return crossFriends;
				}

				if (stones[i] > 0) {
					stones[i]--;
				}

				if (stones[i] == 0) {
					distance++;
				} else {
					distance = 0;
				}
				nextStone[i] = distance;
			}
		}

		throw new IllegalArgumentException();
	}

	public int solution(int[] rocks, int distance) {
		// 이분탐색은 오름차순으로 정렬되어있는 경우를 전제로한다.
		Arrays.sort(rocks);
		return binerySearch(distance, rocks, rocks.length);
	}

	int binerySearch(int distance, int[] rocks, int n) {
		long ans = 0;
		long left = 1, right = distance, mid = 0;

		while (left <= right) {
			int cnt = 0;
			int prev = 0;
			mid = (left + right) / 2;

			for (int i = 0; i < rocks.length; ++i) {
				if (rocks[i] - prev < mid) {
					// mid보다 작은 값이 존재한다는 뜻으로
					// 해당 돌을 제거한다.
					cnt++;
				} else {
					// mid보다 크거나 같은 값이 존재하므로
					// prev를 현재 돌로 초기화한다.
					prev = rocks[i];
				}
			}

			// 마지막 돌과 도착점 사이의 거리도 확인한다.
			if (distance - prev < mid) cnt++;

			if (cnt <= n) {
				// 주어진 n 보다 작거나 같은 만큼 돌을 없애서
				// 최솟값 x를 만들 수 있다.
				ans = mid > ans ? mid : ans;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return (int) ans;
	}

	public static void main(String[] args) {
//		System.out.println(new Solution64062().solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
		System.out.println(new Solution64062().solution(new int[]{2, 3, 2, 2, 1, 0, 2}, 3));
	}
}
