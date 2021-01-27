package programmers;

import java.util.*;

public class Solution42890 {
    public static void main(String[] args) {
        System.out.println(new Solution42890().solution(new String[][]{{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}}));
    }

    private List<Set<Integer>> candidate = new ArrayList<>();

    public int solution(String[][] relation) {
        boolean[] isVisit = new boolean[relation[0].length];
        dfs(0, isVisit, relation);
        return candidate.size();
    }

    private void dfs(int index, boolean[] isVisit, String[][] relation) {
        if (isVisit.length == index) { // 조건 만족
            Set<Integer> subset = getSubset(isVisit);
            if (!subset.isEmpty() && isMinimal(subset) && isUnique(isVisit, relation)) {
                candidate.add(subset);
            }
            return;
        }

        isVisit[index] = false; // 자신 포함 X
        dfs(index + 1, isVisit, relation);
        isVisit[index] = true; // 자신 포함 O
        dfs(index + 1, isVisit, relation);
    }

    private boolean isMinimal(Set<Integer> set) {
        for (Set<Integer> c : candidate) {
            if (set.containsAll(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean isUnique(boolean[] isVisit, String[][] relation) {
        Set<String> dupChecker = new HashSet<>();
        for (String[] col : relation) {
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < isVisit.length; j++) {
                if (isVisit[j]) {
                    tmp.append(col[j]);
                }
            }
            if (!tmp.toString().equals("") && !dupChecker.add(tmp.toString())) {
                return false;
            }
        }
        return true;
    }

    private Set<Integer> getSubset(boolean[] isVisit) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < isVisit.length; i++) {
            if (isVisit[i]) {
                set.add(i);
            }
        }
        return set;
    }
}