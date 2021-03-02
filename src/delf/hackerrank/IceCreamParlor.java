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
            if(cost[i] > money) {
                continue;
            }
            if (map.containsKey(cost[i])) {
                System.out.println((map.get(cost[i]) + 1) + " " + (i + 1));
                return;
            }
            map.put(cost[i], i);
        }

        for (int i = 1; i < money; i++) {
            if (map.containsKey(i) && map.containsKey(money - i)) {
                int one = map.get(i) + 1;
                int another = map.get(money - i) + 1;
                System.out.println(Math.min(one, another) + " " + Math.max(one, another));
                return;
            }
        }
    }
}
