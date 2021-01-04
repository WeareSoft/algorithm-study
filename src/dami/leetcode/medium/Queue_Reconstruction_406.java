package dami.leetcode.medium;

import java.util.*;

// https://leetcode.com/problems/queue-reconstruction-by-height/
public class Queue_Reconstruction_406 {
	public int[][] reconstructQueue(int[][] people) {
		LinkedList<int[]> reconstructed = new LinkedList<>();

		// 두 height가 같으면 [7, 0] [7, 1]
		// [][1] 오름차순 정렬
		// 두 height가 다르면 [4, 4] [5, 0]
		// height([][0]) 내림차순 정렬
		Arrays.sort(people, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]);

		// 정렬한 상태에서 [][1] 위치에 넣어주기만 하면 reconstructed
		for (int[] person : people) {
			reconstructed.add(person[1], person);
		}

		return reconstructed.toArray(new int[people.length][]);
	}

}
