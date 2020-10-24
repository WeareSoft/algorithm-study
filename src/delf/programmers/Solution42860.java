package programmers;

import org.omg.CORBA.MARSHAL;

import java.util.Arrays;

/**
 * 조이스틱
 * https://programmers.co.kr/learn/courses/30/lessons/42860
 * 틀린 풀이
 * 참고: https://keepgoing0328.tistory.com/71
 */
public class Solution42860 {
	public int solution(String name) {
		char[] arr = name.toCharArray();
		int moveCnt = 0;
		int index = 0;
		while (true) {
			int inc = getInc(index, arr);
			if (Math.abs(inc) >= arr.length) {
				break;
			}
			moveCnt += ((Math.min(arr[index] - 'A', Math.abs('Z' - arr[index] + 1))) + Math.abs(inc));
			arr[index] = 'A';
			index = inc >= 0 ? (index + inc) % arr.length : (index + inc +arr.length) % arr.length;
		}
		return moveCnt;
	}

	private int getInc(int index, char[] arr) {
		int right;
		for (right = 0; right < arr.length; right++) {
			if (arr[(index + right) % arr.length] != 'A') {
				break;
			}
		}
		int left;
		for (left = 0; left < arr.length; left++) {
			if (arr[(index - left + arr.length) % arr.length] != 'A') {
				break;
			}
		}
		return right < left ? right : -left;
	}

	public static void main(String[] args) {
//		System.out.println(new Solution42860().solution("AABAAAAAAAB"));
//		System.out.println(new Solution42860().solution("JEROEN"));
		System.out.println(new Solution42860().solution("AAZAAAZ"));

	}
}
