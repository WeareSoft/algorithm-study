package dami.programmers.level3;

import java.util.Arrays;
import java.util.Comparator;

public class 단속카메라 {
	public int solution(int[][] routes) {
		Arrays.sort(routes, Comparator.comparingInt(route -> route[1]));

		int camera = 0;
		int point = Integer.MIN_VALUE;
		for (int[] route : routes) {
			// [i][1] 오름차순으로 정렬을 해주었기 때문에 [i][0] 만 비교해주어도 됨
			if (route[0] > point) {
				camera++;
				point = route[1];
			}
		}

		return camera;
	}
}
