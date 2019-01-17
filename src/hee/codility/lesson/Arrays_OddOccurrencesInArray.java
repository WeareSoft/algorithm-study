package hee.codility.lesson;

import java.util.HashMap;
import java.util.Map;

public class Arrays_OddOccurrencesInArray {
    public int solution(int[] A) {
        if (A.length == 1)
            return A[0];

        Map<Integer, Integer> hashmap = new HashMap<>();
        for (int num : A) {
            if (hashmap.containsKey(num)) {
                hashmap.replace(num, hashmap.get(num) + 1);
                continue;
            }
            hashmap.put(num, 1);
        }

        for (int key : hashmap.keySet()) {
            if (hashmap.get(key) % 2 != 0)
                return key;
        }
        return -1;
    }
}
