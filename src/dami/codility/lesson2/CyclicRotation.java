package dami.codility.lesson2;

import java.util.ArrayDeque;
import java.util.Deque;

// 문제 : https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
// 결과 : https://app.codility.com/demo/results/training6JDBK4-8SQ/
public class CyclicRotation {
	public int[] solution(int[] A, int K) {
		if (null == A || A.length == 0) {
			return A;
		}

		Deque<Integer> deque = new ArrayDeque<>();
		for (int num : A) {
			deque.push(num);
		}

		for (int i = 0; i < K % A.length; i++) {
			deque.offer(deque.pop());
		}

		int i = 0;
		while (!deque.isEmpty()) {
			A[i] = deque.removeLast();
			i++;
		}

		return A;
	}
}
