package dami.codility.lesson4;

import java.util.HashSet;
import java.util.Set;

// 문제 : https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/
// 결과 : https://app.codility.com/demo/results/trainingV9AWQG-H4S/
public class FrogRiverOne {
	public int solution(int X, int[] A) {
		Set<Integer> leaves = new HashSet<>();
		for (int i = 1; i <= X; i++) {
			leaves.add(i);
		}

		for (int i = 0; i < A.length; i++) {
			leaves.remove(A[i]);

			if (leaves.isEmpty()) {
				return i;
			}
		}

		return -1;
	}
}
