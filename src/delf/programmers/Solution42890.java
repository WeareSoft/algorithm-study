package programmers;

import java.util.*;

public class Solution42890 {
    public int solution(String[][] relation) {
        candidates = new ArrayList<>();

        select(0, new HashSet<>(), relation);
        return candidates.size();
    }

    static ArrayList<HashSet<Integer>> candidates;

    static void select(int pos, HashSet<Integer> selects, String[][] relation) {

        if (pos == relation[0].length) {

            for (HashSet<Integer> candidate : candidates) {
                if (selects.containsAll(candidate)) {
                    return;
                }
            }

            HashSet<String> sets = new HashSet<String>();
            for (String[] strings : relation) {
                StringBuilder temp = new StringBuilder();
                for (int col : selects) {
                    temp.append(strings[col]).append(",");
                }
                if (sets.contains(temp.toString())) {
                    return;
                }
                sets.add(temp.toString());
            }

            candidates.add(selects);
            return;
        }

        HashSet<Integer> copy = new HashSet<>();
        HashSet<Integer> copy2 = new HashSet<>();
        for (Integer val : selects) {
            copy.add(val);
            copy2.add(val);
        }

        select(pos + 1, copy2, relation);
        copy.add(pos);
        select(pos + 1, copy, relation);


    }
}