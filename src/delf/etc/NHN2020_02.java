package etc;

import java.util.Arrays;

/**
 * @author delf
 */
public class NHN2020_02 {
	public static void main(String[] args) {
//		System.out.println(new NHN2020_02().solution(6, new int[][]{{6, 2, 11, 0, 3, 5}, {6, 3, 0, 9, 0, 5}}));
		System.out.println(new NHN2020_02().solution(10, new int[][]{{6, 12, 0, 2, 8, 4, 0, 7, 3, 6}, {6, 1, 3, 0, 2, 8, 0, 0, 13, 8}, {6, 3, 0, 10, 6, 5, 7, 0, 0, 3}}));
	}

	public int solution(int width, int[][] blocks) {
		int[] ground = new int[width];

		int cement = 0;
		for (int[] block : blocks) {
			/* 쌓기 */
			for (int i = 0; i < ground.length; i++) {
				ground[i] += block[i];
			}

			/* 붓고 계산하기 */
			int maxHeight = 0;
			int maxIndex = 0;
			for (int i = 0; i < ground.length; i++) {
				if (ground[i] > maxHeight) { // 벽 찾아
					for (int j = maxIndex + 1; j < i; j++) { // 물 채워
						cement += (maxHeight - ground[j]);
						ground[j] = maxHeight;
					}
					maxHeight = ground[i];
					maxIndex = i;
				}
			}

			maxHeight = 0;
			maxIndex = 0;
			for (int i = ground.length - 1; i >= 0; i--) {
				if (ground[i] > maxHeight) {
					for (int j = maxIndex - 1; j > i; j--) {
						cement += (maxHeight - ground[j]);
						ground[j] = maxHeight;
					}
					maxHeight = ground[i];
					maxIndex = i;
				}
			}
		}
		return cement;
	}
}
