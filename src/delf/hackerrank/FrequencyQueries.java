package hackerrank;

import java.util.*;

public class FrequencyQueries {
    public static void main(String[] args) {
        List<Integer> answer = freqQuery2(Arrays.asList(
                new ArrayList<>(Arrays.asList(1, 38)),
                new ArrayList<>(Arrays.asList(1, 38)),
                new ArrayList<>(Arrays.asList(1, 400)),
                new ArrayList<>(Arrays.asList(1, 400)),
                new ArrayList<>(Arrays.asList(1, 400)),
                new ArrayList<>(Arrays.asList(1, 400)),
                new ArrayList<>(Arrays.asList(2, 400)),
                new ArrayList<>(Arrays.asList(2, 38)),
                new ArrayList<>(Arrays.asList(2, 38)),
                new ArrayList<>(Arrays.asList(2, 38)),
                new ArrayList<>(Arrays.asList(3, 0))
        ));
        System.out.println(answer);
    }

    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> answer = new ArrayList<>();

        Map<Integer, Integer> idToFrq = new HashMap<>();
        Map<Integer, Integer> freqToCnt = new HashMap<>();
        for (List<Integer> q : queries) {
            int cmd = q.get(0);
            int arg = q.get(1);

            switch (cmd) {
                case 1:
                    int frq = idToFrq.merge(arg, 1, Integer::sum);
                    if (frq > 1) {
                        freqToCnt.merge(frq - 1, -1, Integer::sum);
                    }
                    freqToCnt.merge(frq, 1, Integer::sum);
                    break;
                case 2:
                    if (!idToFrq.containsKey(arg) || idToFrq.get(arg).equals(0)) {
                        continue;
                    }
                    frq = idToFrq.merge(arg, -1, Integer::sum);
                    freqToCnt.merge(frq + 1, -1, Integer::sum);
                    freqToCnt.merge(frq, 1, Integer::sum);
                    break;
                case 3:
                    answer.add(freqToCnt.containsKey(arg) && !freqToCnt.get(arg).equals(0) ? 1 : 0);
                    break;
            }
        }
        return answer;
    }

    static List<Integer> freqQuery2(List<List<Integer>> queries) {
        List<Integer> answer = new ArrayList<>();

        Map<Integer, Integer> idToFrq = new HashMap<>();
        for (List<Integer> q : queries) {
            int cmd = q.get(0);
            int arg = q.get(1);

            switch (cmd) {
                case 1:
                    idToFrq.merge(arg, 1, Integer::sum);
                    break;
                case 2:
                    if(!idToFrq.containsKey(arg) || idToFrq.get(arg).equals(0)) {
                        continue;
                    }
                    idToFrq.merge(arg, -1, Integer::sum);
                    break;
                case 3:
                    answer.add(idToFrq.containsValue(arg) ? 1 : 0);
                    break;
            }
        }
        System.out.println(idToFrq);
        return answer;
    }
}
