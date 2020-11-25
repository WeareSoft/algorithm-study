package oncoder;

import java.util.*;


/**
 * @author delf
 */
public class Challenge16 {
	public static void main(String[] args) {
		System.out.println(new Challenge16().solution(new int[]{10, 20, 30, 40, 50}));
		System.out.println(new Challenge16().solution(new int[]{123, 123, 456, 456, 456, 123}));
		System.out.println(new Challenge16().solution(new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4}));


	}

	public int solution(int[] events) {
		Map<Integer, Integer> solveCounter = new LinkedHashMap<>();
		Map<Integer, Integer> orderCounter = new HashMap<>();
		for (int i = 0; i < events.length; i++) {
			solveCounter.merge(events[i], 1, Integer::sum);
			orderCounter.putIfAbsent(events[i], i);
		}
		System.out.println(solveCounter);
		System.out.println(orderCounter);

		int maxKey = 0;
		int maxValue = 0;
		for (int key : solveCounter.keySet()) {
			maxValue = Math.max(maxValue, solveCounter.get(key));
			int value = solveCounter.get(key);
			if (maxValue > value) {
				maxValue = value;
				maxKey = key;
			} else if (maxValue == value) {
				if (orderCounter.get(key) > orderCounter.get(maxKey)) {
					maxKey = key;
				}
			}
		}
		return maxKey;
	}
}
