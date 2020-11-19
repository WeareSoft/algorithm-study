package programmers;

import java.util.Arrays;
import java.util.Comparator;

/**
 * H-index
 * https://programmers.co.kr/learn/courses/30/lessons/42747
 */
public class Solution42747 {

	public static void main(String[] args) {
		System.out.println(new Solution42747().solution(new int[]{1, 3, 0, 6, 5}));
		System.out.println(new Solution42747().solution(new int[]{135, 778, 512, 923, 111, 344}));
	}

	/*
     * 정렬된 배열 내에서는 h번째 논문은 무조건 h회 이상 인용됨
     * '그 차이'가 가장 적어질 때가 정답
	 * */
	public int solution(int[] citations) {
		int[] arr = Arrays.stream(citations).boxed().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();
		for (int h = 0; h < arr.length; h++) {
			if (arr[h] <= h) {
				return h;
			}
		}
		return citations.length;
	}
}
