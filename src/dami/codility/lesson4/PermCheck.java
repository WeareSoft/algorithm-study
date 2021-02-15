package dami.codility.lesson4;

import java.util.HashSet;
import java.util.Set;

// 문제 : https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/
// 결과 : https://app.codility.com/demo/results/trainingH5WZAU-9AZ/
public class PermCheck {
	public int solution(int[] A) {
		Set<Integer> distinct = new HashSet<>();
		for (int num : A) {
			if (num > A.length) {
				return 0;
			}

			if (distinct.contains(num)) {
				return 0;
			}

			distinct.add(num);
		}
		return 1;
	}
}
