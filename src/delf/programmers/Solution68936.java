package programmers;

import java.util.Arrays;

/**
 * 쿼드압축 후 개수 세기
 * https://programmers.co.kr/learn/courses/30/lessons/68936
 */
public class Solution68936 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution68936().solution(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}})));
		System.out.println(Arrays.toString(new Solution68936().solution(new int[][]{{1, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 1, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 1, 0, 0, 1}, {0, 0, 0, 0, 1, 1, 1, 1}})));

	}

	public int[] solution(int[][] arr) {
		int[] answer = new int[]{0, 0};
		count(arr, arr.length, 0, 0, answer);
		return answer;
	}

	private int[] count(int[][] arr, int size, int startRow, int startCol, int[] answer) {
		int[] count = new int[]{0, 0}; // 이번 범위의 배열에서의 숫자 카운터

		if (size == 2) { // 최소 단위(2*2)일 때,
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					count[arr[startCol + j][startRow + i]]++; // 각 위치에서 카운팅
				}
			}
			answer[0] += count[0]; // 결과 배열에 추가
			answer[1] += count[1];
		} else { // 최소 단위가 아닐 때,
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					int nextSize = size / 2;
					int nextCol = startCol + (j * nextSize);
					int nextRow = startRow + (i * nextSize);
					int[] tmp = count(arr, nextSize, nextCol, nextRow, answer); // 배열을 4개로 분할해서 카운팅
					count[0] += tmp[0]; // 4분할한 카운팅 합치기
					count[1] += tmp[1];
				}
			}
		}

		/* 중복 보정 */
		if (count[1] == 0) { // 배열 내 모든 요소가 '0'이면 ('1'이 없으면)
			answer[0] -= 3; // '0'의 카운트 -3
		}
		if (count[0] == 0) { // 이하 동문 ('1'인 경우)
			answer[1] -= 3;
		}

		return count;
	}

	private int[] checkCount(int[] answer) {
		if (answer[0] == 4) {
			answer[0] = 1;
		} else if (answer[1] == 4) {
			answer[1] = 1;
		}
		return answer;
	}
}
