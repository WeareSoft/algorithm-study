package programmers;

import java.util.HashSet;
import java.util.Set;

/**
 * 불량 사용자
 * https://programmers.co.kr/learn/courses/30/lessons/64064
 */
public class Solution64064 {
    private Set<String> set = new HashSet<>();

    public int solution(String[] userId, String[] bannedId) {
        dfs(0, "", userId, bannedId, new boolean[userId.length]);
        return set.size();
    }

    public void dfs(int idx, String s, String[] userId, String[] bannedId, boolean[] visited) {
        if (idx == bannedId.length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < userId.length; i++) {
                if (s.contains(String.valueOf(i))) sb.append(i);
            }
            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < userId.length; i++) {
            if (visited[i]) {
                continue;
            }

            String regex = bannedId[idx].replace("*", ".");
            if (userId[i].matches(regex)) {
                visited[i] = true;
                dfs(idx + 1, s + i, userId, bannedId, visited);
                visited[i] = false;
            }
        }
    }
}
