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

	public int solution(int[] citations) {
		int[] arr = Arrays.stream(citations).boxed().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= i) {
				return i;
			}
		}
		return citations.length;
	}
}
