package programmers;

import java.util.*;

/**
 * 여행경로
 * https://programmers.co.kr/learn/courses/30/lessons/43164
 */
public class Solution43164 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution43164().solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}})));
    }

    private List<String> list = new ArrayList<>();
    private String route = "";
    private boolean[] isVisit;

    public String[] solution(String[][] tickets) {
        for (int i = 0; i < tickets.length; i++) {
            isVisit = new boolean[tickets.length];
            String start = tickets[i][0], end = tickets[i][1];

            if (start.equals("ICN")) {
                route = start + ",";
                isVisit[i] = true;
                dfs(tickets, end, 1);
            }
        }

        Collections.sort(list);

        return list.get(0).split(",");
    }

    private void dfs(String[][] tickets, String end, int cnt) {
        route += end + ",";

        if (cnt == tickets.length) {
            list.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            String s = tickets[i][0], e = tickets[i][1];
            if (s.equals(end) && !isVisit[i]) {
                isVisit[i] = true;
                dfs(tickets, e, cnt + 1);
                isVisit[i] = false;
                route = route.substring(0, route.length() - 4);
            }
        }
    }
}
