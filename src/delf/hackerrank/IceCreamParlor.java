package hackerrank;

import java.util.*;

/**
 * Hash Tables: Ice Cream Parlor
 * https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem
 */
public class IceCreamParlor {
    public static void main(String[] args) {
        whatFlavors(new int[]{2, 2, 4, 3}, 4);
    }

    static void whatFlavors(int[] cost, int money) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < cost.length; i++) {
            if (cost[i] > money) {
                continue;
            }
            if (map.containsKey(cost[i])) {
                if (cost[i] * 2 == money) {
                    System.out.println((map.get(cost[i]) + 1) + " " + (i + 1));
                    return;
                }
            }
            map.put(cost[i], i);
        }

        for (int c : map.keySet()) {
            if (map.containsKey(money - c)) {
                int one = map.get(c) + 1;
                int another = map.get(money - c) + 1;
                System.out.println(Math.min(one, another) + " " + Math.max(one, another));
                return;
            }
        }

        /*for (int i = 1; i < money; i++) {
            int m = map.get(i);
            if (map.containsKey(i) && map.containsKey(money - i)) {
                int one = map.get(i) + 1;
                int another = map.get(money - i) + 1;
                System.out.println(Math.min(one, another) + " " + Math.max(one, another));
                return;
            }
        }*/
    }
}
