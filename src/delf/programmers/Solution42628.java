package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 이중 우선순위 큐
 * https://programmers.co.kr/learn/courses/30/lessons/42628
 */
public class Solution42628 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution42628().solution(new String[]{"I 7", "I 5", "I -5", "D -1"})));
	}

	public int[] solution(String[] operations) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());

		for (String op : operations) {
			StringTokenizer st = new StringTokenizer(op);
			String judge = st.nextToken();
			int value = Integer.parseInt(st.nextToken());

			if (pq.size() < 1 && judge.equals("D")) {
				continue;
			}

			if (judge.equals("I")) {
				pq.offer(value);
				maxPq.offer(value);
				continue;
			}

			if (value < 0) {
				maxPq.remove(pq.poll());
				continue;
			}

			pq.remove(maxPq.poll());
		}
		if (pq.size() > 0) {
			return new int[]{maxPq.poll(), pq.poll()};
		}

		return new int[]{0, 0};
	}
}
