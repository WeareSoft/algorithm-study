package programmers;

import java.util.Arrays;

/**
 * 삼각 달팽이
 * https://programmers.co.kr/learn/courses/30/lessons/68645
 */
public class Solution68645 {
	private final static int[][] incremental = {{1, 0}, {0, 1}, {-1, -1}}; // 아래, 오른쪽, 대각선(좌상)

	public int[] solution(int num) {
		final int endNumber = num * (1 + num) / 2;
		int[][] array = new int[num][num];

		int n = -1, m = 0;
		int direction = 0;

		for (int now = 1; now <= endNumber; ) { // 1 ~ endNumber
			for (int i = 0; i < num; i++) { // n ~ 1
				n += incremental[direction][0];
				m += incremental[direction][1];
				array[n][m] = now++; // 방향 번갈아가면서 대입
			}
			direction = (direction + 1) % incremental.length;
			num--;
		}
		return convert(array, endNumber);
	}

	private int[] convert(int[][] array, int size) {
		int[] result = new int[size];
		int cursor = 0;
		for (int[] m : array) {
			for (int j = 0; j < array[0].length; j++) {
				if (m[j] == 0) {
					break;
				}
				result[cursor++] = m[j];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution68645().solution(6)));
	}
}
