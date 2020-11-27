package programmers;

import java.util.Arrays;

/**
 * 쿼드압축 후 개수 세기
 * https://programmers.co.kr/learn/courses/30/lessons/68936
 */
public class Solution68936 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution68936().solution(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}})));
	}

	public int[] solution(int[][] arr) {
		int size = (int) Math.sqrt(arr.length);
		int[] result = new int[]{0, 0};
		count(arr, size, 0, 0, result);
		return result;
	}

	private void count(int[][] arr, int size, int x, int y, int[] result) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				int cursor = (int) Math.pow(2, size - 1);
				int nx = x + i * cursor;
				int ny = y + j * cursor;
				if (size == 0) {
					result[arr[nx][ny]]++;
				} else {
					count(arr, size / 2, nx, ny, result);
				}
			}
		}
	}

	/*private int[] count1(int[][] arr, int size, int x, int y, int[] result) {
		if (size == 0) {
			int[] tmp = new int[]{0, 0};
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					tmp[arr[x + i][y + j]]++;
				}
			}
			tmp[0] = tmp[0] == 4 ? 1 : tmp[0];
			tmp[1] = tmp[1] == 4 ? 1 : tmp[1];

			return tmp;
		}

		int[] tmp = count1(arr, size/2, )
	}*/
}
