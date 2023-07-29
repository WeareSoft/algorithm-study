package dami.programmers.level2;

import java.util.Arrays;

public class 카펫 {
	public int[] solution(int brown, int yellow) {
		int[] answer = {};
		for (int i = 1; i <= yellow / i; i++) {
			if (yellow % i == 0) {
				int height = i + 2;
				int width = (yellow / i) + 2;

				int round = (width + height) * 2 - 4;
				if (brown == round) {
					return new int[]{width, height};
				}
			}
		}
		return answer;
	}

	// 근의 공식
	public int[] solution_wow(int brown, int red) {
		int a = (brown+4)/2;
		int b = red+2*a-4;
		return new int[] {(int)(a+Math.sqrt(a*a-4*b))/2,(int)(a-Math.sqrt(a*a-4*b))/2};
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new 카펫().solution(24, 24)));
	}
}
