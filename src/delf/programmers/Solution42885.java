package programmers;

import java.util.Arrays;
import java.util.Collections;

/**
 * 구명보트
 * https://programmers.co.kr/learn/courses/30/lessons/42885
 */
public class Solution42885 {
	public static void main(String[] args) {
		System.out.println(new Solution42885().solution(new int[]{70, 50, 80, 50}, 100));
	}

	public int solution(int[] people, int limit) {
		int answer = 0;

		Arrays.sort(people);
		System.out.println(Arrays.toString(people));
		int left = 0;
		int right = people.length - 1;

		while (left <= right) {
			int weight = people[left] + people[right];
			if (weight > limit) {
				right--;
			} else {
				left++;
				right--;
			}
			answer++;
		}
		return answer;
	}
}
