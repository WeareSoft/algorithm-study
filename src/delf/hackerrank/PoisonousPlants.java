package hackerrank;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Poisonous Plants
 * https://www.hackerrank.com/challenges/poisonous-plants/problem
 */
public class PoisonousPlants {

    public static void main(String[] args) {
        System.out.println(poisonousPlants(new int[]{6, 5, 8, 4, 7, 10, 9}));
//        System.out.println(poisonousPlants(new int[]{4, 3, 7, 5, 6, 4, 2}));
    }

    static int poisonousPlants(int[] p) {

        LinkedList<Integer> list = Arrays.stream(p).boxed().collect(Collectors.toCollection(LinkedList::new));

        int answer = 0;
        while (true) {
            LinkedList<Integer> tmpList = new LinkedList<>();
            int tmp = list.getFirst();
            tmpList.add(tmp);
            for (int i = 1; i < list.size(); i++) {
                int n = list.get(i);
                if (tmp > n) {
                    tmpList.add(n);
                }
                tmp = n;
            }
            if (list.size() == tmpList.size()) {
                return answer;
            }
            answer++;
            list = tmpList;
        }
    }
}
