package hackerrank;

import java.util.*;

public class FrequencyQueries {
    public static void main(String[] args) {
        List<Integer> answer = freqQuery(Arrays.asList(
                new ArrayList<>(Arrays.asList(1, 3))
                , new ArrayList<>(Arrays.asList(1, 38))
                , new ArrayList<>(Arrays.asList(2, 1))
                , new ArrayList<>(Arrays.asList(1, 16))
                , new ArrayList<>(Arrays.asList(2, 1))
                , new ArrayList<>(Arrays.asList(2, 2))
                , new ArrayList<>(Arrays.asList(1, 64))
                , new ArrayList<>(Arrays.asList(1, 84))
                , new ArrayList<>(Arrays.asList(3, 1))
                , new ArrayList<>(Arrays.asList(1, 100))
                , new ArrayList<>(Arrays.asList(1, 10))
                , new ArrayList<>(Arrays.asList(2, 2))
                , new ArrayList<>(Arrays.asList(2, 1))
                , new ArrayList<>(Arrays.asList(1, 67))
                , new ArrayList<>(Arrays.asList(2, 2))
                , new ArrayList<>(Arrays.asList(3, 1))
                , new ArrayList<>(Arrays.asList(1, 99))
                , new ArrayList<>(Arrays.asList(1, 32))
                , new ArrayList<>(Arrays.asList(1, 58))
                , new ArrayList<>(Arrays.asList(3, 2))
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
                    System.out.println("insert " + arg);
                    int afterFrequency = idToFrq.merge(arg, 1, Integer::sum);
                    if (!freqToCnt.containsKey(afterFrequency)) {
                        freqToCnt.put(afterFrequency, 1);
                    } else {
                        System.out.println("afterFrequency = " + afterFrequency);
                        freqToCnt.merge(afterFrequency + 1, 1, Integer::sum);
                        freqToCnt.merge(afterFrequency, -1, Integer::sum);
                    }

                    break;
                case 2:
                    System.out.println("remove " + arg);
                    if (!idToFrq.containsKey(arg) || idToFrq.get(arg).equals(0)) {
                        System.out.println("[pass]\n");
                        continue;
                    }
                    afterFrequency = idToFrq.merge(arg, -1, Integer::sum);
                    freqToCnt.merge(afterFrequency, -1, Integer::sum);
                    freqToCnt.merge(afterFrequency - 1, 1, Integer::sum);
                    break;
                case 3:
                    System.out.println("contain " + arg);
                    answer.add(freqToCnt.containsKey(arg) && !freqToCnt.get(arg).equals(0) ? 1 : 0);
                    break;
            }
            System.out.println(idToFrq);
            System.out.println(freqToCnt);
            System.out.println();
        }
        return answer;
    }
}
