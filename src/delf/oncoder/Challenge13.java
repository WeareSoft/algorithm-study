package oncoder;

import java.util.*;

/**
 * @author delf
 */
public class Challenge13 {
	public int[] solution(int[] sequence) {
		List<Integer> list = new ArrayList<>();
		for (int i : sequence) {
			if (list.contains(i)) {
				list.remove((Integer) i);
			}
			list.add(i);
		}
		return list.stream().mapToInt(Integer::intValue).toArray();
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Challenge13().solution(new int[]{1, 2, 5, 4, 4, 4, 2, 3})));
	}
}
