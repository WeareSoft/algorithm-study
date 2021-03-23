package programmers;

import java.util.*;

public class Solution67258 {
    public int[] solution(String[] gems) {
        int[] answer = {1, gems.length};
        Set<String> jewels = new HashSet<>();
        Map<String, Integer> counter = new HashMap<>();

        Collections.addAll(jewels, gems);

        int start = 0, end = 0;
        int diff = gems.length;

        while (true) {
            if (counter.size() == jewels.size()) {
                if (diff > end - start) {
                    diff = end - start;
                    answer[0] = start + 1;
                    answer[1] = end;
                }
                if (counter.get(gems[start]) == 1) {
                    counter.remove(gems[start]);
                    start++;
                } else if (counter.get(gems[start]) > 1) {
                    counter.merge(gems[start], -1, Integer::sum);
                    start++;
                }
            } else if (end == gems.length) {
                break;
            } else {
                counter.merge(gems[end], 1, Integer::sum);
                end++;
            }
        }
        return answer;
    }
}
