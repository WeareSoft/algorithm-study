package dailyprogramming;

import java.util.Arrays;

/*
 * 빗물 담기 문제(Trapping Rain Water Problem)입니다.
 *
 * 너비가 1인 막대기들이 서 있고, 그 길이가 배열로 주어집니다.
 * 여기에 비가 내려 물이 고인다고 할 때, 담기는 물의 최대 양을 구하시오.
 *
 * Input: [7, 0, 4, 2, 5, 0, 6, 4, 0, 5]
 * Output: 25
 */
@SuppressWarnings("Duplicates")
public class CT116 {
	public static void main(String[] args) {
		System.out.println(new CT116().solution(new int[]{7, 0, 4, 2, 5, 0, 6, 4, 0, 5}));
	}

	public int solution(int[] sticks) {
		int waterVolume = 0;
		int maxHeight = 0;
		int maxIndex = 0;
		for (int i = 0; i < sticks.length; i++) {
			if (sticks[i] > maxHeight) { // 벽 찾아
				for (int j = maxIndex + 1; j < i; j++) { // 물 채워
					waterVolume += (maxHeight - sticks[j]);
					sticks[j] = maxHeight;
				}
				maxHeight = sticks[i];
				maxIndex = i;
			}
		}

		maxHeight = 0;
		maxIndex = 0;
		for (int i = sticks.length - 1; i >= 0; i--) {
			if (sticks[i] > maxHeight) {
				for (int j = maxIndex - 1; j > i; j--) {
					waterVolume += (maxHeight - sticks[j]);
					sticks[j] = maxHeight;
				}
				maxHeight = sticks[i];
				maxIndex = i;
			}
		}
		return waterVolume;
	}
}
