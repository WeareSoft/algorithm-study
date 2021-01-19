package dami.leetcode.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/problems/top-k-frequent-elements/
public class Top_K_Frequent_Elements_347 {
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> numMap = new HashMap<>();
		for (int num : nums) {
			numMap.put(num, numMap.getOrDefault(num, 0) + 1);
		}

		return numMap.keySet().stream()
				.sorted((key1, key2) -> numMap.get(key2).compareTo(numMap.get(key1)))
				.limit(k)
				.mapToInt(num -> num)
				.toArray();
	}
}

/*
// PriorityQueue 사용한 방법
public int[] topKFrequent(int[] nums, int k) {

    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for(int i: nums)
        map.put(i, map.getOrDefault(i, 0) + 1);

    PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, (n1, n2)->map.get(n1)-map.get(n2));
    for(Map.Entry<Integer, Integer> entry : map.entrySet()){
        queue.add(entry.getKey());
        if(queue.size() > k)
            queue.poll();
    }
    int[] res = new int[k];
    int i = 0;
    while(queue.size() > 0)
        res[i++] = queue.poll();
    return res;

}

*/
